package Presentacion;
import Negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;

public class Rpt_Pagos_Empleados extends javax.swing.JDialog {

    public Rpt_Pagos_Empleados(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.vistaReporte.setVisible(false);
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerReporte = new javax.swing.JButton();
        vistaReporte = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informe de Nóminas de Pago");

        btnVerReporte.setText("Ver Reporte");
        btnVerReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vistaReporteLayout = new javax.swing.GroupLayout(vistaReporte);
        vistaReporte.setLayout(vistaReporteLayout);
        vistaReporteLayout.setHorizontalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        vistaReporteLayout.setVerticalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaReporte)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(367, 367, 367)
                .addComponent(btnVerReporte)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnVerReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vistaReporte)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporteActionPerformed
        try {
            Container contenedor = this.vistaReporte;
            contenedor.setLayout(new BorderLayout());
            //JOptionPane.showMessageDialog(this, "Procesando Reporte");
            JRViewer objReporte = new Reporte().reporteInterno("Reporte_Pagos_Empleados.jasper", null);
            contenedor.add(objReporte);
            objReporte.setVisible(true);
//Mostrar el reporte
            this.vistaReporte.setVisible(true);
//JOptionPane.showMessageDialog(this, "Reporte Mostrado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + "ERROR en Reporte", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnVerReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerReporte;
    private javax.swing.JDesktopPane vistaReporte;
    // End of variables declaration//GEN-END:variables
}
