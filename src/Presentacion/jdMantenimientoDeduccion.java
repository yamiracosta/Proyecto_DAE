/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.Deduccion;
import Negocio.TipoDeduccion;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jefer
 */
public class jdMantenimientoDeduccion extends javax.swing.JDialog {

    Deduccion objD = new Deduccion();
    TipoDeduccion objTD = new TipoDeduccion();

    public jdMantenimientoDeduccion(java.awt.Frame parent, boolean modal) {
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

        panel_Round_JWC1 = new swing.Panel_Round_JWC();
        panel_Round_Degradado_JWC1 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        jLabel4 = new javax.swing.JLabel();
        txtNombreDeduccion = new javax.swing.JTextField();
        panel_Round_JWC2 = new swing.Panel_Round_JWC();
        btnAgregarDeduccion = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEditarDeduccion = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEliminarDeduccion = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnLimpiarTipoEmpleado = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboTipoDeduccion = new javax.swing.JComboBox<>();
        panel_Round_Degradado_JWC3 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        btnCerrar = new swing.Btn_Round_JWC();
        panel_Round_Degradado_JWC2 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeduccion = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtBuscarPorDeduccion = new javax.swing.JTextField();

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

        panel_Round_JWC1.setBackground(new java.awt.Color(255, 255, 255));
        panel_Round_JWC1.setEsqInferiorDerecha(50);
        panel_Round_JWC1.setEsqInferiorIzquierda(50);
        panel_Round_JWC1.setEsqSuperiorDerecha(50);
        panel_Round_JWC1.setEsqSuperiorIzquierda(50);
        panel_Round_JWC1.setPreferredSize(new java.awt.Dimension(1055, 590));

        panel_Round_Degradado_JWC1.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC1.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC1.setEnabled(false);
        panel_Round_Degradado_JWC1.setSuperior_izquierdo(50);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE:");

        txtNombreDeduccion.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtNombreDeduccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreDeduccionKeyTyped(evt);
            }
        });

        panel_Round_JWC2.setBackground(new java.awt.Color(51, 51, 51));
        panel_Round_JWC2.setEsqInferiorDerecha(50);
        panel_Round_JWC2.setEsqInferiorIzquierda(50);
        panel_Round_JWC2.setEsqSuperiorDerecha(50);
        panel_Round_JWC2.setEsqSuperiorIzquierda(50);

        btnAgregarDeduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/anadir (2).png"))); // NOI18N
        btnAgregarDeduccion.setText("");
        btnAgregarDeduccion.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnAgregarDeduccion.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnAgregarDeduccion.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnAgregarDeduccion.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnAgregarDeduccion.setEsquina_inferior_derecho(50);
        btnAgregarDeduccion.setEsquina_inferior_izquierdo(50);
        btnAgregarDeduccion.setEsquina_superior_derecho(50);
        btnAgregarDeduccion.setEsquina_superior_izquierdo(50);
        btnAgregarDeduccion.setFocusPainted(false);
        btnAgregarDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDeduccionActionPerformed(evt);
            }
        });

        btnEditarDeduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar (1).png"))); // NOI18N
        btnEditarDeduccion.setText("");
        btnEditarDeduccion.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnEditarDeduccion.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnEditarDeduccion.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnEditarDeduccion.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnEditarDeduccion.setEsquina_inferior_derecho(50);
        btnEditarDeduccion.setEsquina_inferior_izquierdo(50);
        btnEditarDeduccion.setEsquina_superior_derecho(50);
        btnEditarDeduccion.setEsquina_superior_izquierdo(50);
        btnEditarDeduccion.setFocusPainted(false);
        btnEditarDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDeduccionActionPerformed(evt);
            }
        });

        btnEliminarDeduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/boton-eliminar (1).png"))); // NOI18N
        btnEliminarDeduccion.setText("");
        btnEliminarDeduccion.setBackground_Hover_1(new java.awt.Color(255, 153, 153));
        btnEliminarDeduccion.setBackground_Hover_2(new java.awt.Color(255, 153, 153));
        btnEliminarDeduccion.setBackground_No_Hover_1(new java.awt.Color(245, 226, 226));
        btnEliminarDeduccion.setBackground_No_Hover_2(new java.awt.Color(245, 226, 226));
        btnEliminarDeduccion.setEsquina_inferior_derecho(50);
        btnEliminarDeduccion.setEsquina_inferior_izquierdo(50);
        btnEliminarDeduccion.setEsquina_superior_derecho(50);
        btnEliminarDeduccion.setEsquina_superior_izquierdo(50);
        btnEliminarDeduccion.setFocusPainted(false);
        btnEliminarDeduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDeduccionActionPerformed(evt);
            }
        });

        btnLimpiarTipoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escoba (1).png"))); // NOI18N
        btnLimpiarTipoEmpleado.setText("");
        btnLimpiarTipoEmpleado.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnLimpiarTipoEmpleado.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnLimpiarTipoEmpleado.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnLimpiarTipoEmpleado.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnLimpiarTipoEmpleado.setEsquina_inferior_derecho(50);
        btnLimpiarTipoEmpleado.setEsquina_inferior_izquierdo(50);
        btnLimpiarTipoEmpleado.setEsquina_superior_derecho(50);
        btnLimpiarTipoEmpleado.setEsquina_superior_izquierdo(50);
        btnLimpiarTipoEmpleado.setFocusPainted(false);
        btnLimpiarTipoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTipoEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_JWC2Layout = new javax.swing.GroupLayout(panel_Round_JWC2);
        panel_Round_JWC2.setLayout(panel_Round_JWC2Layout);
        panel_Round_JWC2Layout.setHorizontalGroup(
            panel_Round_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(btnAgregarDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panel_Round_JWC2Layout.setVerticalGroup(
            panel_Round_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MANTENIMIENTO "); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DEDUCCION"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TIPO DEDUCCION:");

        cboTipoDeduccion.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        cboTipoDeduccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------------" }));

        javax.swing.GroupLayout panel_Round_Degradado_JWC1Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC1);
        panel_Round_Degradado_JWC1.setLayout(panel_Round_Degradado_JWC1Layout);
        panel_Round_Degradado_JWC1Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(panel_Round_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreDeduccion)
                            .addComponent(cboTipoDeduccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addGap(35, 35, 35))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panel_Round_Degradado_JWC1Layout.setVerticalGroup(
            panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboTipoDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(panel_Round_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panel_Round_Degradado_JWC3.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC3.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC3.setEnabled(false);
        panel_Round_Degradado_JWC3.setInferior_izquierdo(50);

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

        javax.swing.GroupLayout panel_Round_Degradado_JWC3Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC3);
        panel_Round_Degradado_JWC3.setLayout(panel_Round_Degradado_JWC3Layout);
        panel_Round_Degradado_JWC3Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        panel_Round_Degradado_JWC3Layout.setVerticalGroup(
            panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panel_Round_Degradado_JWC2.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC2.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC2.setEnabled(false);
        panel_Round_Degradado_JWC2.setInferior_derecho(50);
        panel_Round_Degradado_JWC2.setSuperior_derecho(50);

        tblDeduccion.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblDeduccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDeduccion.setGridColor(new java.awt.Color(0, 0, 0));
        tblDeduccion.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblDeduccion.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblDeduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeduccionMouseClicked(evt);
            }
        });
        tblDeduccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblDeduccionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDeduccion);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Buscar por deducción:");

        txtBuscarPorDeduccion.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtBuscarPorDeduccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPorDeduccionKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_Degradado_JWC2Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC2);
        panel_Round_Degradado_JWC2.setLayout(panel_Round_Degradado_JWC2Layout);
        panel_Round_Degradado_JWC2Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_Degradado_JWC2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panel_Round_Degradado_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addComponent(txtBuscarPorDeduccion))
                .addContainerGap())
        );
        panel_Round_Degradado_JWC2Layout.setVerticalGroup(
            panel_Round_Degradado_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPorDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_Round_JWC1Layout = new javax.swing.GroupLayout(panel_Round_JWC1);
        panel_Round_JWC1.setLayout(panel_Round_JWC1Layout);
        panel_Round_JWC1Layout.setHorizontalGroup(
            panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Round_Degradado_JWC3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(panel_Round_Degradado_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Round_Degradado_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Round_JWC1Layout.setVerticalGroup(
            panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_JWC1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_Round_Degradado_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_Round_JWC1Layout.createSequentialGroup()
                        .addComponent(panel_Round_Degradado_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Round_Degradado_JWC3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Round_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_Round_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreDeduccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreDeduccionKeyTyped
        if (txtNombreDeduccion.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreDeduccionKeyTyped

    private void btnAgregarDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDeduccionActionPerformed
        try {
            if (txtNombreDeduccion.getText().isBlank() || cboTipoDeduccion.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese el nombre de la deducción o seleccione un tipo de deducción válido");
            } else {
                objD.registrarDeduccion(txtNombreDeduccion.getText(), cboTipoDeduccion.getSelectedItem().toString());
                limpiar();
                JOptionPane.showMessageDialog(rootPane, "Deducción registrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al registrar deducción --> " + e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarDeduccionActionPerformed

    private void btnEditarDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDeduccionActionPerformed
        try {
            if (tblDeduccion.getSelectedRowCount() > 0) {
                if (txtNombreDeduccion.getText().isBlank() || cboTipoDeduccion.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese el nombre de la deducción o seleccione un tipo de deducción válido");
                } else {
                    if (JOptionPane.showConfirmDialog(rootPane, "¿Modificar datos?", "Confirmar cambios", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        objD.modificarDeduccion(txtNombreDeduccion.getText(), cboTipoDeduccion.getSelectedItem().toString(),
                                Integer.parseInt(tblDeduccion.getValueAt(tblDeduccion.getSelectedRow(), 0).toString()));
                        limpiar();
                        JOptionPane.showMessageDialog(rootPane, "Datos modificados");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Seleccione una deducción de la lista");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al modificar deducción --> " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditarDeduccionActionPerformed

    private void btnEliminarDeduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDeduccionActionPerformed
        try {
            if (tblDeduccion.getSelectedRowCount() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Seleccione una deducción de la lista para eliminar");
            } else {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Eliminar deducción?", "Confirmar cambios", JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION) {
                    if (!objD.existenRegistrosReferenciados(Integer.parseInt(tblDeduccion.getValueAt(tblDeduccion.getSelectedRow(), 0).toString()))) {
                        objD.eliminarDeduccion(Integer.parseInt(tblDeduccion.getValueAt(tblDeduccion.getSelectedRow(), 0).toString()));
                        limpiar();
                        JOptionPane.showMessageDialog(rootPane, "Deducción eliminada");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No se puede eliminar. Esta deducción ya se encuentra referenciada en otras"
                                + " tablas");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al eliminar deducción --> " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarDeduccionActionPerformed

    private void btnLimpiarTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTipoEmpleadoActionPerformed
        try {
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoDeduccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimpiarTipoEmpleadoActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtBuscarPorDeduccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorDeduccionKeyReleased
        try {
            filtrar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Error al filtrar --> " + ex.getMessage());
        }
    }//GEN-LAST:event_txtBuscarPorDeduccionKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void tblDeduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeduccionMouseClicked
        if (tblDeduccion.getSelectedRowCount() > 0) {
            txtNombreDeduccion.setText(tblDeduccion.getValueAt(tblDeduccion.getSelectedRow(), 1).toString());
            cboTipoDeduccion.setSelectedItem(tblDeduccion.getValueAt(tblDeduccion.getSelectedRow(), 2));
        }
    }//GEN-LAST:event_tblDeduccionMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            listarTodo();
            cargarCboTipoDeduccion();
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoDeduccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void tblDeduccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDeduccionKeyReleased
        if (tblDeduccion.getSelectedRowCount() > 0) {
            txtNombreDeduccion.setText(tblDeduccion.getValueAt(tblDeduccion.getSelectedRow(), 1).toString());
            cboTipoDeduccion.setSelectedItem(tblDeduccion.getValueAt(tblDeduccion.getSelectedRow(), 2));
        }
    }//GEN-LAST:event_tblDeduccionKeyReleased

    private void cargarCboTipoDeduccion() throws Exception {
        ResultSet rs = objTD.cargarTiposDeduccion();
        while (rs.next()) {
            cboTipoDeduccion.addItem(rs.getString("tipo"));
        }
    }

    private void listarTodo() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Deducción");
        modelo.addColumn("Tipo de deducción");

        Object datos[] = new Object[3];

        ResultSet rs = objD.listarDeducciones();

        while (rs.next()) {
            datos[0] = rs.getInt("id");
            datos[1] = rs.getString("nombre");
            datos[2] = rs.getString("tipo");
            modelo.addRow(datos);
        }
        tblDeduccion.setModel(modelo);
    }

    private void filtrar() throws Exception {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Deducción");
        modelo.addColumn("Tipo de deducción");

        Object datos[] = new Object[3];

        ResultSet rs = objD.filtrarDeduccion(txtBuscarPorDeduccion.getText());

        while (rs.next()) {
            datos[0] = rs.getInt("id");
            datos[1] = rs.getString("nombre");
            datos[2] = rs.getString("tipo");
            modelo.addRow(datos);
        }
        tblDeduccion.setModel(modelo);
    }

    private void limpiar() throws Exception {
        txtNombreDeduccion.setText("");
        cboTipoDeduccion.setSelectedIndex(0);
        listarTodo();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnAgregarDeduccion;
    private swing.Btn_Round_JWC btnCerrar;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEditarDeduccion;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEliminarDeduccion;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnLimpiarTipoEmpleado;
    private javax.swing.JComboBox<String> cboTipoDeduccion;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC1;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC2;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC3;
    private swing.Panel_Round_JWC panel_Round_JWC1;
    private swing.Panel_Round_JWC panel_Round_JWC2;
    private javax.swing.JTable tblDeduccion;
    private javax.swing.JTextField txtBuscarPorDeduccion;
    private javax.swing.JTextField txtNombreDeduccion;
    // End of variables declaration//GEN-END:variables
}