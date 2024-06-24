package Negocio;

import Datos.Conexion;
import java.sql.*;

public class Asistencia {

    Conexion objC = new Conexion();
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement ps = null;
    String sql = "";

    public ResultSet obtenerMesesDisponibles(int idemp) throws Exception {
        sql = "select distinct extract(month from a.fecha) as mes from asistencia a\n"
                + "inner join empleado e on e.id=a.idempleado\n"
                + "inner join contrato c on c.idempleado=e.id\n"
                + "where extract(month from fecha) between extract(month from current_date - INTERVAL '1 month') "
                + "and extract(month from current_date)\n"
                + "	  and extract(year from fecha) = extract(year from current_date) --de este año\n"
                + "and a.IDEMPLEADO=?\n"
                + "and c.estado='V' "
                + "order by mes";
        try {
            objC.conexion();
            con = objC.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idemp);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new Exception("Error al obtener los meses disponibles --> " + e.getMessage());
        } finally {
            objC.desconexion();
        }
    }

    public ResultSet filtrarAsistencia(int idempl, int mes) throws Exception {
        sql = "select \n"
                + "CASE\n"
                + "        WHEN to_char(a.fecha, 'Day') = 'Monday   ' THEN 'Lunes'\n"
                + "        WHEN to_char(a.fecha, 'Day') = 'Tuesday  ' THEN 'Martes'\n"
                + "        WHEN to_char(a.fecha, 'Day') = 'Wednesday' THEN 'Miércoles'\n"
                + "        WHEN to_char(a.fecha, 'Day') = 'Thursday ' THEN 'Jueves'\n"
                + "        WHEN to_char(a.fecha, 'Day') = 'Friday   ' THEN 'Viernes'\n"
                + "        WHEN to_char(a.fecha, 'Day') = 'Saturday ' THEN 'Sábado'\n"
                + "    END AS dia_semana, to_char(a.fecha,'dd-MM-yyyy') as fecha,\n"
                + "case when\n"
                + "    	a.horaentrada is null then 'No registra'\n"
                + "		ELSE to_char(a.horaentrada, 'HH24:MI')\n"
                + "	end as horaentrada,\n"
                + "    case when\n"
                + "    	a.horasalida is null then 'No registra'\n"
                + "		ELSE to_char(a.horasalida, 'HH24:MI')\n"
                + "	end as horasalida,\n"
                + "    case\n"
                + "		when a.estado = 'A' then 'Asistió'\n"
                + "		when a.estado = 'T' then 'Tardanza'\n"
                + "		when a.estado = 'F' then 'Faltó'\n"
                + "		when a.estado = 'TJ' then 'Tardanza justificada'\n"
                + "		when a.estado = 'FJ' then 'Falta justificada'\n"
                + "		when a.estado = 'CP' then 'Con permiso'\n"
                + "		when a.estado = 'V' then 'De vacaciones'\n"
                + "		when a.estado is null then 'Pendiente'\n"
                + "	end as estado\n"
                + "from asistencia a\n"
                + "inner join empleado e on e.id=a.idempleado\n"
                + "inner join contrato c on c.idempleado=e.id\n"
                + "where extract(month from fecha) between extract(month from current_date - INTERVAL '1 month') and extract(month from current_date)\n"
                + "	  and extract(month from fecha) = ?\n"
                + "	  and extract(year from fecha) = extract(year from current_date)\n"
                + "and A.IDEMPLEADO=?\n"
                + "and c.estado='V'\n"
                + "order by a.fecha;";
        try {
            objC.conexion();
            con = objC.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(2, idempl);
            ps.setInt(1, mes);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new Exception("Error al obtener la ficha de asistencia filtrada --> " + e.getMessage());
        } finally {
            objC.desconexion();
        }
    }

    public void cambiarEstadoAsistencia(String estado, Date fecha, int idempleado) throws Exception {
        sql = "update asistencia set estado=? where fecha=? and idempleado=?";
        try {
            objC.conexion();
            con = objC.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            ps.setDate(2, fecha);
            ps.setInt(3, idempleado);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al obtener la ficha de asistencia filtrada --> " + e.getMessage());
        } finally {
            objC.desconexion();
        }
    }
    
    public String[] obtenerFechasPrimerPeriodoVacas(int idempl) throws Exception{
        sql = """
              select to_char(min(fecha),'dd-MM-yyyy') as fechamin,to_char(max(fecha),'dd-MM-yyyy') as fechamax
              from asistencia
              where idempleado=? and estado = 'V';
              """;
        String fechas[] = new String[2];
        try {
            objC.conexion();
            con = objC.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idempl);
            rs = ps.executeQuery();
            while (rs.next()) {
                fechas[0] = rs.getString("fechamin");
                fechas[1] = rs.getString("fechamax");
            }
            return fechas;
        } catch (SQLException e) {
            throw new Exception("Error al obtener las fechas del primer periodo de vacaciones --> " + e.getMessage());
        } finally {
            objC.desconexion();
        }
    }
    
    public boolean actualizarAsistenciaVacaciones(int idempl, Date fechI, Date fechF) throws Exception{
        sql = "update asistencia set estado='V' where idempleado=? and fecha between ? and ?;";
        String sql2 = """
                      insert into permiso(fechainicio,fechafin,descripcion,fechasolicitud,fecharespuesta,estado,idempleado,idtipopermiso)
                      values(?,?,'Periodo de vacaciones remuneradas',current_date,current_date,'A',?,9);
                      """;
        try {
            objC.conexion();
            con = objC.getCon();
            con.setAutoCommit(false);
            
            //Actualizar asistencia
            ps = con.prepareStatement(sql);
            ps.setInt(1, idempl);
            ps.setDate(2, fechI);
            ps.setDate(3, fechF);
            ps.executeUpdate();
            
            //Registrar en permiso:
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setDate(1, fechI);
            ps2.setDate(2, fechF);
            ps2.setInt(3, idempl);
            ps2.executeUpdate();
            
            con.commit();
            return true;
        } catch (SQLException e) {
            throw new Exception("Error al registrar las fechas de vacaciones del empleado --> " + e.getMessage());
        } finally {
            objC.desconexion();
        }
    }
    
    public int obtenerDiasVacasYaAsignadas(int idempleado) throws Exception {
        sql = """
              select count(*) as cant from asistencia a
              inner join empleado e on a.idempleado=e.id
              inner join contrato c on e.id=c.idempleado
              where e.id=? and c.estado='V' and a.estado = 'V';
              """;
        try {
            int diasdisp = 0;
            objC.conexion();
            con = objC.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idempleado);
            rs = ps.executeQuery();
            while (rs.next()) {
                diasdisp = rs.getInt("cant");
            }
            return diasdisp;
        } catch (Exception e) {
            throw new Exception("Error al obtener el número de días con permiso de vacaciones --> " + e.getMessage());
        } finally {
            objC.desconexion();
        }
    }
}
