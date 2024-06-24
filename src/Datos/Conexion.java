package Datos;

import java.sql.*;

/**
 *
 * @GRUPO_4
 */
public class Conexion {

    Connection con = null;

    private String nombre = "postgres";
    public static String contrasena = "75608248";

    private String bd = "bd_planillas";
    private String ip = "5432";
    private String puerto = "localhost";

    private String cadena = "jdbc:postgresql://" + puerto + ":" + ip + "/" + bd;
    private String driver = "org.postgresql.Driver";
    
    public Connection getCon() {
        return con;
    }

    public Connection conexion() throws Exception {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(cadena, nombre, contrasena);
            //System.out.println("Se logro conectar correctamente");
        } catch (Exception e) {
            throw new Exception("Se generó un error al intentar establecer la conexión: " + e.getMessage());
        }
        return con;
    }

    public Connection desconexion() throws Exception {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            throw new Exception("Error al intentar desconectar la Base de Datos: " + e.getMessage());
        }
        return con;
    }
}
