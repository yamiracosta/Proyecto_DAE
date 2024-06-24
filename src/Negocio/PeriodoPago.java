package Negocio;

import Datos.Conexion;
import java.sql.*;

public class PeriodoPago {

    Conexion obj = new Conexion();
    String strSQL;
    ResultSet rs;

    public ResultSet cargarPeriodosPago() throws Exception {
        try {
            strSQL = "select * from periodo_pago order by nombre desc;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al obtener los periodos de pago --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public int obtenerIdPeriodoPago(String periodo) throws Exception {
        int idperiodo = 0;
        try {
            strSQL = "select * from periodo_pago where nombre=?;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, periodo);
            rs = ps.executeQuery();
            while (rs.next()) {
                idperiodo = rs.getInt("id");
            }
            return idperiodo;
        } catch (Exception ex) {
            throw new Exception("Error al obtener id de tipo de contrato --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public String obtenerNombrePeriodoPago(int idcont) throws Exception {
        String periodo = "";
        strSQL = "select pp.nombre as periodopago\n"
                + "from contrato c\n"
                + "inner join periodo_pago pp on c.idperiodopago=pp.id\n"
                + "inner join tipo_contrato tc on tc.id=c.idtipocontrato\n"
                + "inner join horario_trabajo ht on ht.id=c.idhorariotrabajo\n"
                + "inner join empleado e on e.id=c.idempleado\n"
                + "where c.id=?;";
        try {
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcont);
            rs = ps.executeQuery();
            while (rs.next()) {
                periodo = rs.getString("periodopago");
            }
            return periodo;
        } catch (Exception ex) {
            throw new Exception("Error al obtener nombre del periodo de pago del contrato --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    //Mantenimiento
    public ResultSet listarPeriodos() throws Exception {
        try {
            strSQL = "select * from periodo_pago;";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception(" --> Error al obtener periodos de pago" + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet filtrarPeriodo(String periodo) throws Exception {
        try {
            strSQL = "select * from periodo_pago where nombre ilike ?;";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + periodo + "%");
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception(" --> Error al filtrar periodos de pago" + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void registrarPeriodoPago(String periodo, String descr) throws Exception {
        try {
            strSQL = "insert into periodo_pago(nombre,descripcion) values(?,?)";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, periodo);
            if (descr.isBlank()) {
                ps.setNull(2, Types.NULL);
            } else {
                ps.setString(2, descr);
            }
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al registrar periodo de pago --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void modificarPeriodoPago(String periodo, String descr, int idperiodo) throws Exception {
        try {
            strSQL = "update periodo_pago set nombre=?,descripcion=? where id=?";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, periodo);
            if (descr.isBlank()) {
                ps.setNull(2, Types.NULL);
            } else {
                ps.setString(2, descr);
            }
            ps.setInt(3, idperiodo);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al modificar periodo de pago --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void eliminarPeriodoPago(int idperiodo) throws Exception {
        try {
            strSQL = "delete from periodo_pago where id=?";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idperiodo);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw new Exception("Error al eliminar periodo de pago --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean existenRegistrosReferenciados(int idperiodo) throws Exception {
        try {
            boolean existe = false;
            int cant = 0;
            strSQL = "select count(*) as cant from contrato where idperiodopago=?";
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idperiodo);
            rs = ps.executeQuery();

            while (rs.next()) {
                cant = rs.getInt("cant");
            }

            if (cant >= 1) {
                existe = true;
            }
            return existe;
        } catch (Exception ex) {
            throw new Exception("Error al obtener registros referenciados a periodo de pago --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

}
