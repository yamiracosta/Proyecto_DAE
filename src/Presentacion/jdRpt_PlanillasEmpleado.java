/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.Empleado;
import Negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

import net.sf.jasperreports.swing.JRViewer;
import Negocio.Empleado2;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ELISBETH
 */
public class jdRpt_PlanillasEmpleado extends javax.swing.JDialog {

    Empleado objE = new Empleado();

    private void listarCboEmpleados() throws SQLException, Exception{
        ResultSet rs = objE.obtenerEmpleados();
        cbxEmpleado.removeAllItems();
        while (rs.next()) {
            cbxEmpleado.addItem(rs.getString("nombre_empleado"));
        }
    }

    /**
     * Creates new form jdPalnillasEmpleado
     */
    public jdRpt_PlanillasEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            listarCboEmpleados();
            this.vistaReporte.setVisible(false);
            setLocationRelativeTo(this);
        } catch (Exception ex) {
            Logger.getLogger(jdRpt_PlanillasEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vistaReporte = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        btnVerReporte = new javax.swing.JButton();
        cbxEmpleado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informe de Planillas de Pago por Empleado");

        javax.swing.GroupLayout vistaReporteLayout = new javax.swing.GroupLayout(vistaReporte);
        vistaReporte.setLayout(vistaReporteLayout);
        vistaReporteLayout.setHorizontalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );
        vistaReporteLayout.setVerticalGroup(
            vistaReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jLabel1.setText("EMPLEADO");

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
                .addGap(111, 111, 111)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(btnVerReporte)
                .addGap(204, 204, 204))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(vistaReporte)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnVerReporte)
                    .addComponent(cbxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(552, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(vistaReporte)
                    .addGap(55, 55, 55)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporteActionPerformed
        try {
            Container contenedor = this.vistaReporte;
            contenedor.setLayout(new BorderLayout());
            Map parametros = new HashMap();
            //            String selectedItem = (String) cbxEmpleado.getSelectedItem();
            parametros.put("id_Empleado", objE.obtenerIdEmpleado(cbxEmpleado.getSelectedItem().toString()));

            //JOptionPane.showMessageDialog(this, "Procesando Reporte");
            JRViewer objReporte = new Reporte().reporteInterno("ReportePlanillasPago.jasper", parametros);
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
