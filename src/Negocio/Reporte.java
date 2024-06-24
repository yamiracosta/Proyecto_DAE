package Negocio;

import Datos.Conexion;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

public class Reporte {
    
    public static final String ruta_reportes = "src\\Reportes\\";
    
    public JRViewer reporteInterno(String archivoReporte, Map<String,Object> parametros) throws Exception {
        try{
            Conexion objCon = new Conexion();
            objCon.conexion();
            JasperPrint reporte =
                    //Corregir.
                    JasperFillManager.fillReport(Reporte.ruta_reportes + archivoReporte, parametros, objCon.getCon());
            JRViewer visor = new JRViewer(reporte);
            return visor;
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public JasperPrint reporteExterno(String archivoReporte, Map<String,Object> parametros) throws Exception {
        try{
            Conexion objCon = new Conexion();
            objCon.conexion();
            JasperPrint reporte =
                    //Corregir.
                    JasperFillManager.fillReport(Reporte.ruta_reportes + archivoReporte, parametros, objCon.getCon());
            return reporte;
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
