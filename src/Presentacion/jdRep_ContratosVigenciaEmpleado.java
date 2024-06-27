/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.Empleado;
import Negocio.Reporte;
import java.awt.BorderLayout;
import java.awt.Container;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.sf.jasperreports.swing.JRViewer;

public class jdRep_ContratosVigenciaEmpleado extends javax.swing.JDialog {

    Empleado objE = new Empleado();

    public jdRep_ContratosVigenciaEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            cargarCboEmpleado();
            dp.setVisible(false);
            setLocationRelativeTo(this);
        } catch (Exception ex) {
            Logger.getLogger(jdRep_ContratosVigenciaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarCboEmpleado() throws Exception {
        ResultSet rs = objE.obtenerEmpleados();
        cboEmpleado.removeAllItems();
        while (rs.next()) {
            cboEmpleado.addItem(rs.getString("nombre_empleado"));
        }
    }

    private void mostrarReporte(JComboBox cboVig, JComboBox cboEmp) throws Exception {
        Container contenedor = this.dp;
        contenedor.setLayout(new BorderLayout());
        Map parametros = new HashMap();

        int idempleado = objE.obtenerIdEmpleado(cboEmp.getSelectedItem().toString());
        String vig = "";
        if (cboVig.getSelectedItem().toString().equals("Vigente")) {
            vig = "V";
        } else if (cboVig.getSelectedItem().toString().equals("No vigente")) {
            vig = "N";
        } else {
            vig = "T";
        }

        parametros.put("idempleado_reporteprincipal", idempleado);
        parametros.put("vigencia_cont", vig);
        JRViewer objReporte = new Reporte().reporteInterno("jdRep_ContratosPorVigenciaEmpleado.jasper", parametros);
        contenedor.add(objReporte);
        this.dp.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp = new javax.swing.JDesktopPane();
        cboVigencia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboEmpleado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout dpLayout = new javax.swing.GroupLayout(dp);
        dp.setLayout(dpLayout);
        dpLayout.setHorizontalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dpLayout.setVerticalGroup(
            dpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        cboVigencia.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        cboVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vigente", "No vigente", "Culminado" }));
        cboVigencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboVigenciaItemStateChanged(evt);
            }
        });

        jLabel1.setText("Empleado:");

        cboEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboEmpleadoItemStateChanged(evt);
            }
        });
        cboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dp)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dp)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpleadoActionPerformed

    }//GEN-LAST:event_cboEmpleadoActionPerformed

    private void cboVigenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVigenciaItemStateChanged
        try {
            mostrarReporte(cboVigencia, cboEmpleado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() + "Error al mostrar reporte", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cboVigenciaItemStateChanged

    private void cboEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboEmpleadoItemStateChanged
        if (cboEmpleado.getSelectedItem() != null) {
            try {
                mostrarReporte(cboVigencia, cboEmpleado);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage() + "Error al mostrar reporte", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_cboEmpleadoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboEmpleado;
    private javax.swing.JComboBox<String> cboVigencia;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
