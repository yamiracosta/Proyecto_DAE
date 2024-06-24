package Negocio;

import Datos.Conexion;
import java.sql.*;

public class HorarioTrabajo {

    Conexion obj = new Conexion();
    String strSQL;
    ResultSet rs;

    public int obtenerIdHorarioTrabajo(Time horaini, Time horafin) throws Exception {
        strSQL = "select * from horario_trabajo where horaentrada=? and horasalida=?;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        int idperiodo = 0;
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setTime(1, horaini);
            ps.setTime(2, horafin);
            rs = ps.executeQuery();
            while (rs.next()) {
                idperiodo = rs.getInt("id");
            }
            return idperiodo;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener id de tipo de horario de trabajo --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet filtrarTurnoHorarioTrabajo(String turno) throws Exception {
        strSQL = "select ht.id,ht.horaentrada,ht.horasalida,ht.turno,tc.nombre as tipohorario from horario_trabajo ht inner join tipo_contrato tc "
                + "on ht.idtipocontrato=tc.id where ht.turno ilike ?;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, "%" + turno + "%");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al filtrar turnos de horario de trabajo de contrato --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }

    }

    public ResultSet listarTodo() throws Exception {
        strSQL = "select ht.id,ht.horaentrada,ht.horasalida,ht.turno,tc.nombre as tipohorario from horario_trabajo ht inner join tipo_contrato tc "
                + "on ht.idtipocontrato=tc.id;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al listar horarios de trabajo --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }

    }

    public void registrarHorarioTrabajo(Time horaentrada, Time horasalida, int idtipocont, String turno) throws Exception {
        strSQL = "insert into horario_trabajo(horaentrada,horasalida,idtipocontrato,turno) values(?,?,?,?)";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setTime(1, horaentrada);
            ps.setTime(2, horasalida);
            ps.setInt(3, idtipocont);
            ps.setString(4, turno);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error al registrar horario de trabajo --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void modificarHorarioTrabajo(Time horaentrada, Time horasalida, int idtipocont, String turno, int idhorariotrabajo) throws Exception {
        strSQL = "update horario_trabajo set horaentrada=?,horasalida=?,idtipocontrato=?,turno=? where id=?";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setTime(1, horaentrada);
            ps.setTime(2, horasalida);
            ps.setInt(3, idtipocont);
            ps.setString(4, turno);
            ps.setInt(5, idhorariotrabajo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new Exception("Error al modificar horario de trabajo --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean existenRegistrosReferenciados(int idhorariotrabajo) throws Exception {
        boolean existe;
        int cant = 0;
        strSQL = "select count(*) as cant from contrato where idhorariotrabajo=?;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idhorariotrabajo);
            rs = ps.executeQuery();
            while (rs.next()) {
                cant = rs.getInt("cant");
            }
            if (cant > 0) {
                existe = true;
            } else {
                existe = false;
            }
            return existe;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener registros referenciados a horario de trabajo --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }

    }

    public void eliminarHorarioTrabajo(int idhorariotrabajo) throws Exception {
        strSQL = "delete from horario_trabajo where id=?";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idhorariotrabajo);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al eliminar horario de trabajo --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

}
