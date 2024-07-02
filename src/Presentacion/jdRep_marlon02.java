package Presentacion;

import Negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;

public class jdRep_marlon02 extends javax.swing.JDialog {
    
    Reporte objR = new Reporte();

    public jdRep_marlon02(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        this.vistaReporte.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerReportegraf = new javax.swing.JButton();
        vistaReporte = new javax.swing.JDesktopPane();
        btnVerReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informe Mensual de Solicitudes de Permisos");

        btnVerReportegraf.setText("Ver Grafico");
        btnVerReportegraf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReportegrafActionPerformed(evt);
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
            .addGap(0, 332, Short.MAX_VALUE)
        );

        btnVerReporte.setText("Ver Reporte");
        btnVerReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaReporte)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(btnVerReporte)
                .addGap(34, 34, 34)
                .addComponent(btnVerReportegraf)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerReportegraf)
                    .addComponent(btnVerReporte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vistaReporte)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerReportegrafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReportegrafActionPerformed
        try {
            Container contenedor = this.vistaReporte;
            contenedor.setLayout(new BorderLayout());
            //JOptionPane.showMessageDialog(this, "Procesando Reporte");
            JRViewer objReporte = objR.reporteInterno("R2_Reporte_Graf_permisos_mes.jasper", null);
            contenedor.add(objReporte);
            objReporte.setVisible(true);
//Mostrar el reporte
            this.vistaReporte.setVisible(true);
//JOptionPane.showMessageDialog(this, "Reporte Mostrado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage() + "ERROR en Reporte", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnVerReportegrafActionPerformed

    private void btnVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporteActionPerformed
                try {
            Container contenedor = this.vistaReporte;
            contenedor.setLayout(new BorderLayout());
            //JOptionPane.showMessageDialog(this, "Procesando Reporte");
            JRViewer objReporte = objR.reporteInterno("R2_Reporte_permisos_mes.jasper", null);
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
    private javax.swing.JButton btnVerReportegraf;
    private javax.swing.JDesktopPane vistaReporte;
    // End of variables declaration//GEN-END:variables
}
