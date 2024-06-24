package Negocio;

import Datos.Conexion;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @GRUPO 4
 */
public class TipoDescuento {

    public void listarTablaTipoDescuento(JTable tablaTipDescuento) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Código");
        model.addColumn("Tipo de Descuento");

        tablaTipDescuento.setModel(model);

        String sql = "SELECT * FROM tipo_descuento";

        String[] datos = new String[2];
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar Listar en la Tabla Tipo Descuento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean insertarTipoDescuento(JTextField nombre) throws Exception {
        Conexion con = new Conexion();

        String sql = "INSERT INTO tipo_descuento (nombre) VALUES (?)";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Insertar un nuevo Descuento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean editarTipoDescuento(JTextField codigo, JTextField nombre) throws Exception {
        Conexion con = new Conexion();

        String sql = "UPDATE tipo_descuento SET nombre = ? WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            pst.setInt(2, Integer.parseInt(codigo.getText()));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar editar el Tipo de Descuento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean eliminarTipoDescuento(JTextField codigo) throws Exception {
        Conexion con = new Conexion();

        String sql = "DELETE FROM tipo_descuento WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigo.getText()));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Eliminar el Tipo de Descuento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void buscarTipoDesccuento(JTable tablaTipDescuento, JTextField codigo) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Código");
        model.addColumn("Tipo de Descuento");

        tablaTipDescuento.setModel(model);

        String sql = "SELECT * FROM tipo_descuento WHERE id = ?";

        String[] datos = new String[2];
        
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigo.getText()));
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar encontrar el tipo de descuento por su código: "+e.getMessage());
        }finally{
            con.desconexion();
        }
    }

}
