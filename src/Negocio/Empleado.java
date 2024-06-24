package Negocio;

import Datos.Conexion;
import java.sql.*;
import javax.swing.JComboBox;

public class Empleado {

    public static int ID_USUARIO_LOGGEADO = -1;

    Conexion obj = new Conexion();
    String strSQL;
    ResultSet rs;

    TipoDocumento objTD = new TipoDocumento();

    public String obtenerNombresEmpleado(int idemp) throws Exception {
        strSQL = "select concat(ape_paterno || ' ' || ape_materno || ' ' || nombres) as nombres from empleado where id=?";
        try {
            String nombres = null;
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idemp);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombres = rs.getString("nombres");
            }
            return nombres;
        } catch (Exception e) {
            throw new Exception("Error al obtener nombres de empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    //Mantenimiento
    public int obtenerIdEmpleado(String numdoc, String tipodoc) throws Exception {
        int id = 0;
        strSQL = "select e.id from empleado e inner join tipo_documento td on e.idtipodocumento=td.id "
                + "where e.numdocumento=? and td.nombre=?;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, numdoc);
            ps.setString(2, tipodoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener ID de empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
        return id;
    }

    public boolean existeContratoVigente(int id) throws Exception {
        boolean bandera = false;
        strSQL = "select count(*) from contrato where idempleado=? and estado='V';";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int contador = rs.getInt("count");
                if (contador > 0) {
                    bandera = true;
                }
                return bandera;
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener lista de contratos vigentes de empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
        return false;
    }

    public boolean tieneContratosAnterioresValidos(int id) throws Exception {
        boolean bandera = false;
        strSQL = "select count(*) from contrato where idempleado=? and estado='T';";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int contador = rs.getInt("count");
                if (contador >= 1) {
                    bandera = true;
                }
                return bandera;
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener número de contratos anteriores de empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
        return false;
    }

    public ResultSet filtrarEmpleado(String nombre) throws Exception {
        strSQL = "select e.numdocumento,td.nombre as nombretipodoc,e.nombres,e.ape_paterno,e.ape_materno,"
                + "te.nombre as nombretipoempleado,a.nombre as nombrearea "
                + "from empleado e "
                + "inner join tipo_documento td on e.idtipodocumento=td.id "
                + "inner join tipo_empleado te on e.idtipoempleado=te.id "
                + "inner join area a on te.idarea=a.id "
                + "where e.numdocumento like upper(?);";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener la lista de empleados con contrato vigente--> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }

    }

    public ResultSet filtrarEmpleadoConContratoVigente(String nombre) throws Exception {
        strSQL = "select c.id as codigocontrato, e.numdocumento,td.nombre as nombretipodoc,e.nombres,e.ape_paterno,e.ape_materno,"
                + "te.nombre as nombretipoempleado,a.nombre as nombrearea "
                + "from empleado e "
                + "inner join tipo_documento td on e.idtipodocumento=td.id "
                + "inner join tipo_empleado te on e.idtipoempleado=te.id "
                + "inner join area a on te.idarea=a.id "
                + "inner join contrato c on c.idempleado=e.id "
                + "where e.numdocumento like upper(?) and c.estado='V';";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener la lista de empleados --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }

    }

    public double obtenerSalarioTipoEmpleado(String tipo) throws Exception {
        double sueldo = 0;
        strSQL = "select remuneracion from tipo_empleado where nombre=?";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                sueldo = rs.getDouble("remuneracion");
            }
            return sueldo;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener el salario --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet filtrarEmpleadoCredencialesDNI(String numdoc) throws Exception {
        strSQL = """
                 select
                 concat(e.nombres || ' ' || e.ape_paterno || ' ' || e.ape_materno) as nombres,
                 td.nombre as tipodocumento, e.numdocumento
                 from empleado e
                 inner join tipo_documento td on td.id=e.idtipodocumento
                 where numdocumento ilike ?
                 and e.estado='V';
                 """;
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + numdoc + "%");
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al filtrar empleados por número de documento --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean registrarCredenciales(String usu, String con, String numdoc, String tipdoc) throws Exception {
        try {
            strSQL = "select pa_registrar_credenciales(?,?,?,?) as exito";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            boolean exito = false;
            int idtipodoc = objTD.obtenerIdTipoDocumento(tipdoc);
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, usu);
            ps.setString(2, con);
            ps.setString(3, numdoc);
            ps.setInt(4, idtipodoc);
            rs = ps.executeQuery();
            while (rs.next()) {
                exito = rs.getBoolean("exito");
            }
            return exito;
        } catch (SQLException ex) {
            throw new Exception("Error al registrar credenciales --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet filtrarEmpleadoConContratoVigenteYVacacionesPagadas(String nombre) throws Exception {
        strSQL = "select e.numdocumento,td.nombre as nombretipodoc,e.nombres,e.ape_paterno,e.ape_materno,"
                + "te.nombre as nombretipoempleado,a.nombre as nombrearea "
                + "from empleado e "
                + "inner join tipo_documento td on e.idtipodocumento=td.id "
                + "inner join tipo_empleado te on e.idtipoempleado=te.id "
                + "inner join area a on te.idarea=a.id "
                + "inner join contrato c on c.idempleado=e.id "
                + "where e.numdocumento like upper(?) and c.estado='V' and c.vacacionespagadas=true;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + nombre + "%");
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener la lista de empleados --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void darDeAltaEmpleado(int idempl) throws Exception {
        strSQL = "update empleado set estado='V' where id=?";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idempl);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error al dar de alta nuevamente a empleado --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    //------------------------------------------------------REPORTES---------------------------------------------------------
    

}
