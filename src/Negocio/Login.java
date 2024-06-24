package Negocio;

import java.sql.*;
import Datos.Conexion;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @GRUPO_4
 */
public class Login {

    //contraseña=md5(numdocumento,nombres,'Chamir69');
    public String validacionUsuario(JTextField usuario, JPasswordField contrasena) throws Exception {
        Conexion con = new Conexion();

        String uss = usuario.getText();
        String clav = String.valueOf(contrasena.getPassword());
        String nombre = null;

        String sql = "SELECT nombres FROM empleado WHERE nombreusuario = ? and contraseña=md5(? || ? || 'Chamir69')";

        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, uss);
            pst.setString(2, uss);
            pst.setString(3, clav);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("nombres");                
                
            }
            return nombre;
        } catch (Exception e) {
            throw new Exception("Error al intentar realizar la validacion de usuario: " + e.getMessage());
        } finally {
            con.desconexion();
        }
    }

}
