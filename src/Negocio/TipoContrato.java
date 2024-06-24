package Negocio;

import Datos.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoContrato {

    Conexion obj = new Conexion();
    String strSQL;
    ResultSet rs;

    public ResultSet cargarTipoContratos() throws Exception {
        try {
            strSQL = "select * from tipo_contrato;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al obtener los tipos de contrato --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet cargarHorariosDeTipoContrato(String tipocontrato) throws Exception {
        try {
            strSQL = "select tc.nombre,ht.horaentrada,ht.horasalida,ht.turno from tipo_contrato tc "
                    + "inner join horario_trabajo ht on tc.id=ht.idtipocontrato where tc.nombre=?;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, tipocontrato);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al obtener los horarios del tipo de contrato seleccionado --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public int obtenerIdTipoContrato(String tipo) throws Exception {
        int idtipoc = 0;
        try {
            strSQL = "select id,nombre from tipo_contrato where nombre=?;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, tipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                idtipoc = rs.getInt("id");
            }
            return idtipoc;
        } catch (Exception ex) {
            throw new Exception("Error al obtener id de tipo de contrato --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    //Mantenimiento:
    public ResultSet listarTodo() throws Exception {
        strSQL = "select * from tipo_contrato;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new Exception("Error al listar los tipos de contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet filtrar(String nombre) throws SQLException, Exception {
        strSQL = "select * from tipo_contrato where nombre ilike ?;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new Exception("Error al filtrar los tipos de contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void registrarTipoContrato(String tipocont) throws Exception {
        strSQL = "insert into tipo_contrato(nombre) values(?);";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, tipocont);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar el tipo de contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void modificarTipoContrato(int idtipocont, String tipocont) throws Exception {
        strSQL = "update tipo_contrato set nombre=? where id=?";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, tipocont);
            ps.setInt(2, idtipocont);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al modificar el tipo de contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void eliminarTipoContrato(int idtipocont) throws Exception {
        strSQL = "delete from tipo_contrato where id=?";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idtipocont);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al modificar el tipo de contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean existeRegistrosReferenciados(int idtipocont) throws Exception {
        boolean existe;
        int cant = 0;
        String strSQL1 = "select count(*) as cant from contrato where idtipocontrato=?";
        String strSQL2 = "select count(*) as cant from horario_trabajo where idtipocontrato=?";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps1 = micon.prepareStatement(strSQL1);
            ps1.setInt(1, idtipocont);
            PreparedStatement ps2 = micon.prepareStatement(strSQL2);
            ps2.setInt(1, idtipocont);
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            while (rs1.next()) {
                cant = rs1.getInt("cant");
            }
            while (rs2.next()) {
                cant += rs2.getInt("cant");
            }
            if (cant >= 1) {
                existe = true;
            } else {
                existe = false;
            }
            return existe;
        } catch (SQLException e) {
            throw new Exception("Error al obtener los registros referenciados a tipo de contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
}
