package Negocio;

import Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Beneficio {
    
    public ResultSet listarNombresBeneficios() throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "select nombre from beneficio;";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al comprobar si al trabajador ya se le pagaron utilidades --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public boolean yaHayUtilidades(String beneficio, int codcontrato) throws Exception{
        Conexion con = new Conexion();
        boolean hayUtilidades=true;
        int cantreg = 0;
        try {
            String sql = """
                         select count(*) as cantidad from detalle_beneficio db
                         inner join beneficio b on db.idbeneficio = b.id
                         inner join boleta_pago bp on bp.id=db.idpago
                         inner join contrato c on c.id=bp.idcontrato
                         where b.nombre=? and c.id=?;
                         """;
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, beneficio);
            pst.setInt(2, codcontrato);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cantreg = rs.getInt("cantidad");
            }
            if (cantreg >= 1) {
                hayUtilidades = true;
            } else {
                hayUtilidades = false;
            }
            return hayUtilidades;
        } catch (Exception e) {
            throw new Exception("Error al comprobar si al trabajador ya se le pagaron utilidades --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    //Mantenimiento
    public boolean existenRegistrosRelacionados(int idbeneficio) throws Exception {
        Conexion con = new Conexion();
        try {
            boolean existe;
            int cantreg = 0;
            String sql = "select count(*) as cantidad from detalle_beneficio where idbeneficio=?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, idbeneficio);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cantreg = rs.getInt("cantidad");
            }
            if (cantreg >= 1) {
                existe = true;
            } else {
                existe = false;
            }
            return existe;
        } catch (Exception e) {
            throw new Exception("Error al calcular registros relacionados --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public ResultSet listarTodo() throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "select * from beneficio";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            con.desconexion();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar beneficios --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public ResultSet filtrarBeneficio(String beneficio) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "select * from beneficio where nombre ilike ?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, "%" + beneficio + "%");
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al filtrar beneficios --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void registrarBeneficio(String beneficio, String descr) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "insert into beneficio(nombre,descripcion) values(?,?)";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, beneficio);
            pst.setString(2, descr);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al registrar beneficio --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void modificarBeneficio(String beneficio, String descr, int idbeneficio) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "update beneficio set nombre=?,descripcion=? where id=?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, beneficio);
            pst.setString(2, descr);
            pst.setInt(3, idbeneficio);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al modificar beneficio --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void eliminarBeneficio(int id) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "delete from beneficio where id=?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar beneficio --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public ResultSet listarBeneficiosBoletaPago(int idboletapago) throws Exception {
        Conexion con = new Conexion();
        String sql = "select b.nombre as nombre_beneficio,sum(db.monto) as total_beneficio from detalle_beneficio db " +
                     "inner join beneficio b on b.id=db.idbeneficio inner join boleta_pago bp on bp.id=db.idpago where db.idpago=? " +
                     "group by nombre_beneficio;";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, idboletapago);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar detalles de beneficio --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public int obtenerIdBeneficio(String nombre) throws Exception {
        Conexion con = new Conexion();
        String sql = "select id from beneficio where nombre=?;";
        try {
            int idbenef=0;
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                idbenef = rs.getInt("id");
            }
            return idbenef;
        } catch (Exception e) {
            throw new Exception("Error al obtener ID del beneficio --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
}
