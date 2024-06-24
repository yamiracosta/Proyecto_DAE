package Negocio;

import Datos.Conexion;
import java.sql.*;

public class Deduccion {

    Conexion obj = new Conexion();
    String strSQL;
    ResultSet rs;

    public ResultSet cargarFondosDePensiones() throws Exception {
        try {
            strSQL = "select d.nombre,td.tipo,td.id from deduccion d inner join tipo_deduccion td on d.idtipodeduccion=td.id where td.id=2;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al obtener los fondos de pensiones disponibles --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public int obtenerIdDeduccion(String deduccion) throws Exception {
        int iddeduccion = 0;
        try {
            strSQL = "select * from deduccion where nombre=?;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            if (deduccion.equals("EsSalud")) {
                deduccion = "EsSalud";
            }
            ps.setString(1, deduccion);
            rs = ps.executeQuery();

            while (rs.next()) {
                iddeduccion = rs.getInt("id");
            }
            return iddeduccion;
        } catch (Exception ex) {
            throw new Exception("Error al obtener el id de la deducción --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void registrarDetalleDeduccion(int idcontrato, int iddeduccion, double monto) throws Exception {
        try {
            obj.conexion();
            strSQL = "INSERT INTO public.detalle_deduccion(idcontrato, iddeduccion, monto) VALUES (?, ?, ?);";
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcontrato);
            ps.setInt(2, iddeduccion);
            ps.setDouble(3, monto);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al insertar en detalle_deduccion --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet obtenerDetallesDeduccionesContrato(int idcontrato) throws Exception {
        strSQL = "select td.tipo as tipodeduccion,ded.nombre as retencion, dd.monto as monto_retenido from detalle_deduccion dd " +
                 "inner join deduccion ded on ded.id=dd.iddeduccion inner join tipo_deduccion td on td.id=ded.idtipodeduccion " +
                 "inner join contrato c on dd.idcontrato=c.id where c.id=?;";
        obj.conexion();
        Connection micon = obj.getCon();
        try{
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcontrato);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception(" --> Error al obtener detalles de deducciones de contrato" + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    //Mantenimiento:
    public ResultSet listarDeducciones() throws Exception {
        try {
            strSQL = "select d.id,d.nombre,td.tipo "
                    + "from deduccion d "
                    + "inner join tipo_deduccion td on td.id=d.idtipodeduccion;";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception(" --> Error al obtener deducciones" + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet filtrarDeduccion(String deduccion) throws Exception {
        try {
            strSQL = "select d.id,d.nombre,td.tipo "
                    + "from deduccion d "
                    + "inner join tipo_deduccion td on td.id=d.idtipodeduccion where d.nombre ilike ?;";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + deduccion + "%");
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception(" --> Error al filtrar deducciones" + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public int obtenerIdTipoDeduccion(String tipodeduccion) throws Exception {
        try {
            int idtipo = -1;
            String SQL = "select id as codigo from tipo_deduccion where tipo=?;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(SQL);
            ps.setString(1, tipodeduccion);
            rs = ps.executeQuery();

            while (rs.next()) {
                idtipo = rs.getInt("codigo");
            }

            return idtipo;
        } catch (Exception ex) {
            throw new Exception("Error al obtener el id del tipo de deducción --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void registrarDeduccion(String nombre, String tipoded) throws Exception {
        try {
            //nombre=dedu, tipoded=Aporte a fondo de pensiones
            int idtipoded = obtenerIdTipoDeduccion(tipoded);
            strSQL = "insert into deduccion(nombre,idtipodeduccion) values(?,?)";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, nombre);
            ps.setInt(2, idtipoded);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al registrar deducción --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void modificarDeduccion(String nombre, String tipoded, int idded) throws Exception {
        try {
            int idtipoded = obtenerIdTipoDeduccion(tipoded);
            strSQL = "update deduccion set nombre=?,idtipodeduccion=? where id=?";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, nombre);
            ps.setInt(2, idtipoded);
            ps.setInt(3, idded);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al modificar deducción --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void eliminarDeduccion(int idded) throws Exception {
        try {
            strSQL = "delete from deduccion where id=?";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idded);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al eliminar deducción --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean existenRegistrosReferenciados(int idded) throws Exception {
        try {
            boolean existe = false;
            int cant = 0;
            strSQL = "select count(*) as cant from detalle_deduccion where iddeduccion=?";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idded);
            rs = ps.executeQuery();

            while (rs.next()) {
                cant = rs.getInt("cant");
            }

            if (cant >= 1) {
                existe = true;
            }
            return existe;
        } catch (Exception ex) {
            throw new Exception("Error al obtener registros referenciados a deducción --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public ResultSet listarDeduccionesContratoCliente(int idempl) throws Exception {
        try {
            strSQL = """
                     select d.nombre as retencion,td.tipo as tiporetencion, dd.monto as montoretenido
                     from detalle_deduccion dd
                     inner join deduccion d on dd.iddeduccion=d.id
                     inner join tipo_deduccion td on d.idtipodeduccion=td.id
                     inner join contrato c on c.id=dd.idcontrato
                     inner join empleado e on e.id=c.idempleado
                     where c.estado='V' and e.id=? order by dd.iddeduccion;
                     """;
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idempl);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception(" --> Error al obtener deducciones del contrato del cliente: " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public String obtenerNombreDeduccionDiferente(String nombre) throws Exception{
        try {
            String nombreDif="";
            strSQL = """
                     select d.nombre from tipo_deduccion td
                     inner join deduccion d on d.idtipodeduccion=td.id
                     where td.id=2 and d.nombre!=?;
                     """;
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombreDif = rs.getString("nombre");
            }
            return nombreDif;
        } catch (Exception ex) {
            throw new Exception(" --> Error al obtener nombre de retención diferente: " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public int obtenerIdDeduccionExistente(int idcontr) throws Exception {
        strSQL = """
                 select iddeduccion from detalle_deduccion dd
                 inner join deduccion d on dd.iddeduccion=d.id
                 inner join tipo_deduccion td on td.id=d.idtipodeduccion
                 where idcontrato=? and td.tipo='Aporte a fondo de pensiones';
                 """;
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        int iddedexs = -1;
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcontr);
            rs = ps.executeQuery();
            while (rs.next()) {
                iddedexs = rs.getInt("iddeduccion");
            }
            return iddedexs;
        } catch (SQLException e) {
            throw new Exception("Error al obtener ID de deducción existente --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

}
