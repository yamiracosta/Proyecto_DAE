package Negocio;

import Datos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Descuento {
    
    public boolean existenRegistrosRelacionados(int iddescuento) throws Exception {
        Conexion con = new Conexion();
        try {
            boolean existe;
            int cantreg = 0;
            String sql = "select count(*) as cantidad from detalle_descuento where iddescuento=?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, iddescuento);
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
            String sql = "select * from descuento";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            con.desconexion();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar descuentos --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public ResultSet filtrarDescuento(String descuento) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "select * from descuento where nombre ilike ?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, "%" + descuento + "%");
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al filtrar descuentos --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void registrarDescuento(String descuento, String descr) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "insert into descuento(nombre,descripcion) values(?,?)";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, descuento);
            pst.setString(2, descr);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al registrar descuento --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void modificarDescuento(String descuento, String descr, int iddescuento) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "update descuento set nombre=?,descripcion=? where id=?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, descuento);
            pst.setString(2, descr);
            pst.setInt(3, iddescuento);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al modificar descuento --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void eliminarDescuento(int id) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "delete from descuento where id=?";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar descuento --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public ResultSet listarDescuentosBoletaPago(int idboletapago) throws Exception{
        Conexion con = new Conexion();
        String sql = "select d.nombre as nombre_descuento,sum(dd.monto) as total_descuento from detalle_descuento dd " +
                         "inner join descuento d on d.id=dd.iddescuento inner join boleta_pago bp on bp.id=dd.idpago " +
                         "where dd.idpago=? group by nombre_descuento;";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, idboletapago);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar detalles de descuento --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public int obtenerIdDescuento(String nombre) throws Exception{
        Conexion con = new Conexion();
        String sql = "select id from descuento where nombre=?;";
        try {
            int id=-1;
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                id=rs.getInt("id");
            }
            return id;
        } catch (Exception e) {
            throw new Exception("Error al obtener ID del descuento--> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public int obtenerNumTardanzas(int codcont, int codboleta) throws Exception{
        Conexion con = new Conexion();
        String sql = "select fn_calcular_num_tardanzas(?,?) as numtardanzas;";
        try {
            int numtard = 0;
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, codcont);
            pst.setInt(2, codboleta);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                numtard=rs.getInt("numtardanzas");
            }
            return numtard;
        } catch (Exception e) {
            throw new Exception("Error al obtener el número de tardanzas relacionadas a la boleta de pago--> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public int obtenerNumInasistencias(int codcont, int codboleta) throws Exception{
        Conexion con = new Conexion();
        String sql = "select fn_calcular_num_inasistencias(?,?) as numinasistencias;";
        try {
            int numinasist = 0;
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, codcont);
            pst.setInt(2, codboleta);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                numinasist=rs.getInt("numinasistencias");
            }
            return numinasist;
        } catch (Exception e) {
            throw new Exception("Error al obtener el número de inasistencias relacionadas a la boleta de pago--> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public void registrarBeneficioServicioAdicional(int codboleta,double monto, String descr) throws Exception{
        Conexion con = new Conexion();
        String sql = "insert into detalle_descuento(iddescuento,idpago,monto,descripcion) values(2,?,?,?)";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, codboleta);
            pst.setDouble(2, monto);
            pst.setString(3, descr);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al insertar registro en la tabla DETALLE_DESCUENTO --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    public ResultSet obtenerDetalleServicioBeneficioAdicional(int idpago) throws Exception{
        Conexion con = new Conexion();
        String sql = """
                     select d.nombre,dd.monto,dd.descripcion from detalle_descuento dd
                     inner join descuento d on d.id=dd.iddescuento where dd.idpago=?;
                     """;
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, idpago);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al obtener detalles de servicios o beneficios adicionales de la tabla DETALLE_DESCUENTO --> " 
                    + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
}
