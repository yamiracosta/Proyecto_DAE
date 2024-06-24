package Cliente;

import Presentacion.FormPrincipal;
import javax.swing.JOptionPane;
import Datos.Conexion;

public class AppRun {

    Conexion obj = new Conexion();

    public static void main(String[] args) throws Exception {
        FormPrincipal form = new FormPrincipal();
        form.setVisible(true);
        form.setLocationRelativeTo(null);
    }

}
