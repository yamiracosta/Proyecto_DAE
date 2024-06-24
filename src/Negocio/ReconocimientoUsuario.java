
package Negocio;

import java.sql.*;
import Datos.Conexion;
import javax.swing.JTextField;

/**
 *
 * @GRUPO_4
 */
public class ReconocimientoUsuario {
    
    public Object[] identificarUsuario(JTextField usuario)throws Exception{
        Conexion con = new Conexion();
        
        String uss = usuario.getText();
        String puesto = null;
        String nombresApe = null;
        
        String sql = "SELECT tem.nombre as puesto, concat(em.nombres,' ',em.ape_paterno,' ',em.ape_materno) as  empleado,em.id as userloggeado " +
                     "FROM empleado as em INNER JOIN " +
                     "tipo_empleado as tem on em.idtipoempleado = tem.id " +
                     "WHERE nombreUsuario = ?";
        
        try {
            PreparedStatement pst = con.conexion().prepareStatement(sql);
            pst.setString(1, uss);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                puesto = rs.getString("puesto");
                nombresApe = rs.getString("empleado");
                Empleado.ID_USUARIO_LOGGEADO=rs.getInt("userloggeado");
            }
            
            return new Object[]{puesto, nombresApe};
            
        } catch (Exception e) {
            throw new Exception("Error al realizar la asignación de las credenciales de usuario: "+e.getMessage());
        }finally{
            con.desconexion();
        }
        
    }
    
}
