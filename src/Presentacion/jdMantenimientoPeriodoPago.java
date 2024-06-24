/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.PeriodoPago;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class jdMantenimientoPeriodoPago extends javax.swing.JDialog {

    PeriodoPago objPP = new PeriodoPago();

    public jdMantenimientoPeriodoPago(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Round_JWC6 = new swing.Panel_Round_JWC();
        panel_Round_Degradado_JWC4 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        jLabel10 = new javax.swing.JLabel();
        txtNombrePeriodo = new javax.swing.JTextField();
        panel_Round_JWC7 = new swing.Panel_Round_JWC();
        btnAgregarPeriodo = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEditarPeriodo = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEliminarPeriodo = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnLimpiar = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionPeriodo = new javax.swing.JTextArea();
        panel_Round_Degradado_JWC5 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeriodo = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtBuscarPorPeriodo = new javax.swing.JTextField();
        panel_Round_Degradado_JWC6 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        btnCerrar = new swing.Btn_Round_JWC();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_Round_JWC6.setBackground(new java.awt.Color(255, 255, 255));
        panel_Round_JWC6.setEsqInferiorDerecha(50);
        panel_Round_JWC6.setEsqInferiorIzquierda(50);
        panel_Round_JWC6.setEsqSuperiorDerecha(50);
        panel_Round_JWC6.setEsqSuperiorIzquierda(50);

        panel_Round_Degradado_JWC4.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC4.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC4.setEnabled(false);
        panel_Round_Degradado_JWC4.setSuperior_izquierdo(50);

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PERIODO:");

        txtNombrePeriodo.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtNombrePeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePeriodoKeyTyped(evt);
            }
        });

        panel_Round_JWC7.setBackground(new java.awt.Color(51, 51, 51));
        panel_Round_JWC7.setEsqInferiorDerecha(50);
        panel_Round_JWC7.setEsqInferiorIzquierda(50);
        panel_Round_JWC7.setEsqSuperiorDerecha(50);
        panel_Round_JWC7.setEsqSuperiorIzquierda(50);

        btnAgregarPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/anadir (2).png"))); // NOI18N
        btnAgregarPeriodo.setText("");
        btnAgregarPeriodo.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnAgregarPeriodo.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnAgregarPeriodo.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnAgregarPeriodo.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnAgregarPeriodo.setEsquina_inferior_derecho(50);
        btnAgregarPeriodo.setEsquina_inferior_izquierdo(50);
        btnAgregarPeriodo.setEsquina_superior_derecho(50);
        btnAgregarPeriodo.setEsquina_superior_izquierdo(50);
        btnAgregarPeriodo.setFocusPainted(false);
        btnAgregarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPeriodoActionPerformed(evt);
            }
        });

        btnEditarPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar (1).png"))); // NOI18N
        btnEditarPeriodo.setText("");
        btnEditarPeriodo.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnEditarPeriodo.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnEditarPeriodo.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnEditarPeriodo.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnEditarPeriodo.setEsquina_inferior_derecho(50);
        btnEditarPeriodo.setEsquina_inferior_izquierdo(50);
        btnEditarPeriodo.setEsquina_superior_derecho(50);
        btnEditarPeriodo.setEsquina_superior_izquierdo(50);
        btnEditarPeriodo.setFocusPainted(false);
        btnEditarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPeriodoActionPerformed(evt);
            }
        });

        btnEliminarPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/boton-eliminar (1).png"))); // NOI18N
        btnEliminarPeriodo.setText("");
        btnEliminarPeriodo.setBackground_Hover_1(new java.awt.Color(255, 153, 153));
        btnEliminarPeriodo.setBackground_Hover_2(new java.awt.Color(255, 153, 153));
        btnEliminarPeriodo.setBackground_No_Hover_1(new java.awt.Color(245, 226, 226));
        btnEliminarPeriodo.setBackground_No_Hover_2(new java.awt.Color(245, 226, 226));
        btnEliminarPeriodo.setEsquina_inferior_derecho(50);
        btnEliminarPeriodo.setEsquina_inferior_izquierdo(50);
        btnEliminarPeriodo.setEsquina_superior_derecho(50);
        btnEliminarPeriodo.setEsquina_superior_izquierdo(50);
        btnEliminarPeriodo.setFocusPainted(false);
        btnEliminarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPeriodoActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escoba (1).png"))); // NOI18N
        btnLimpiar.setText("");
        btnLimpiar.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnLimpiar.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnLimpiar.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnLimpiar.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnLimpiar.setEsquina_inferior_derecho(50);
        btnLimpiar.setEsquina_inferior_izquierdo(50);
        btnLimpiar.setEsquina_superior_derecho(50);
        btnLimpiar.setEsquina_superior_izquierdo(50);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_JWC7Layout = new javax.swing.GroupLayout(panel_Round_JWC7);
        panel_Round_JWC7.setLayout(panel_Round_JWC7Layout);
        panel_Round_JWC7Layout.setHorizontalGroup(
            panel_Round_JWC7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC7Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(btnAgregarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panel_Round_JWC7Layout.setVerticalGroup(
            panel_Round_JWC7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("MANTENIMIENTO "); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PERIODO DE PAGO"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DESCRIPCIÓN:");

        txtDescripcionPeriodo.setColumns(20);
        txtDescripcionPeriodo.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtDescripcionPeriodo.setRows(5);
        txtDescripcionPeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionPeriodoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcionPeriodo);

        javax.swing.GroupLayout panel_Round_Degradado_JWC4Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC4);
        panel_Round_Degradado_JWC4.setLayout(panel_Round_Degradado_JWC4Layout);
        panel_Round_Degradado_JWC4Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_Round_JWC7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                                .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtNombrePeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel11)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panel_Round_Degradado_JWC4Layout.setVerticalGroup(
            panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(26, 26, 26)
                .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(35, 35, 35)
                .addComponent(panel_Round_JWC7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panel_Round_Degradado_JWC5.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC5.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC5.setEnabled(false);
        panel_Round_Degradado_JWC5.setInferior_derecho(50);
        panel_Round_Degradado_JWC5.setSuperior_derecho(50);

        tblPeriodo.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblPeriodo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPeriodo.setGridColor(new java.awt.Color(0, 0, 0));
        tblPeriodo.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblPeriodo.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeriodoMouseClicked(evt);
            }
        });
        tblPeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPeriodoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeriodo);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Buscar por periodo:");

        txtBuscarPorPeriodo.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtBuscarPorPeriodo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarPorPeriodoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPorPeriodoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_Degradado_JWC5Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC5);
        panel_Round_Degradado_JWC5.setLayout(panel_Round_Degradado_JWC5Layout);
        panel_Round_Degradado_JWC5Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_Degradado_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(panel_Round_Degradado_JWC5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtBuscarPorPeriodo))
                .addContainerGap())
        );
        panel_Round_Degradado_JWC5Layout.setVerticalGroup(
            panel_Round_Degradado_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPorPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_Round_Degradado_JWC6.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC6.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC6.setEnabled(false);
        panel_Round_Degradado_JWC6.setInferior_izquierdo(50);

        btnCerrar.setBackground(new java.awt.Color(51, 51, 51));
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("CERRAR");
        btnCerrar.setArco_esquina(20);
        btnCerrar.setColor_Hover(new java.awt.Color(93, 93, 93));
        btnCerrar.setColor_Normal(new java.awt.Color(51, 51, 51));
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_Degradado_JWC6Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC6);
        panel_Round_Degradado_JWC6.setLayout(panel_Round_Degradado_JWC6Layout);
        panel_Round_Degradado_JWC6Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC6Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Round_Degradado_JWC6Layout.setVerticalGroup(
            panel_Round_Degradado_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_Round_JWC6Layout = new javax.swing.GroupLayout(panel_Round_JWC6);
        panel_Round_JWC6.setLayout(panel_Round_JWC6Layout);
        panel_Round_JWC6Layout.setHorizontalGroup(
            panel_Round_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Round_Degradado_JWC4, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(panel_Round_Degradado_JWC6, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Round_Degradado_JWC5, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        panel_Round_JWC6Layout.setVerticalGroup(
            panel_Round_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_JWC6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_Round_Degradado_JWC5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(panel_Round_JWC6Layout.createSequentialGroup()
                        .addComponent(panel_Round_Degradado_JWC4, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Round_Degradado_JWC6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_Round_JWC6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Round_JWC6, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePeriodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePeriodoKeyTyped
        if (txtNombrePeriodo.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombrePeriodoKeyTyped

    private void btnAgregarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPeriodoActionPerformed
        if (txtNombrePeriodo.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese el nombre del periodo de pago");
        } else {
            try {
                registrar(txtNombrePeriodo, txtDescripcionPeriodo);
                limpiar();
                JOptionPane.showMessageDialog(rootPane, "Periodo de pago registrado");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al registrar periodo de pago --> " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnAgregarPeriodoActionPerformed

    private void btnEditarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPeriodoActionPerformed
        if (tblPeriodo.getSelectedRow() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un periodo de pago de la lista");
        } else {
            if (txtNombrePeriodo.getText().isBlank()) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese el nombre del periodo de pago");
            } else {
                try {
                    if (JOptionPane.showConfirmDialog(rootPane, "¿Modificar datos?", "Confirmación de cambios", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        modificar(txtNombrePeriodo, txtDescripcionPeriodo, tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 0).toString());
                        limpiar();
                        JOptionPane.showMessageDialog(rootPane, "Datos modificados");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Error al modificar datos de periodo de pago --> " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnEditarPeriodoActionPerformed

    private void btnEliminarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPeriodoActionPerformed
        if (tblPeriodo.getSelectedRowCount() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un periodo de pago de la lista para eliminar");
        } else {
            try {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Eliminar periodo de pago?", "Confirmación de cambios", JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION) {
                    if (!objPP.existenRegistrosReferenciados(Integer.parseInt(tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 0).toString()))) {
                        eliminar(tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 0).toString());
                        limpiar();
                        JOptionPane.showMessageDialog(rootPane, "Periodo de pago eliminado");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No se puede eliminar. El periodo de pago ya está referenciado en otras tablas");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al eliminar periodo de pago --> " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarPeriodoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        try {
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoPeriodoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtDescripcionPeriodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionPeriodoKeyTyped
        if (txtDescripcionPeriodo.getText().length() >= 300) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionPeriodoKeyTyped

    private void tblPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeriodoMouseClicked
        if (tblPeriodo.getSelectedRowCount() > 0) {
            txtNombrePeriodo.setText(tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 1).toString());
            txtDescripcionPeriodo.setText(tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 2).toString());
            if (tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 2).toString() == "No tiene") {
                txtDescripcionPeriodo.setText("");
            }
        }
    }//GEN-LAST:event_tblPeriodoMouseClicked

    private void txtBuscarPorPeriodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorPeriodoKeyPressed

    }//GEN-LAST:event_txtBuscarPorPeriodoKeyPressed

    private void txtBuscarPorPeriodoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorPeriodoKeyReleased
        try {
            filtrar(txtBuscarPorPeriodo);
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoPeriodoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscarPorPeriodoKeyReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            listarTodo();
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoPeriodoPago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void tblPeriodoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPeriodoKeyReleased
        if (tblPeriodo.getSelectedRowCount() > 0) {
            txtNombrePeriodo.setText(tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 1).toString());
            txtDescripcionPeriodo.setText(tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 2).toString());
            if (tblPeriodo.getValueAt(tblPeriodo.getSelectedRow(), 2).toString() == "No tiene") {
                txtDescripcionPeriodo.setText("");
            }
        }
    }//GEN-LAST:event_tblPeriodoKeyReleased

    private void listarTodo() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Periodo de pago");
        modelo.addColumn("Descripción");

        ResultSet rs = objPP.listarPeriodos();

        Object datos[] = new Object[3];

        while (rs.next()) {
            datos[0] = rs.getInt("id");
            datos[1] = rs.getString("nombre");
            datos[2] = rs.getString("descripcion");
            if (datos[2] == null) {
                datos[2] = "No tiene";
            } else {
                datos[2] = rs.getString("descripcion");
            }
            modelo.addRow(datos);
        }
        tblPeriodo.setModel(modelo);
    }

    private void filtrar(JTextField periodo) throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Periodo de pago");
        modelo.addColumn("Descripción");

        ResultSet rs = objPP.filtrarPeriodo(periodo.getText());

        Object datos[] = new Object[3];

        while (rs.next()) {
            datos[0] = rs.getInt("id");
            datos[1] = rs.getString("nombre");
            datos[2] = rs.getString("descripcion");
            if (datos[2] == null) {
                datos[2] = "No tiene";
            } else {
                datos[2] = rs.getString("descripcion");
            }
            modelo.addRow(datos);
        }
        tblPeriodo.setModel(modelo);
    }

    private void registrar(JTextField periodo, JTextArea descri) throws Exception {
        String descr = null;
        if (descri.getText().isBlank()) {
            descr = "";
        }
        objPP.registrarPeriodoPago(periodo.getText(), descr);
    }

    private void modificar(JTextField periodo, JTextArea descri, String codigo) throws Exception {
        String descr = null;
        if (descri.getText().isBlank()) {
            descr = "";
        } else {
            descr = descri.getText();
        }
        objPP.modificarPeriodoPago(periodo.getText(), descr, Integer.parseInt(codigo));
    }

    private void eliminar(String codigo) throws Exception {
        objPP.eliminarPeriodoPago(Integer.parseInt(codigo));
    }

    private void limpiar() throws Exception {
        txtNombrePeriodo.setText("");
        txtDescripcionPeriodo.setText("");
        listarTodo();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnAgregarPeriodo;
    private swing.Btn_Round_JWC btnCerrar;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEditarPeriodo;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEliminarPeriodo;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnLimpiar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC4;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC5;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC6;
    private swing.Panel_Round_JWC panel_Round_JWC6;
    private swing.Panel_Round_JWC panel_Round_JWC7;
    private javax.swing.JTable tblPeriodo;
    private javax.swing.JTextField txtBuscarPorPeriodo;
    private javax.swing.JTextArea txtDescripcionPeriodo;
    private javax.swing.JTextField txtNombrePeriodo;
    // End of variables declaration//GEN-END:variables
}
