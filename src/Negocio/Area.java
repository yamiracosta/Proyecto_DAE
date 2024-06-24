package Negocio;

import java.sql.*;
import Datos.Conexion;
import javax.swing.JComboBox;

/**
 *
 * @GRUPO 4
 */
public class Area {

    public void listarComboAreas(JComboBox areas) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT nombre FROM area";

        try {
            areas.removeAllItems();
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                areas.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar las áreas: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public int identificarArea(JComboBox area) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT id FROM area WHERE nombre = ?";
        int valor = 0;
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, area.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                valor = rs.getInt("id");
                return valor;
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar identificar el codigo del Area: " + e.getMessage());
        } finally {
            con.desconexion();
        }
        return valor;
    }

    //Mantenimiento:
    public boolean existenRegistrosRelacionadosArea(int idarea) throws Exception {
        boolean existe;
        int cantreg = 0;
        Conexion con = new Conexion();
        String sql = "select count(*) as cantidad from tipo_empleado where idarea=?";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, idarea);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cantreg = rs.getInt("cantidad");
            }
            if (cantreg >= 1) {
                existe = true;
            } else {
                existe = false;
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener registros relacionados a área --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
        return existe;
    }

    public ResultSet listarAreas() throws Exception {
        Conexion con = new Conexion();
        String sql = "select * from area";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al obtener registros listado de áreas --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public ResultSet filtrarArea(String area) throws Exception {
        Conexion con = new Conexion();
        String sql = "select * from area where nombre ilike ?";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, "%" + area + "%");
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al obtener filtrar lista de áreas --> " + e.getMessage());
        } finally {
            con.desconexion();
        }

    }

    public void registrarArea(String area, String descr) throws Exception {
        Conexion con = new Conexion();
        String sql = "insert into area(nombre,descripcion) values(?,?)";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, area);
            pst.setString(2, descr);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al registra área --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void modificarArea(String area, String descr, int idarea) throws Exception {
        Conexion con = new Conexion();
        String sql = "update area set nombre=?,descripcion=? where id=?";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, area);
            pst.setString(2, descr);
            pst.setInt(3, idarea);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al modificar área --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void eliminarArea(int id) throws Exception {
        Conexion con = new Conexion();
        String sql = "delete from area where id=?";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar área --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

}
