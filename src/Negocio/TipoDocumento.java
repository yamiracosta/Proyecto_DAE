package Negocio;

import Datos.Conexion;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @GRUPO 4
 */
public class TipoDocumento {

    public void listarTipoDocumento(JComboBox combo) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT distinct nombre FROM tipo_documento";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            combo.removeAllItems();
            combo.addItem("-----------------------");
            while (rs.next()) {
                combo.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar el tipo de Documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public int identificarTipoDocumento(JComboBox tipDocumento) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT id FROM tipo_documento WHERE nombre = ?";
        int valor = 0;
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, tipDocumento.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            rs.next();
            valor = rs.getInt("id");
            return valor;
        } catch (Exception e) {
            throw new Exception("Error al intentar retornar el codigo del tipo de Documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    //Para anular contrato:
    public int obtenerIdTipoDocumento(String tipodoc) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT id FROM tipo_documento WHERE nombre = ?";
        int valor = 0;
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, tipodoc);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                valor = rs.getInt("id");
            }
            return valor;
        } catch (Exception e) {
            throw new Exception("Error al obtener ID del tipo de Documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void listarTablaTipoDocumento(JTable tablaTipoDocumento) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Codigo");
        model.addColumn("Nombre del Tipo de Documento");

        tablaTipoDocumento.setModel(model);

        String sql = "SELECT * FROM tipo_documento ORDER BY id asc";

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
            throw new Exception("Error al intentar listar el Tipo de documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean insertarTipoDocumento(JTextField nombre) throws Exception {
        Conexion con = new Conexion();

        String sql = "INSERT INTO tipo_documento (nombre) VALUES (?)";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar insertar un nuevo tipo de documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean editarTipoDocumento(String codigo, JTextField nombre) throws Exception {
        Conexion con = new Conexion();

        String sql = "UPDATE tipo_documento SET nombre = ? WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            pst.setInt(2, Integer.parseInt(codigo));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar actualizar el tipo de documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void filtrarTipoDocumento(JTable tablaTipoDocumento, JTextField tipo) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Codigo");
        model.addColumn("Nombre del Tipo de Documento");

        tablaTipoDocumento.setModel(model);

        String sql = "SELECT * FROM tipo_documento WHERE nombre ilike ?";

        String[] datos = new String[2];
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, "%" + tipo.getText() + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al filtrar los tipos de documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean eliminarTipoDocumento(String codigo) throws Exception {
        Conexion con = new Conexion();

        String sql = "DELETE FROM tipo_documento WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigo));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Eliminar el Tipo de Documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean existenRegistrosReferenciadosTipoDoc(int idtipodoc) throws Exception {
        boolean existe;
        int cant = 0;
        Conexion con = new Conexion();
        String sql = "select count(*) as cant from empleado where idtipodocumento=?";
        
        try{
            PreparedStatement pst = con.conexion().prepareStatement(sql);
        pst.setInt(1, idtipodoc);
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
        } catch (SQLException e){
            throw new Exception("Error al obtener los registros referenciados al Tipo de Documento: " + e.getMessage());
        } finally {
            con.desconexion();
        }
        
        
    }

}
