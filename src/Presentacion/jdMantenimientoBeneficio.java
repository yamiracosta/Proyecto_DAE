/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.Beneficio;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author jefer
 */
public class jdMantenimientoBeneficio extends javax.swing.JDialog {

    Beneficio obj = new Beneficio();

    public jdMantenimientoBeneficio(java.awt.Frame parent, boolean modal) {
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

        panel_Round_JWC5 = new swing.Panel_Round_JWC();
        panel_Round_Degradado_JWC3 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        jLabel8 = new javax.swing.JLabel();
        txtNombreBeneficio = new javax.swing.JTextField();
        panel_Round_JWC6 = new swing.Panel_Round_JWC();
        btnAgregarBeneficio = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEditarBeneficio = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEliminarBeneficio = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnLimpiar = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionBeneficio = new javax.swing.JTextArea();
        panel_Round_Degradado_JWC4 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBeneficio = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtBuscarPorNombre = new javax.swing.JTextField();
        panel_Round_Degradado_JWC5 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
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

        panel_Round_JWC5.setBackground(new java.awt.Color(255, 255, 255));
        panel_Round_JWC5.setEsqInferiorDerecha(50);
        panel_Round_JWC5.setEsqInferiorIzquierda(50);
        panel_Round_JWC5.setEsqSuperiorDerecha(50);
        panel_Round_JWC5.setEsqSuperiorIzquierda(50);

        panel_Round_Degradado_JWC3.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC3.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC3.setEnabled(false);
        panel_Round_Degradado_JWC3.setSuperior_izquierdo(50);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NOMBRE:");

        txtNombreBeneficio.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtNombreBeneficio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBeneficioKeyTyped(evt);
            }
        });

        panel_Round_JWC6.setBackground(new java.awt.Color(51, 51, 51));
        panel_Round_JWC6.setEsqInferiorDerecha(50);
        panel_Round_JWC6.setEsqInferiorIzquierda(50);
        panel_Round_JWC6.setEsqSuperiorDerecha(50);
        panel_Round_JWC6.setEsqSuperiorIzquierda(50);

        btnAgregarBeneficio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/anadir (2).png"))); // NOI18N
        btnAgregarBeneficio.setText("");
        btnAgregarBeneficio.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnAgregarBeneficio.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnAgregarBeneficio.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnAgregarBeneficio.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnAgregarBeneficio.setEsquina_inferior_derecho(50);
        btnAgregarBeneficio.setEsquina_inferior_izquierdo(50);
        btnAgregarBeneficio.setEsquina_superior_derecho(50);
        btnAgregarBeneficio.setEsquina_superior_izquierdo(50);
        btnAgregarBeneficio.setFocusPainted(false);
        btnAgregarBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBeneficioActionPerformed(evt);
            }
        });

        btnEditarBeneficio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar (1).png"))); // NOI18N
        btnEditarBeneficio.setText("");
        btnEditarBeneficio.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnEditarBeneficio.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnEditarBeneficio.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnEditarBeneficio.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnEditarBeneficio.setEsquina_inferior_derecho(50);
        btnEditarBeneficio.setEsquina_inferior_izquierdo(50);
        btnEditarBeneficio.setEsquina_superior_derecho(50);
        btnEditarBeneficio.setEsquina_superior_izquierdo(50);
        btnEditarBeneficio.setFocusPainted(false);
        btnEditarBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarBeneficioActionPerformed(evt);
            }
        });

        btnEliminarBeneficio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/boton-eliminar (1).png"))); // NOI18N
        btnEliminarBeneficio.setText("");
        btnEliminarBeneficio.setBackground_Hover_1(new java.awt.Color(255, 153, 153));
        btnEliminarBeneficio.setBackground_Hover_2(new java.awt.Color(255, 153, 153));
        btnEliminarBeneficio.setBackground_No_Hover_1(new java.awt.Color(245, 226, 226));
        btnEliminarBeneficio.setBackground_No_Hover_2(new java.awt.Color(245, 226, 226));
        btnEliminarBeneficio.setEsquina_inferior_derecho(50);
        btnEliminarBeneficio.setEsquina_inferior_izquierdo(50);
        btnEliminarBeneficio.setEsquina_superior_derecho(50);
        btnEliminarBeneficio.setEsquina_superior_izquierdo(50);
        btnEliminarBeneficio.setFocusPainted(false);
        btnEliminarBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarBeneficioActionPerformed(evt);
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

        javax.swing.GroupLayout panel_Round_JWC6Layout = new javax.swing.GroupLayout(panel_Round_JWC6);
        panel_Round_JWC6.setLayout(panel_Round_JWC6Layout);
        panel_Round_JWC6Layout.setHorizontalGroup(
            panel_Round_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC6Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(btnAgregarBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panel_Round_JWC6Layout.setVerticalGroup(
            panel_Round_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MANTENIMIENTO "); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("BENEFICIO"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESCRIPCIÓN:");

        txtDescripcionBeneficio.setColumns(20);
        txtDescripcionBeneficio.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtDescripcionBeneficio.setRows(5);
        txtDescripcionBeneficio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionBeneficioKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcionBeneficio);

        javax.swing.GroupLayout panel_Round_Degradado_JWC3Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC3);
        panel_Round_Degradado_JWC3.setLayout(panel_Round_Degradado_JWC3Layout);
        panel_Round_Degradado_JWC3Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Round_JWC6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                        .addGroup(panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtNombreBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel9)))
                .addGap(51, 51, 51))
        );
        panel_Round_Degradado_JWC3Layout.setVerticalGroup(
            panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(43, 43, 43)
                .addComponent(panel_Round_JWC6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panel_Round_Degradado_JWC4.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC4.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC4.setEnabled(false);
        panel_Round_Degradado_JWC4.setInferior_derecho(50);
        panel_Round_Degradado_JWC4.setSuperior_derecho(50);

        tblBeneficio.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblBeneficio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblBeneficio.setGridColor(new java.awt.Color(0, 0, 0));
        tblBeneficio.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblBeneficio.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblBeneficio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBeneficioMouseClicked(evt);
            }
        });
        tblBeneficio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblBeneficioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBeneficio);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Buscar por nombre:");

        txtBuscarPorNombre.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtBuscarPorNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarPorNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPorNombreKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_Degradado_JWC4Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC4);
        panel_Round_Degradado_JWC4.setLayout(panel_Round_Degradado_JWC4Layout);
        panel_Round_Degradado_JWC4Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscarPorNombre)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Round_Degradado_JWC4Layout.setVerticalGroup(
            panel_Round_Degradado_JWC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_Round_Degradado_JWC5.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC5.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC5.setEnabled(false);
        panel_Round_Degradado_JWC5.setInferior_izquierdo(50);

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

        javax.swing.GroupLayout panel_Round_Degradado_JWC5Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC5);
        panel_Round_Degradado_JWC5.setLayout(panel_Round_Degradado_JWC5Layout);
        panel_Round_Degradado_JWC5Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC5Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Round_Degradado_JWC5Layout.setVerticalGroup(
            panel_Round_Degradado_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_Round_JWC5Layout = new javax.swing.GroupLayout(panel_Round_JWC5);
        panel_Round_JWC5.setLayout(panel_Round_JWC5Layout);
        panel_Round_JWC5Layout.setHorizontalGroup(
            panel_Round_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_Round_Degradado_JWC3, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(panel_Round_Degradado_JWC5, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Round_Degradado_JWC4, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Round_JWC5Layout.setVerticalGroup(
            panel_Round_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_JWC5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_Round_Degradado_JWC4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(panel_Round_JWC5Layout.createSequentialGroup()
                        .addComponent(panel_Round_Degradado_JWC3, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Round_Degradado_JWC5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_Round_JWC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Round_JWC5, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreBeneficioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBeneficioKeyTyped
        if (txtNombreBeneficio.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreBeneficioKeyTyped

    private void btnAgregarBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBeneficioActionPerformed
        if (txtNombreBeneficio.getText().isBlank() || txtDescripcionBeneficio.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, complete todos los campos");
        } else {
            try {
                agregarBeneficio(txtNombreBeneficio.getText(), txtDescripcionBeneficio.getText());
                limpiar();
                JOptionPane.showMessageDialog(rootPane, "Beneficio registrado");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al registrar beneficio --> " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnAgregarBeneficioActionPerformed

    private void btnEditarBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarBeneficioActionPerformed
        if (tblBeneficio.getSelectedRowCount() > 0) {
            if (txtNombreBeneficio.getText().isBlank() || txtDescripcionBeneficio.getText().isBlank()) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, complete todos los campos");
            } else {
                try {
                    if (JOptionPane.showConfirmDialog(rootPane, "¿Modificar datos?", "Confirmación de cambios", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        modificarBeneficio(txtNombreBeneficio.getText(), txtDescripcionBeneficio.getText(),
                                Integer.parseInt(tblBeneficio.getValueAt(tblBeneficio.getSelectedRow(), 0).toString()));
                        limpiar();
                        JOptionPane.showMessageDialog(rootPane, "Datos modificados");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Error al modificar beneficio --> " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un beneficio de la lista");
        }

    }//GEN-LAST:event_btnEditarBeneficioActionPerformed

    private void btnEliminarBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBeneficioActionPerformed
        if (tblBeneficio.getSelectedRowCount() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un beneficio de la lista para eliminar");
        } else {
            try {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Eliminar beneficio?", "Confirmación de cambios", JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION) {
                    String codigo = tblBeneficio.getValueAt(tblBeneficio.getSelectedRow(), 0).toString();
                    if (!obj.existenRegistrosRelacionados(Integer.parseInt(codigo))) {
                        eliminarBeneficio(Integer.parseInt(codigo));
                        limpiar();
                        JOptionPane.showMessageDialog(rootPane, "Beneficio eliminado");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No se puede eliminar. El beneficio ya está referenciado en otras tablas");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al eliminar beneficio --> " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarBeneficioActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        try {
            limpiar();
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtDescripcionBeneficioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionBeneficioKeyTyped
        if (txtDescripcionBeneficio.getText().length() >= 300) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionBeneficioKeyTyped

    private void tblBeneficioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBeneficioMouseClicked
        if (tblBeneficio.getSelectedRowCount() > 0) {
            txtNombreBeneficio.setText(tblBeneficio.getValueAt(tblBeneficio.getSelectedRow(), 1).toString());
            txtDescripcionBeneficio.setText(tblBeneficio.getValueAt(tblBeneficio.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_tblBeneficioMouseClicked

    private void txtBuscarPorNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorNombreKeyPressed

    }//GEN-LAST:event_txtBuscarPorNombreKeyPressed

    private void txtBuscarPorNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorNombreKeyReleased
        try {
            filtrarBeneficio(txtBuscarPorNombre.getText());
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscarPorNombreKeyReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            listarTodo();
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoBeneficio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void tblBeneficioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBeneficioKeyReleased
        if (tblBeneficio.getSelectedRowCount() > 0) {
            txtNombreBeneficio.setText(tblBeneficio.getValueAt(tblBeneficio.getSelectedRow(), 1).toString());
            txtDescripcionBeneficio.setText(tblBeneficio.getValueAt(tblBeneficio.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_tblBeneficioKeyReleased

    private void listarTodo() throws Exception {
        ResultSet rs = obj.listarTodo();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Beneficio");
        modelo.addColumn("Descripción");

        Object datos[] = new Object[3];

        while (rs.next()) {
            datos[0] = rs.getInt("id");
            datos[1] = rs.getString("nombre");
            datos[2] = rs.getString("descripcion");
            modelo.addRow(datos);
        }
        tblBeneficio.setModel(modelo);
    }

    private void filtrarBeneficio(String beneficio) throws Exception {
        ResultSet rs = obj.filtrarBeneficio(beneficio);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Beneficio");
        modelo.addColumn("Descripción");

        Object datos[] = new Object[3];

        while (rs.next()) {
            datos[0] = rs.getInt("id");
            datos[1] = rs.getString("nombre");
            datos[2] = rs.getString("descripcion");
            modelo.addRow(datos);
        }
        tblBeneficio.setModel(modelo);
    }

    private void agregarBeneficio(String beneficio, String descr) throws Exception {
        obj.registrarBeneficio(beneficio, descr);
    }

    private void modificarBeneficio(String beneficio, String descr, int id) throws Exception {
        obj.modificarBeneficio(beneficio, descr, id);
    }

    private void eliminarBeneficio(int id) throws Exception {
        obj.eliminarBeneficio(id);
    }

    private void limpiar() throws Exception {
        txtNombreBeneficio.setText("");
        txtDescripcionBeneficio.setText("");
        listarTodo();
    }
    
    /*private static void adjustColumnWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                // Ensure the column width does not exceed the max width
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }*/

    private static int getMaxTableWidth(JTable table) {
        int totalWidth = 0;
        for (int column = 0; column < table.getColumnCount(); column++) {
            totalWidth += table.getColumnModel().getColumn(column).getPreferredWidth();
        }
        return totalWidth;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnAgregarBeneficio;
    private swing.Btn_Round_JWC btnCerrar;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEditarBeneficio;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEliminarBeneficio;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnLimpiar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC3;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC4;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC5;
    private swing.Panel_Round_JWC panel_Round_JWC5;
    private swing.Panel_Round_JWC panel_Round_JWC6;
    private javax.swing.JTable tblBeneficio;
    private javax.swing.JTextField txtBuscarPorNombre;
    private javax.swing.JTextArea txtDescripcionBeneficio;
    private javax.swing.JTextField txtNombreBeneficio;
    // End of variables declaration//GEN-END:variables
}
