/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.Area;
import Negocio.TipoEmpleado;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author jefer
 */
public class jdMantenimientoTipoEmpleado extends javax.swing.JDialog {

    TipoEmpleado tipoEmpleado = new TipoEmpleado();
    Area are = new Area();

    public jdMantenimientoTipoEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(this);

        try {
            tipoEmpleado.listarTablaTipoEmpleado(tabla_TipoPersona);
            are.listarComboAreas(cbxArea);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        tabla_TipoPersona.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                int seleccionFila = tabla_TipoPersona.getSelectedRow();
                if (seleccionFila > -1) {
                    Object nombre = tabla_TipoPersona.getValueAt(seleccionFila, 1);
                    Object descri = tabla_TipoPersona.getValueAt(seleccionFila, 2);
                    Object area = tabla_TipoPersona.getValueAt(seleccionFila, 3);
                    Object remu = tabla_TipoPersona.getValueAt(seleccionFila, 4);
                    txtNombreTipoEmpleado.setText(nombre.toString());
                    txtDescripcionTipoEmpleado.setText(descri.toString());
                    cbxArea.setSelectedItem(area.toString());

                    int puntoIndex = remu.toString().indexOf('.');
                    txtRemuneracion.setText(remu.toString().substring(0, puntoIndex));
                }
            }
        });

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
        txtNombreTipoEmpleado = new javax.swing.JTextField();
        panel_Round_JWC2 = new swing.Panel_Round_JWC();
        btnAgregarTipoEmpleado = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEditarTipoEmpleado = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnEliminarTipoEmpleado = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnLimpiarTipoEmpleado = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionTipoEmpleado = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtRemuneracion = new javax.swing.JTextField();
        panel_Round_Degradado_JWC3 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        btnCerrar = new swing.Btn_Round_JWC();
        panel_Round_Degradado_JWC2 = new panel_degradado_jwc.Panel_Round_Degradado_JWC();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_TipoPersona = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtBuscarPorTipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panel_Round_JWC1.setBackground(new java.awt.Color(255, 255, 255));
        panel_Round_JWC1.setEsqInferiorDerecha(50);
        panel_Round_JWC1.setEsqInferiorIzquierda(50);
        panel_Round_JWC1.setEsqSuperiorDerecha(50);
        panel_Round_JWC1.setEsqSuperiorIzquierda(50);

        panel_Round_Degradado_JWC1.setBackground(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC1.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC1.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC1.setEnabled(false);
        panel_Round_Degradado_JWC1.setSuperior_izquierdo(50);

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NOMBRE:");

        txtNombreTipoEmpleado.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtNombreTipoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreTipoEmpleadoKeyTyped(evt);
            }
        });

        panel_Round_JWC2.setBackground(new java.awt.Color(51, 51, 51));
        panel_Round_JWC2.setEsqInferiorDerecha(50);
        panel_Round_JWC2.setEsqInferiorIzquierda(50);
        panel_Round_JWC2.setEsqSuperiorDerecha(50);
        panel_Round_JWC2.setEsqSuperiorIzquierda(50);

        btnAgregarTipoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/anadir (2).png"))); // NOI18N
        btnAgregarTipoEmpleado.setText("");
        btnAgregarTipoEmpleado.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnAgregarTipoEmpleado.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnAgregarTipoEmpleado.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnAgregarTipoEmpleado.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnAgregarTipoEmpleado.setEsquina_inferior_derecho(50);
        btnAgregarTipoEmpleado.setEsquina_inferior_izquierdo(50);
        btnAgregarTipoEmpleado.setEsquina_superior_derecho(50);
        btnAgregarTipoEmpleado.setEsquina_superior_izquierdo(50);
        btnAgregarTipoEmpleado.setFocusPainted(false);
        btnAgregarTipoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTipoEmpleadoActionPerformed(evt);
            }
        });

        btnEditarTipoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar (1).png"))); // NOI18N
        btnEditarTipoEmpleado.setText("");
        btnEditarTipoEmpleado.setBackground_Hover_1(new java.awt.Color(255, 255, 255));
        btnEditarTipoEmpleado.setBackground_Hover_2(new java.awt.Color(255, 255, 255));
        btnEditarTipoEmpleado.setBackground_No_Hover_1(new java.awt.Color(221, 239, 168));
        btnEditarTipoEmpleado.setBackground_No_Hover_2(new java.awt.Color(146, 161, 214));
        btnEditarTipoEmpleado.setEsquina_inferior_derecho(50);
        btnEditarTipoEmpleado.setEsquina_inferior_izquierdo(50);
        btnEditarTipoEmpleado.setEsquina_superior_derecho(50);
        btnEditarTipoEmpleado.setEsquina_superior_izquierdo(50);
        btnEditarTipoEmpleado.setFocusPainted(false);
        btnEditarTipoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTipoEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarTipoEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/boton-eliminar (1).png"))); // NOI18N
        btnEliminarTipoEmpleado.setText("");
        btnEliminarTipoEmpleado.setBackground_Hover_1(new java.awt.Color(255, 153, 153));
        btnEliminarTipoEmpleado.setBackground_Hover_2(new java.awt.Color(255, 153, 153));
        btnEliminarTipoEmpleado.setBackground_No_Hover_1(new java.awt.Color(245, 226, 226));
        btnEliminarTipoEmpleado.setBackground_No_Hover_2(new java.awt.Color(245, 226, 226));
        btnEliminarTipoEmpleado.setEsquina_inferior_derecho(50);
        btnEliminarTipoEmpleado.setEsquina_inferior_izquierdo(50);
        btnEliminarTipoEmpleado.setEsquina_superior_derecho(50);
        btnEliminarTipoEmpleado.setEsquina_superior_izquierdo(50);
        btnEliminarTipoEmpleado.setFocusPainted(false);
        btnEliminarTipoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTipoEmpleadoActionPerformed(evt);
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
                .addComponent(btnAgregarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnEliminarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MANTENIMIENTO "); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DEL TIPO DE EMPLEADO"); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DESCRIPCION:");

        txtDescripcionTipoEmpleado.setColumns(20);
        txtDescripcionTipoEmpleado.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtDescripcionTipoEmpleado.setRows(5);
        txtDescripcionTipoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionTipoEmpleadoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcionTipoEmpleado);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("AREA:");

        cbxArea.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        cbxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------------" }));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("RENUMERACION:");

        txtRemuneracion.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtRemuneracion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRemuneracionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_Degradado_JWC1Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC1);
        panel_Round_Degradado_JWC1.setLayout(panel_Round_Degradado_JWC1Layout);
        panel_Round_Degradado_JWC1Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(41, 41, 41)))
                .addGap(33, 33, 33))
            .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_Round_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(txtRemuneracion))))
                .addGap(23, 23, 23))
        );
        panel_Round_Degradado_JWC1Layout.setVerticalGroup(
            panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreTipoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(panel_Round_Degradado_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtRemuneracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(panel_Round_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panel_Round_Degradado_JWC3.setBackground(new java.awt.Color(69, 161, 137));
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
                .addGap(68, 68, 68))
        );
        panel_Round_Degradado_JWC3Layout.setVerticalGroup(
            panel_Round_Degradado_JWC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panel_Round_Degradado_JWC2.setBackground(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC2.setColor1(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC2.setColor2(new java.awt.Color(69, 161, 137));
        panel_Round_Degradado_JWC2.setEnabled(false);
        panel_Round_Degradado_JWC2.setInferior_derecho(50);
        panel_Round_Degradado_JWC2.setSuperior_derecho(50);

        tabla_TipoPersona.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tabla_TipoPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_TipoPersona.setGridColor(new java.awt.Color(0, 0, 0));
        tabla_TipoPersona.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tabla_TipoPersona.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla_TipoPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabla_TipoPersonaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_TipoPersona);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Buscar por tipo de empleado:");

        txtBuscarPorTipo.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtBuscarPorTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPorTipoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel_Round_Degradado_JWC2Layout = new javax.swing.GroupLayout(panel_Round_Degradado_JWC2);
        panel_Round_Degradado_JWC2.setLayout(panel_Round_Degradado_JWC2Layout);
        panel_Round_Degradado_JWC2Layout.setHorizontalGroup(
            panel_Round_Degradado_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_Degradado_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(txtBuscarPorTipo)
                    .addGroup(panel_Round_Degradado_JWC2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_Round_Degradado_JWC2Layout.setVerticalGroup(
            panel_Round_Degradado_JWC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_Degradado_JWC2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarPorTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_Round_JWC1Layout = new javax.swing.GroupLayout(panel_Round_JWC1);
        panel_Round_JWC1.setLayout(panel_Round_JWC1Layout);
        panel_Round_JWC1Layout.setHorizontalGroup(
            panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel_Round_Degradado_JWC3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addComponent(panel_Round_Degradado_JWC1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Round_Degradado_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_Round_JWC1Layout.setVerticalGroup(
            panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_Round_JWC1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_Round_JWC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_Round_Degradado_JWC2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_Round_JWC1Layout.createSequentialGroup()
                        .addComponent(panel_Round_Degradado_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Round_Degradado_JWC3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Round_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Round_JWC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreTipoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreTipoEmpleadoKeyTyped
        if (txtNombreTipoEmpleado.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreTipoEmpleadoKeyTyped

    private void btnAgregarTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTipoEmpleadoActionPerformed
        try {
            if (txtNombreTipoEmpleado.getText().isBlank() || cbxArea.getSelectedIndex() == 0 || txtDescripcionTipoEmpleado.getText().isBlank()
                    || txtRemuneracion.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos o seleccione un área");
            } else {
                tipoEmpleado.agregarTipoEmpleado(txtNombreTipoEmpleado, txtDescripcionTipoEmpleado, cbxArea, txtRemuneracion);
                limpiar();
                JOptionPane.showMessageDialog(null, "Tipo de empleado agregado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo agregar al tipo de empleado. Intente nuevamente");
        }
    }//GEN-LAST:event_btnAgregarTipoEmpleadoActionPerformed

    private void btnEditarTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTipoEmpleadoActionPerformed
        try {
            if (tabla_TipoPersona.getSelectedRowCount() <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Seleccione un tipo de empleado de la lista");
            } else {
                if (txtNombreTipoEmpleado.getText().isBlank() || txtDescripcionTipoEmpleado.getText().isBlank()
                        || txtRemuneracion.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos o seleccione un área");
                } else {
                    if (JOptionPane.showConfirmDialog(rootPane, "¿Modificar datos?", "Confirmar cambios", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        tipoEmpleado.editarTipoEmpleado(tabla_TipoPersona.getValueAt(tabla_TipoPersona.getSelectedRow(), 0).toString(),
                                txtNombreTipoEmpleado, txtDescripcionTipoEmpleado, cbxArea, txtRemuneracion);
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Datos modificados");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No se pudo modificar los datos del tipo de empleado. Intente nuevamente");
        }
    }//GEN-LAST:event_btnEditarTipoEmpleadoActionPerformed

    private void btnEliminarTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTipoEmpleadoActionPerformed
        try {
            if (tabla_TipoPersona.getSelectedRowCount() <= 0) {
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de empleado de la lista para eliminar");
            } else {
                if (JOptionPane.showConfirmDialog(rootPane, "¿Eliminar tipo de empleado?", "Confirmar cambios", JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION) {
                    if (!tipoEmpleado.existenRegistrosReferenciadosTipoEmp(Integer.parseInt(tabla_TipoPersona.getValueAt(tabla_TipoPersona.getSelectedRow(), 0).toString()))) {
                        tipoEmpleado.eliminarTipoEmpleado(tabla_TipoPersona.getValueAt(tabla_TipoPersona.getSelectedRow(), 0).toString());
                        limpiar();
                        JOptionPane.showMessageDialog(null, "Tipo de empleado eliminado");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No se puede eliminar. Este tipo de empleado ya se encuentra referenciado en "
                                + "otras tablas");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No se puedo eliminar el tipo de empleado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarTipoEmpleadoActionPerformed

    private void btnLimpiarTipoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTipoEmpleadoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarTipoEmpleadoActionPerformed

    private void txtDescripcionTipoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionTipoEmpleadoKeyTyped
        if (txtDescripcionTipoEmpleado.getText().length() >= 300) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionTipoEmpleadoKeyTyped

    private void txtRemuneracionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemuneracionKeyTyped
        if (txtRemuneracion.getText().length() >= 5) {
            evt.consume();
        }

        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtRemuneracionKeyTyped

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtBuscarPorTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorTipoKeyReleased
        try {
            tipoEmpleado.filtrarTipoEmpleado(tabla_TipoPersona, txtBuscarPorTipo);
        } catch (Exception ex) {
            Logger.getLogger(jdMantenimientoTipoEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtBuscarPorTipoKeyReleased

    private void tabla_TipoPersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_TipoPersonaKeyReleased
        int seleccionFila = tabla_TipoPersona.getSelectedRow();
        if (seleccionFila > -1) {
            Object nombre = tabla_TipoPersona.getValueAt(seleccionFila, 1);
            Object descri = tabla_TipoPersona.getValueAt(seleccionFila, 2);
            Object area = tabla_TipoPersona.getValueAt(seleccionFila, 3);
            Object remu = tabla_TipoPersona.getValueAt(seleccionFila, 4);
            txtNombreTipoEmpleado.setText(nombre.toString());
            txtDescripcionTipoEmpleado.setText(descri.toString());
            cbxArea.setSelectedItem(area.toString());

            int puntoIndex = remu.toString().indexOf('.');
            txtRemuneracion.setText(remu.toString().substring(0, puntoIndex));
        }
    }//GEN-LAST:event_tabla_TipoPersonaKeyReleased

    private void limpiar() {
        try {
            tipoEmpleado.listarTablaTipoEmpleado(tabla_TipoPersona);
            txtNombreTipoEmpleado.setText("");
            txtDescripcionTipoEmpleado.setText("");
            txtRemuneracion.setText("");
            cbxArea.setSelectedIndex(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo limpiar los campos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnAgregarTipoEmpleado;
    private swing.Btn_Round_JWC btnCerrar;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEditarTipoEmpleado;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnEliminarTipoEmpleado;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnLimpiarTipoEmpleado;
    private javax.swing.JComboBox<String> cbxArea;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC1;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC2;
    private panel_degradado_jwc.Panel_Round_Degradado_JWC panel_Round_Degradado_JWC3;
    private swing.Panel_Round_JWC panel_Round_JWC1;
    private swing.Panel_Round_JWC panel_Round_JWC2;
    private javax.swing.JTable tabla_TipoPersona;
    private javax.swing.JTextField txtBuscarPorTipo;
    private javax.swing.JTextArea txtDescripcionTipoEmpleado;
    private javax.swing.JTextField txtNombreTipoEmpleado;
    private javax.swing.JTextField txtRemuneracion;
    // End of variables declaration//GEN-END:variables
}
