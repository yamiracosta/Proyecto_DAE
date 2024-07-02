package Negocio;

import Datos.Conexion;
import java.sql.*;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Negocio.Empleado;

/**
 *
 * @GRUPO 4
 */
public class Empleado2 {

    Empleado objE = new Empleado();
    TipoDocumento doc = new TipoDocumento();
    TipoEmpleado emp = new TipoEmpleado();

    public void listarSuperior(JComboBox combo) throws Exception {
        Conexion con = new Conexion();

        String sql = "Select CONCAT(nombres,' ',ape_paterno,' ',ape_materno) as datos from empleado";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            combo.removeAllItems();
            combo.addItem("-----------------------------");
            while (rs.next()) {
                combo.addItem(rs.getString("datos"));
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar los tipos superiores: " + e.getMessage());
        } finally {
            con.desconexion();
        }

    }

    public void listarTablaTrabajadores(JTable tablaTrabajadores) throws Exception {
        Conexion con = new Conexion();
        DefaultTableModel model = new DefaultTableModel();
        //model.addColumn("Codigo");
        model.addColumn("N° de Documento"); 
        model.addColumn("Tipo de documento");
        model.addColumn("Nombres");
        model.addColumn("Apellido paterno");
        model.addColumn("Apellido materno");
        model.addColumn("Correo");
        model.addColumn("Teléfono");
        model.addColumn("Estado");
        model.addColumn("Tipo de empleado");
        model.addColumn("Supervisor");
        model.addColumn("Con hijos");

        tablaTrabajadores.setModel(model);
        //De la consulta: emp.id as codigo,
        String sql = """
                     SELECT  emp.numdocumento as numerodocu,
                     emp.nombres as nombre,
                     emp.ape_paterno as apepaterno,
                     emp.ape_materno as apematerno,
                     emp.correo as correoempleado,
                     emp.telefono as telefonoempleado,
                     emp.estado as estadousuario,
                     tdoc.nombre AS nombre_tipo_documento,
                     templ.nombre AS nombre_tipo_empleado,
                     CASE
                     WHEN emp.idempleadoempleado IS NULL THEN 'No Cuenta'
                     ELSE (SELECT CONCAT(nombres,' ',ape_paterno,' ',ape_materno) FROM empleado WHERE id = emp.idempleadoempleado)
                     END AS nombre_empleado,
                     case when emp.tienehijos = true then 'Sí'
                     when emp.tienehijos = false then 'No'
                     end as tienehijos
                     FROM empleado AS emp
                     INNER JOIN tipo_documento AS tdoc ON emp.idtipodocumento = tdoc.id
                     INNER JOIN tipo_empleado AS templ ON emp.idtipoempleado = templ.id;""";
        String vigencia;
        String[] datos = new String[11];
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("numerodocu");
                datos[1] = rs.getString("nombre_tipo_documento");
                datos[2] = rs.getString("nombre");//nombre
                datos[3] = rs.getString("apepaterno"); //apepat
                datos[4] = rs.getString("apematerno"); //apemat
                datos[5] = rs.getString("correoempleado");
                datos[6] = rs.getString("telefonoempleado");
         
                vigencia = rs.getString("estadousuario");
                if (vigencia.equals("V")) {
                    datos[7] = "Vigente";
                } else if (vigencia.equals("N")) {
                    datos[7] = "No vigente";
                } else if (vigencia.equals("R")) {
                    datos[7] = "Renunció";
                } else {
                    datos[7] = "Despedido";
                }
                datos[8] = rs.getString("nombre_tipo_empleado");//
                datos[9] = rs.getString("nombre_empleado");
                datos[10] = rs.getString("tienehijos");

                model.addRow(datos);
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar listar los Trabajdores en la tabla: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public Integer identificarSupervisor(JComboBox supervisor) throws Exception {
        Conexion con = new Conexion();
        String supervi = supervisor.getSelectedItem().toString().equals("------------------") ? null : supervisor.getSelectedItem().toString();
        String sql = "SELECT id FROM empleado WHERE  CONCAT(nombres, ' ', ape_paterno, ' ',ape_materno) = ?";
        int valor = 0;
        try {
            if (supervi == null) {
                return null;
            } else {
                PreparedStatement pst = con.conexion().prepareStatement(sql);
                pst.setString(1, supervi);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    valor = rs.getInt("id");
                }
                return valor;
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar identificar el supervisor del empleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean agregarTrabajador(JTextField numDoc, JComboBox tipDoc, JTextField nombre, JTextField apPaterno, JTextField apMaterno,
            JTextField correo, String nomUsuario, String contra, JTextField telefono, JCheckBox vigencia, JComboBox tipEmpleado,
            JComboBox superior, JCheckBox tienehijos) throws Exception {
        Conexion con = new Conexion();
        boolean exito;

        String sql = "{? = call pa_insert_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        String vige = vigencia.isSelected() ? "V" : "N";
        boolean conhijos = tienehijos.isSelected() ? true : false;

        try {
            CallableStatement pa_insertemp = con.conexion().prepareCall(sql);
            pa_insertemp.registerOutParameter(1, Types.BOOLEAN);

            pa_insertemp.setString(2, numDoc.getText());
            pa_insertemp.setInt(3, doc.identificarTipoDocumento(tipDoc));
            pa_insertemp.setString(4, nombre.getText());
            pa_insertemp.setString(5, apPaterno.getText());
            pa_insertemp.setString(6, apMaterno.getText());
            if (correo.getText().isBlank()) {
                pa_insertemp.setNull(7, Types.NULL);
            } else {
                pa_insertemp.setString(7, correo.getText());
            }
            pa_insertemp.setString(8, telefono.getText());//
            
            pa_insertemp.setNull(9, Types.NULL);
            pa_insertemp.setNull(10, Types.NULL);
            
            pa_insertemp.setString(11, vige);
            pa_insertemp.setInt(12, emp.identificarTipoEmpleado(tipEmpleado));
            if (superior.getSelectedIndex() == 0) {
                pa_insertemp.setNull(13, Types.NULL);
            } else {
                pa_insertemp.setInt(13, identificarSupervisor(superior));
            }
            pa_insertemp.setBoolean(14, conhijos);
            
            exito = pa_insertemp.execute();
            System.out.print(exito);
            return exito;
        } catch (Exception e) {
            throw new Exception("Error al intentar insertar un trabajador nuevo: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean editarTrabajador(JTextField numDoc, JComboBox tipDoc, JTextField nombre, JTextField apPaterno, JTextField apMaterno,
            JTextField correo, String nomUsuario, String contra, JTextField telefono, JCheckBox vigencia, JComboBox tipEmpleado,
            JComboBox superior ,JCheckBox conhijos) throws Exception {
        Conexion con = new Conexion();
        boolean exito;

        /*
        pa_update_empleado(numdoc varchar(20),tipodoc int,nombres varchar(200),apepat varchar(200),apemat varchar(200)
	,correo varchar(200),tel varchar(20),nomusu varchar(30),contra varchar(30),est char(1),tipoemp int, empemp int)
        */
        String sql = "{? = call pa_update_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        //nombreusuario//contraseña//telefono
        String vige = vigencia.isSelected() ? "V" : "N";
        boolean tienehijos = conhijos.isSelected() ? true : false;

        try {
            CallableStatement pst = con.conexion().prepareCall(sql);
            pst.registerOutParameter(1, Types.BOOLEAN);
            //pst.setString(1, numDoc.getText());
            pst.setString(2, numDoc.getText());
            pst.setInt(3, doc.identificarTipoDocumento(tipDoc));
            pst.setString(4, nombre.getText());
            pst.setString(5, apPaterno.getText());
            pst.setString(6, apMaterno.getText());
            
            if (correo.getText().isBlank()) {
                pst.setNull(7, Types.NULL);
            } else {
                pst.setString(7, correo.getText());
            }
            
            pst.setString(8, telefono.getText());
            
            pst.setNull(9, Types.NULL);
            pst.setNull(10, Types.NULL);
            
            pst.setString(11, vige);
            pst.setInt(12, emp.identificarTipoEmpleado(tipEmpleado));
            
            if (superior.getSelectedIndex() != 0) {
                pst.setInt(13, identificarSupervisor(superior));
            } else {
                pst.setNull(13, Types.NULL); // Establecer el valor como NULL en la base de datos
            }
            pst.setBoolean(14, tienehijos);
            
            pst.execute();
            exito = pst.getBoolean(1);
            return exito;

        } catch (Exception e) {
            throw new Exception("Error al intentar actualizar el trabajador: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean eliminarTrabajador(JTextField codigo, JComboBox tipodocumento) throws Exception {
        Conexion con = new Conexion();

        String sql = "DELETE FROM empleado WHERE  numdocumento = ? and idtipodocumento = ?";
        Integer idtipodoc = doc.identificarTipoDocumento(tipodocumento);

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, codigo.getText());
            pst.setInt(2, idtipodoc);
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar eliminar al Trabajador: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean existenTablasReferenciadasEmpleado(JTextField numdoc, JComboBox tipodoc) throws Exception {
        boolean existe;

        Conexion objConexion = new Conexion();
        int idemp = 0;
        int cant = 0;
        String numdocu = numdoc.getText();

        try {
            Connection micon = objConexion.conexion();

            int idtipodoc = doc.identificarTipoDocumento(tipodoc);

            String sqlObtenerId = "select id from empleado where numdocumento=? and idtipodocumento=?";
            PreparedStatement pst = micon.prepareStatement(sqlObtenerId);
            pst.setString(1, numdocu);
            pst.setInt(2, idtipodoc);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                idemp = rs.getInt("id");
            }

            String sql1 = "select count(*) as cant from asistencia where idempleado=?";
            String sql2 = "select count(*) as cant from permiso where idempleado=?";
            String sql3 = "select count(*) as cant from contrato where idempleado=?";
            String sql4 = "select count(*) as cant from empleado where idempleadoempleado=?";
            String sql5 = "select count(*) as cant from contrato where idoperador=?";
            String sql6 = "select count(*) as cant from boleta_pago where idoperador=?";

            PreparedStatement pst1 = micon.prepareStatement(sql1);
            PreparedStatement pst2 = micon.prepareStatement(sql2);
            PreparedStatement pst3 = micon.prepareStatement(sql3);
            PreparedStatement pst4 = micon.prepareStatement(sql4);
            PreparedStatement pst5 = micon.prepareStatement(sql5);
            PreparedStatement pst6 = micon.prepareStatement(sql6);

            pst1.setInt(1, idemp);
            pst2.setInt(1, idemp);
            pst3.setInt(1, idemp);
            pst4.setInt(1, idemp);
            pst5.setInt(1, idemp);
            pst6.setInt(1, idemp);

            ResultSet rsca = pst1.executeQuery();
            ResultSet rsprm = pst2.executeQuery();
            ResultSet rscnt = pst3.executeQuery();
            ResultSet rsempemp = pst4.executeQuery();
            ResultSet rscont2 = pst5.executeQuery();
            ResultSet rsbp = pst6.executeQuery();

            while (rsca.next()) {
                cant = rsca.getInt("cant");
            }
            while (rsprm.next()) {
                cant += rsprm.getInt("cant");
            }
            while (rscnt.next()) {
                cant += rscnt.getInt("cant");
            }
            while (rsempemp.next()) {
                cant += rsempemp.getInt("cant");
            }
            while (rscont2.next()) {
                cant += rscont2.getInt("cant");
            }
            while (rsbp.next()) {
                cant += rsbp.getInt("cant");
            }

            if (cant >= 1) {
                existe = true;
            } else {
                existe = false;
            }
            
            return existe;
        } catch (Exception e) {
            throw new Exception("Error al ejecutar consulta: "+e.getMessage());
        } finally {
            objConexion.desconexion();
        }
    }

    public boolean darBajaTrabajador(JTextField codigo, JComboBox cboTipoDoc) throws Exception {
        Conexion con = new Conexion();

        String sql = "UPDATE empleado \n"
                + "SET estado = CASE estado\n"
                + "WHEN 'V' THEN 'N'\n"
                + "WHEN 'N' THEN 'V'\n"
                + "END\n"
                + "WHERE numdocumento = ? and idtipodocumento= ?;";

        Integer idtipodoc = doc.identificarTipoDocumento(cboTipoDoc);

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, codigo.getText());
            pst.setInt(2, idtipodoc);
            int rs = pst.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            throw new Exception("Error al intentar cambiar estado del trabajador: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public ResultSet buscarTrabajador(String numdoc, String tipodoc) throws Exception {
        Conexion con = new Conexion();
        try {
            String strsql ="""
                           SELECT emp.numdocumento as numerodocu,emp.nombres as nombre, emp.ape_paterno as apepaterno,emp.ape_materno as apematerno
                           , emp.correo as correoempleado, emp.telefono as telefonoempleado,emp.estado as estadousuario, tdoc.nombre AS nombre_tipo_documento,
                           templ.nombre AS nombre_tipo_empleado,CASE WHEN emp.idempleadoempleado IS NULL THEN 'No Cuenta' ELSE 
                           (SELECT CONCAT(nombres,' ',ape_paterno,' ',ape_materno) FROM empleado WHERE id = emp.idempleadoempleado)
                           END AS nombre_empleado,
                           case when emp.tienehijos = true then 'Sí'
                           when emp.tienehijos = false then 'No'
                           end as tienehijos
                           FROM empleado AS emp INNER JOIN tipo_documento AS tdoc ON emp.idtipodocumento = tdoc.id
                           INNER JOIN tipo_empleado AS templ ON emp.idtipoempleado = templ.id
                           where emp.numdocumento=? and tdoc.nombre=?;
                           """;
            PreparedStatement pst = con.conexion().prepareStatement(strsql);
            pst.setString(1, numdoc);
            pst.setString(2, tipodoc);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            throw new Exception("Error en: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

    public boolean existeEmpleado(String numdoc, String tipodoc) throws Exception {
        Conexion con = new Conexion();
        try {
            String sql = "SELECT emp.numdocumento as numerodocu,tdoc.nombre AS nombre_tipo_documento from empleado emp"
                    + " INNER JOIN tipo_documento AS tdoc ON emp.idtipodocumento = tdoc.id where emp.numdocumento=? and tdoc.nombre=?;";
            boolean existe;
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, numdoc);
            pst.setString(2, tipodoc);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }
            return existe;
        } catch (Exception e) {
            throw new Exception("Error al ejecutar la consulta existeEmpleado: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }
    
    
    
    //------------------------------------------------------------------------------------------------------
    public void listarEmpleadosAsisteieron(JComboBox combo) throws Exception {
        Conexion con = new Conexion();

        String sql = "select DISTINCT CONCAT(emp.nombres, ' ', emp.ape_paterno, ' ', emp.ape_materno) AS Nombre FROM asistencia as asi \n"
                + "INNER JOIN empleado as emp on emp.id = asi.idempleado WHERE asi.estado = 'A'";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                combo.addItem(rs.getString("Nombre"));
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar llenar el combo: " + e.getMessage());
        }
    }

    public int identificarIdEmpleadoAsistio(JComboBox combo) throws Exception {
        Conexion con = new Conexion();

        String sql = "SELECT distinct emp.id as codigo\n" +
                     "FROM empleado AS emp\n" +
                     "INNER JOIN asistencia AS asi ON emp.id = asi.idempleado\n" +
                     "WHERE asi.estado = 'A'\n" +
                     "    AND CONCAT(emp.nombres, ' ', emp.ape_paterno, ' ', emp.ape_materno) = ?";
        
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, combo.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar identificar el nombre: " + e.getMessage());
        }
        return 0;
    }

}
