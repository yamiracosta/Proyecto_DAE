package Presentacion;

import Negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import net.sf.jasperreports.swing.JRViewer;
import Negocio.Empleado2;

public class jd_Rep_boleta_informativa extends javax.swing.JDialog {
    Empleado2 obj = new Empleado2();
    public void llamar(){
        try {
            obj.listarSuperior(cbxEmpleado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public jd_Rep_boleta_informativa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llamar();
        this.vistaReporte.setVisible(false);
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerReporte = new javax.swing.JButton();
        vistaReporte = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        cbxEmpleado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informe de Comprobante Informativo");

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
            .addGap(0, 1153, Short.MAX_VALUE)
        );
        vistaReporteLayout.setVerticalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jLabel1.setText("EMPLEADO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vistaReporte)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnVerReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerReporte)
                    .addComponent(jLabel1)
                    .addComponent(cbxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            Map parametros = new HashMap();
//            String selectedItem = (String) cbxEmpleado.getSelectedItem();
            parametros.put("id", cbxEmpleado.getSelectedIndex());
            
            //JOptionPane.showMessageDialog(this, "Procesando Reporte");
            JRViewer objReporte = new Reporte().reporteInterno("boleta_informatica_v2.jasper", parametros);
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
    private javax.swing.JComboBox<String> cbxEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JDesktopPane vistaReporte;
    // End of variables declaration//GEN-END:variables
}
