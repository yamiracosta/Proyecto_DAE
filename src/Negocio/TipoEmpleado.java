package Negocio;

import Datos.Conexion;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @GRUPO 4
 */
public class TipoEmpleado {

    Area are = new Area();

    public void listarEmpleado(JComboBox combo) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT distinct nombre FROM tipo_empleado";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            combo.removeAllItems();
            combo.addItem("----------------------------------");
            while (rs.next()) {
                combo.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar tipo de empleados: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public int identificarTipoEmpleado(JComboBox tipEmpleado) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT id FROM tipo_empleado WHERE nombre = ?";

        int valor = 0;

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, tipEmpleado.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                valor = rs.getInt("id");
            }
            return valor;
        } catch (Exception e) {
            throw new Exception("Error al intentar identificar el codigo del tipo de empleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void listarTablaTipoEmpleado(JTable tablaTipoEmpleado) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Area");
        model.addColumn("Remuneración");

        tablaTipoEmpleado.setModel(model);
        
        //375
        TableColumn columna = null;
        for (int i = 0; i < tablaTipoEmpleado.getColumnModel().getColumnCount(); i++) {
            columna = tablaTipoEmpleado.getColumnModel().getColumn(i);
            switch (i) {
                case 0 -> columna.setPreferredWidth(20);
                case 1 -> columna.setPreferredWidth(100);
                case 2 -> columna.setPreferredWidth(130);
                case 3 -> columna.setPreferredWidth(75);
                case 4 -> columna.setPreferredWidth(50);
            }
        }

        String sql = "SELECT tperson.id as codigo, tperson.nombre as puesto, tperson.descripcion as descri, ar.nombre as area,tperson.remuneracion"
                + " FROM tipo_empleado as tperson "
                + "INNER JOIN area as ar on tperson.idarea = ar.id";

        Object[] datos = new Object[5];
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("codigo");
                datos[1] = rs.getString("puesto");
                datos[2] = rs.getString("descri");
                datos[3] = rs.getString("area");
                datos[4] = rs.getDouble("remuneracion");
                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar los datos de la Tabla: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean agregarTipoEmpleado(JTextField nombre, JTextArea descrip, JComboBox area, JTextField remu) throws Exception {
        Conexion con = new Conexion();

        String sql = "INSERT INTO tipo_empleado(nombre, descripcion, idarea, remuneracion) VALUES (?,?,?,?)";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            pst.setString(2, descrip.getText());
            pst.setInt(3, are.identificarArea(area));
            pst.setDouble(4, Double.parseDouble(remu.getText()));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar insertar un nuevo tipo de Empleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean eliminarTipoEmpleado(String codigo) throws Exception {
        Conexion con = new Conexion();

        String sql = "DELETE FROM tipo_empleado WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(codigo));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Eliminar el tipo de Empleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean editarTipoEmpleado(String codigo, JTextField nombre, JTextArea descrip, JComboBox area, JTextField remu) throws Exception {
        Conexion con = new Conexion();

        String sql = "UPDATE tipo_empleado SET nombre = ?, descripcion = ?, idarea = ?, remuneracion=? WHERE id = ?";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, nombre.getText());
            pst.setString(2, descrip.getText());
            pst.setInt(3, are.identificarArea(area));
            pst.setDouble(4, Double.parseDouble(remu.getText()));
            pst.setInt(5, Integer.parseInt(codigo));
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar Editar el Tipo de Empleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public void filtrarTipoEmpleado(JTable tablaTipoEmpleado, JTextField tipo) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Area");
        model.addColumn("Remuneración");

        tablaTipoEmpleado.setModel(model);
        
       //375
        TableColumn columna = null;
        for (int i = 0; i < tablaTipoEmpleado.getColumnModel().getColumnCount(); i++) {
            columna = tablaTipoEmpleado.getColumnModel().getColumn(i);
            switch (i) {
                case 0 -> columna.setPreferredWidth(20);
                case 1 -> columna.setPreferredWidth(100);
                case 2 -> columna.setPreferredWidth(130);
                case 3 -> columna.setPreferredWidth(75);
                case 4 -> columna.setPreferredWidth(50);
            }
        }

        String sql = "SELECT tperson.id as codigo, tperson.nombre as puesto, tperson.descripcion as descri, ar.nombre as area,tperson.remuneracion "
                + " as remu FROM tipo_empleado as tperson INNER JOIN area as ar on tperson.idarea = ar.id WHERE tperson.nombre ilike ?";
        Object[] datos = new Object[5];
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, "%" + tipo.getText() + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("codigo");
                datos[1] = rs.getString("puesto");
                datos[2] = rs.getString("descri");
                datos[3] = rs.getString("area");
                datos[4] = rs.getDouble("remu");
                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al filtrar los tipos de empleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean existenRegistrosReferenciadosTipoEmp(int idtipoemp) throws Exception {
        boolean existe;
        int cant = 0;
        Conexion con = new Conexion();
        String sql = "select count(*) as cant from empleado where idtipoempleado=?";
        try{
            PreparedStatement pst = con.conexion().prepareStatement(sql);
        pst.setInt(1, idtipoemp);
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
            throw new Exception("Error al obtener los registros referenciados al tipo de empleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

}
