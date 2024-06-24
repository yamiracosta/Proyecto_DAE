package Negocio;

import Datos.Conexion;
import java.sql.*;

public class Permiso {

    Conexion obj = new Conexion();
    ResultSet rs = null;
    Connection micon = null;
    String sql = "";

    public ResultSet filtrarPermisosEmpleadoPorEstado(String estado, int idemp) throws Exception {
        sql = "select p.id, p.fechasolicitud,tp.nombre as tipopermiso,p.descripcion,p.fechainicio,p.fechafin as fechatermino,p.fecharespuesta "
                + "from permiso p inner join tipo_permiso tp on p.idtipopermiso=tp.id "
                + "inner join empleado e on e.id=p.idempleado "
                + "inner join contrato c on c.idempleado=e.id "
                + "where p.estado=? and p.idempleado=? and c.estado='V' "
                + "order by p.fechasolicitud desc;";
        try {
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setInt(2, idemp);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al filtrar los permisos por estado--> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean fechaFinPermisoExcedeFechaFinContrato(java.sql.Date fechafinperm, int idemp) throws Exception {
        sql = "select fn_comprobar_fecha_permiso_fecha_contrato(?,?)";
        try {
            boolean excede = false;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setDate(1, fechafinperm);
            ps.setInt(2, idemp);
            rs = ps.executeQuery();
            while (rs.next()) {
                excede = rs.getBoolean("fn_comprobar_fecha_permiso_fecha_contrato");
            }
            return excede;
        } catch (Exception e) {
            throw new Exception("Error al comprobar si la fecha de fin del permiso excede la fecha de fin del contrato del empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void registrarSolicitudPermiso(Date fechainicio, Date fechafin, String descr, int idemp, int idtipoperm) throws Exception {
        sql = "insert into permiso(fechainicio,fechafin,descripcion,fechasolicitud,estado,idempleado,idtipopermiso)"
                + " values(?,?,?,current_date,'P',?,?)";
        try {
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setDate(1, fechainicio);
            ps.setDate(2, fechafin);
            ps.setString(3, descr);
            ps.setInt(4, idemp);
            ps.setInt(5, idtipoperm);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al registrar solicitud de permiso --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void eliminarSolicitudPermiso(int id) throws Exception {
        sql = "delete from permiso where id=?";
        try {
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar solicitud de permiso --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void rechazarSolicitudPermiso(int id) throws Exception {
        sql = "update permiso set estado='R',fecharespuesta=current_date where id=?";
        try {
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al rechazar solicitud de permiso --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public void aprobarSolicitudPermiso(int idempleado, int idpermiso) throws Exception {
        sql = "select fn_aprobar_solicitud(?,?)";
        try {
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setInt(1, idempleado);
            ps.setInt(2, idpermiso);
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al aprobar solicitud de permiso --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean existeCrucePermisos(int idemp, Date fecI, Date fecF) throws Exception{
        sql = "select verificar_cruce_permisos(?,?,?) as cruce;";
        try {
            boolean cruce = false;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setInt(1, idemp);
            ps.setDate(2, fecI);
            ps.setDate(3, fecF);
            rs = ps.executeQuery();
            while (rs.next()) {
                cruce = rs.getBoolean("cruce");
            }
            return cruce;
        } catch (Exception e) {
            throw new Exception("Error al comprobar cruce de fechas de permisos aprobados y pendientes --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public ResultSet listarPermisosEmpleado(int idemp) throws Exception {
        sql = """
              select p.id, p.fechasolicitud,tp.nombre as tipopermiso,p.descripcion,p.fechainicio,p.fechafin as fechatermino,p.fecharespuesta,
              p.estado as estadopermiso
              from permiso p inner join tipo_permiso tp on p.idtipopermiso=tp.id 
              inner join empleado e on p.idempleado=e.id
              inner join contrato c on c.idempleado=e.id where p.idempleado=? and c.estado='V'
              order by p.fechasolicitud desc;
              """;
        try {
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(sql);
            ps.setInt(1, idemp);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar los permisos --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
}
