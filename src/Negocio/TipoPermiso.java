package Negocio;

import Datos.Conexion;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @GRUPO 4
 */
public class TipoPermiso {

    Conexion objj = new Conexion();
    ResultSet rss = null;
    Connection miconn = null;
    String strsql = "";
    
    public int obtenerDiasVacas() throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "select duracionmaximadias as maxdias from tipo_permiso where id=9;";
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("maxdias");
            }
            return -1;
        } catch (Exception e) {
            throw new Exception("Error al obtener el número máximo de días del periodo de vacaciones --> " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public int obtenerIdTipoPermiso(String tipoperm) throws Exception {
        Object info[] = new Object[2];
        strsql = "select id from tipo_permiso where nombre=?;";
        int idtipo = -1;
        try {
            objj.conexion();
            miconn = objj.getCon();
            PreparedStatement ps = miconn.prepareStatement(strsql);
            ps.setString(1, tipoperm);
            rss = ps.executeQuery();
            while (rss.next()) {
                idtipo = rss.getInt("id");
            }
            return idtipo;
        } catch (Exception e) {
            throw new Exception("Error al obtener el ID del tipo de permiso --> " + e.getMessage());
        } finally {
            objj.desconexion();
        }
    }

    public ResultSet listarTiposPermisos() throws Exception {
        strsql = "select * from tipo_permiso order by nombre;";
        try {
            objj.conexion();
            miconn = objj.getCon();
            PreparedStatement ps = miconn.prepareStatement(strsql);
            rss = ps.executeQuery();
            return rss;
        } catch (Exception e) {
            throw new Exception("Error al listar los tipos de permiso --> " + e.getMessage());
        } finally {
            objj.desconexion();
        }
    }

    public Object[] obtenerDiasDescrTipoPerm(String tipoperm) throws Exception {
        Object info[] = new Object[2];
        strsql = "select duracionmaximadias,descripcion from tipo_permiso where nombre=?;";
        try {
            objj.conexion();
            miconn = objj.getCon();
            PreparedStatement ps = miconn.prepareStatement(strsql);
            ps.setString(1, tipoperm);
            rss = ps.executeQuery();
            while (rss.next()) {
                info[0] = rss.getInt("duracionmaximadias");
                info[1] = rss.getString("descripcion");
            }
            return info;
        } catch (Exception e) {
            throw new Exception("Error al obtener la cantidad de días y la descripción del tipo de permiso --> " + e.getMessage());
        } finally {
            objj.desconexion();
        }
    }

    //Mantenimiento
    public void listarTablaTipoPermiso(JTable tablaTipPermiso) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Código");
        model.addColumn("Tipo de Permiso");
        model.addColumn("Descripción");
        model.addColumn("Duración máxima (en días)");

        tablaTipPermiso.setModel(model);

        String sql = "SELECT * FROM tipo_permiso";

        String[] datos = new String[4];
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar la Tabla: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean agregarTipoPermiso(JTextField nombre, JTextArea descripcion, JTextField permiso) throws Exception {
        Conexion con = new Conexion();

        String sql = "INSERT INTO tipo_permiso (nombre, descripcion, duracionmaximadias) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            pst.setString(2, descripcion.getText());
            pst.setInt(3, Integer.parseInt(permiso.getText()));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Insertar un nuevo tipo de Permiso: " + e.toString());
        } finally {
            con.desconexion();
        }
    }

    public boolean editarTipoPermiso(String codigo, JTextField nombre, JTextArea descripcion, JTextField permiso) throws Exception {
        Conexion con = new Conexion();

        String sql = "UPDATE tipo_permiso SET nombre = ?, descripcion = ?, duracionmaximadias = ? WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            pst.setString(2, descripcion.getText());
            pst.setInt(3, Integer.parseInt(permiso.getText()));
            pst.setInt(4, Integer.parseInt(codigo));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Editar el Tipo de Permiso: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean eliminarTipoPermiso(String codigo) throws Exception {
        Conexion con = new Conexion();

        String sql = "DELETE FROM tipo_permiso WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigo));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Eliminar el tipo de Permiso: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void filtrarTipoPermiso(JTable tablaTipPermiso, JTextField tipo) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Código");
        model.addColumn("Tipo de Permiso");
        model.addColumn("Descripción");
        model.addColumn("Duración máxima (en días)");

        tablaTipPermiso.setModel(model);

        String sql = "SELECT * FROM tipo_permiso WHERE nombre ilike ?";

        String[] datos = new String[4];
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, "%" + tipo.getText() + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar la tabla de tipo de permisos: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean existenRegistrosReferenciados(int idtipoperm) throws Exception {
        boolean existe;
        int cant = 0;
        Conexion con = new Conexion();
        String sql = "select count(*) as cant from permiso where idtipopermiso=?";
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, idtipoperm);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cant = rs.getInt("cant");
            }
            if (cant >= 1) {
                existe = true;
            } else {
                existe = false;
            }
            return existe;
        } catch (SQLException e) {
            throw new Exception("Error al intentar obtener los registros referenciados al tipo de permiso: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

}
