/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.Beneficio;
import java.sql.ResultSet;
import Negocio.BoletaPago;
import Negocio.Contrato;
import Negocio.Descuento;
import Negocio.Empleado;
import Negocio.PeriodoPago;
import java.awt.Frame;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class jdVentanaPagosPendientes extends javax.swing.JDialog {

    Empleado objE = new Empleado();

    private JDialog jdac;

    public void setDialogoAnularContrato(JDialog jdAnularContrato) {
        this.jdac = jdAnularContrato;
    }

    String periodo;
    String numdoc;
    String tipodoc;

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    private int codigocontrato; //recibe correctamente

    public void setCodigocontrato(int codigocontrato) {
        this.codigocontrato = codigocontrato;
    }

    public jdVentanaPagosPendientes(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver1 = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        btnRealizarPago = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jLabel2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblRecurrenciaPago = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBeneficios = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDescuentos = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblSueldoPorPagar = new javax.swing.JLabel();
        lblMontoToTalBeneficios = new javax.swing.JLabel();
        lblMontoTotalDescuentos = new javax.swing.JLabel();
        lblMontoTotalPagar = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblMontoDiasTrabajados = new javax.swing.JLabel();
        pnlAnularContrato = new javax.swing.JPanel();
        btnAnularContrato = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        jLabel26 = new javax.swing.JLabel();
        cboMotivoAnulacion = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMotivoAnulacion = new javax.swing.JTextArea();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ANULACION DE CONTRATO");

        btnVolver1.setBackground(new java.awt.Color(255, 255, 255));
        btnVolver1.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/boton-x.png"))); // NOI18N
        btnVolver1.setText("");
        btnVolver1.setBackground_Hover_1(new java.awt.Color(255, 51, 51));
        btnVolver1.setBackground_Hover_2(new java.awt.Color(204, 0, 0));
        btnVolver1.setBackground_No_Hover_1(new java.awt.Color(255, 51, 51));
        btnVolver1.setBackground_No_Hover_2(new java.awt.Color(204, 0, 0));
        btnVolver1.setEsquina_inferior_derecho(20);
        btnVolver1.setEsquina_inferior_izquierdo(20);
        btnVolver1.setEsquina_superior_derecho(20);
        btnVolver1.setEsquina_superior_izquierdo(20);
        btnVolver1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnVolver1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVolver1.setIconTextGap(8);
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(86, 201, 170));

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Lista de pagos pendientes:");

        tblPagos.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPagos.setGridColor(new java.awt.Color(0, 0, 0));
        tblPagos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblPagos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPagosMouseClicked(evt);
            }
        });
        tblPagos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblPagosPropertyChange(evt);
            }
        });
        tblPagos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPagosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblPagos);

        btnRealizarPago.setBackground(new java.awt.Color(255, 204, 0));
        btnRealizarPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/btn_realizar_pago.png"))); // NOI18N
        btnRealizarPago.setText("Realizar pago");
        btnRealizarPago.setBackground_Hover_1(new java.awt.Color(255, 204, 0));
        btnRealizarPago.setBackground_Hover_2(new java.awt.Color(255, 204, 0));
        btnRealizarPago.setBackground_No_Hover_1(new java.awt.Color(255, 204, 0));
        btnRealizarPago.setBackground_No_Hover_2(new java.awt.Color(255, 204, 0));
        btnRealizarPago.setColor_Hover_text(new java.awt.Color(0, 0, 0));
        btnRealizarPago.setColor_NoHover_text(new java.awt.Color(0, 0, 0));
        btnRealizarPago.setEsquina_inferior_derecho(20);
        btnRealizarPago.setEsquina_inferior_izquierdo(20);
        btnRealizarPago.setEsquina_superior_derecho(20);
        btnRealizarPago.setEsquina_superior_izquierdo(20);
        btnRealizarPago.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        btnRealizarPago.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRealizarPago.setIconTextGap(8);
        btnRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPagoActionPerformed(evt);
            }
        });
        btnRealizarPago.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                btnRealizarPagoPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Importante: Si tiene pagos pendientes, realiza el pago para continuar con la culminación del contrato.");

        jLabel27.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Recurrencia de pago:");

        lblRecurrenciaPago.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRecurrenciaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel27)
                    .addComponent(lblRecurrenciaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        tblBeneficios.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblBeneficios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblBeneficios.setGridColor(new java.awt.Color(0, 0, 0));
        tblBeneficios.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblBeneficios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tblBeneficios);

        jLabel19.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Beneficios de ley:");

        jLabel20.setFont(new java.awt.Font("Nirmala UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Descuentos:");

        tblDescuentos.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        tblDescuentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblDescuentos.setGridColor(new java.awt.Color(0, 0, 0));
        tblDescuentos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblDescuentos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tblDescuentos);

        jLabel21.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Sueldo por pagar:");

        jLabel22.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Monto total de beneficios:");

        jLabel23.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Monto total de descuentos:");

        jLabel24.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Monto total a pagar:");

        lblSueldoPorPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblSueldoPorPagar.setText("S/.");

        lblMontoToTalBeneficios.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoToTalBeneficios.setText("S/.");

        lblMontoTotalDescuentos.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoTotalDescuentos.setText("S/.");

        lblMontoTotalPagar.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoTotalPagar.setText("S/.");

        jLabel25.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Monto por días trabajados:");

        lblMontoDiasTrabajados.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoDiasTrabajados.setText("S/.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel24))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblSueldoPorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMontoTotalDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMontoToTalBeneficios, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMontoTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMontoDiasTrabajados, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel20))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(lblSueldoPorPagar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(lblMontoToTalBeneficios))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(lblMontoTotalDescuentos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(lblMontoDiasTrabajados))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(lblMontoTotalPagar)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnAnularContrato.setBackground(new java.awt.Color(255, 255, 255));
        btnAnularContrato.setForeground(new java.awt.Color(255, 255, 255));
        btnAnularContrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/btn_anular_contrato.png"))); // NOI18N
        btnAnularContrato.setText("Anular contrato");
        btnAnularContrato.setBackground_Hover_1(new java.awt.Color(255, 51, 51));
        btnAnularContrato.setBackground_Hover_2(new java.awt.Color(255, 51, 51));
        btnAnularContrato.setBackground_No_Hover_1(new java.awt.Color(255, 51, 51));
        btnAnularContrato.setBackground_No_Hover_2(new java.awt.Color(255, 51, 51));
        btnAnularContrato.setEsquina_inferior_derecho(20);
        btnAnularContrato.setEsquina_inferior_izquierdo(20);
        btnAnularContrato.setEsquina_superior_derecho(20);
        btnAnularContrato.setEsquina_superior_izquierdo(20);
        btnAnularContrato.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        btnAnularContrato.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAnularContrato.setIconTextGap(8);
        btnAnularContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularContratoActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Motivo de término:");

        cboMotivoAnulacion.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        cboMotivoAnulacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contrato caducado", "Despido", "Renuncia", "Otro (especificar)" }));
        cboMotivoAnulacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMotivoAnulacionItemStateChanged(evt);
            }
        });

        txtMotivoAnulacion.setColumns(20);
        txtMotivoAnulacion.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtMotivoAnulacion.setRows(5);
        txtMotivoAnulacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMotivoAnulacionKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtMotivoAnulacion);

        javax.swing.GroupLayout pnlAnularContratoLayout = new javax.swing.GroupLayout(pnlAnularContrato);
        pnlAnularContrato.setLayout(pnlAnularContratoLayout);
        pnlAnularContratoLayout.setHorizontalGroup(
            pnlAnularContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnularContratoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlAnularContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(cboMotivoAnulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAnularContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        pnlAnularContratoLayout.setVerticalGroup(
            pnlAnularContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAnularContratoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlAnularContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnularContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAnularContratoLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(cboMotivoAnulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAnularContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVolver1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAnularContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            comprobarListaPagos();
            comprobarBtnConfirmarContrato();
        } catch (Exception ex) {
            Logger.getLogger(jdVentanaPagosPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void comprobarListaPagos() throws Exception {
        listarPagosContrato(this.codigocontrato, this.periodo);

        if (tblPagos.getRowCount() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No hay pagos pendientes","En buena hora :)",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void comprobarBtnConfirmarContrato() {
        int numpagospend = tblPagos.getRowCount();
        if (numpagospend <= 0) {
            btnAnularContrato.setEnabled(true);
            cboMotivoAnulacion.setEnabled(true);
        } else {
            btnAnularContrato.setEnabled(false);
            txtMotivoAnulacion.setEnabled(false);
            cboMotivoAnulacion.setEnabled(false);
        }
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setearRecurrenciaPago();
    }//GEN-LAST:event_formWindowActivated

    private void btnRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagoActionPerformed
        BoletaPago obj = new BoletaPago();
        if (tblPagos.getSelectedRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(rootPane, "¿Realizar pago de boleta?", "Confirmación de cambios", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                try {
                    int codboletapago = Integer.parseInt(tblPagos.getValueAt(tblPagos.getSelectedRow(), 0).toString());
                    double montosueldo = Double.parseDouble(lblSueldoPorPagar.getText().replace("S/. ", ""));
                    double montobeneficios = Double.parseDouble(lblMontoToTalBeneficios.getText().replace("S/. ", ""));
                    double montodscts = Double.parseDouble(lblMontoTotalDescuentos.getText().replace("S/. ", ""));
                    double montodiastrbjds = Double.parseDouble(lblMontoDiasTrabajados.getText().replace("S/. ", ""));
                    double montototal = Double.parseDouble(lblMontoTotalPagar.getText().replace("S/. ", ""));
                    obj.cancelarBoletaPago(codboletapago, montosueldo, montobeneficios, montodscts, montodiastrbjds, montototal);
                    JOptionPane.showMessageDialog(rootPane, "Pago realizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    comprobarListaPagos();
                    comprobarBtnConfirmarContrato();
                } catch (Exception ex) {
                    Logger.getLogger(jdVentanaPagosPendientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un boleta de pago de la lista", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRealizarPagoActionPerformed

    private void btnRealizarPagoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnRealizarPagoPropertyChange

    }//GEN-LAST:event_btnRealizarPagoPropertyChange

    private void tblPagosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblPagosPropertyChange
        if (tblPagos.getSelectedRowCount() > 0) {
            try {
                //Listar detalles de beneficios y descuentos:
                int idboletapago = Integer.parseInt(tblPagos.getValueAt(tblPagos.getSelectedRow(), 0).toString());
                listarBeneficios(idboletapago);
                listarDescuentos(idboletapago);
                //Calcular el total:
                calcularMontoTotal();
                //Habilitar botón
                btnRealizarPago.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(jdVentanaPagosPendientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Listar tablas vacías:
            listarTablasDetallesVacias();
            //Deshabilitar botón de realizar pago
            btnRealizarPago.setEnabled(false);
            lblMontoDiasTrabajados.setText("");
            lblMontoToTalBeneficios.setText("");
            lblMontoTotalDescuentos.setText("");
            lblMontoTotalPagar.setText("");
            lblSueldoPorPagar.setText("");
            btnAnularContrato.setEnabled(true);
            cboMotivoAnulacion.setEnabled(true);
        }
    }//GEN-LAST:event_tblPagosPropertyChange

    private void tblPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPagosMouseClicked
        if (tblPagos.getSelectedRowCount() > 0) {
            try {
                //Listar detalles de beneficios y descuentos:
                int idboletapago = Integer.parseInt(tblPagos.getValueAt(tblPagos.getSelectedRow(), 0).toString());
                listarBeneficios(idboletapago);
                listarDescuentos(idboletapago);
                //Calcular el total:
                calcularMontoTotal();
                //Habilitar botón
                btnRealizarPago.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(jdVentanaPagosPendientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Listar tablas vacías:
            listarTablasDetallesVacias();
            //Deshabilitar botón de realizar pago
            btnRealizarPago.setEnabled(false);
        }
    }//GEN-LAST:event_tblPagosMouseClicked

    private void btnAnularContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularContratoActionPerformed
        try {
            int indicemotivo = cboMotivoAnulacion.getSelectedIndex();
            if (indicemotivo == 0) {
                if (amerita()) {
                    confirmarAnulacionContrato();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se puede anular el contrato por caducación antes de la fecha de término."
                    ,"Error",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                confirmarAnulacionContrato();
            }
        } catch (Exception ex) {
            Logger.getLogger(jdVentanaPagosPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAnularContratoActionPerformed

    private void confirmarAnulacionContrato() throws Exception {
        int opcion
                = JOptionPane.showConfirmDialog(rootPane, "IMPORTANTE: La anulación de contrato no se puede revertir\n\n¿Desea continuar?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            Contrato obj = new Contrato();
            int opcionCombo = cboMotivoAnulacion.getSelectedIndex();
            String motivo = "";
            motivo = switch (opcionCombo) {
                case 0 ->
                    cboMotivoAnulacion.getItemAt(0);
                case 1 ->
                    cboMotivoAnulacion.getItemAt(1);
                case 2 ->
                    cboMotivoAnulacion.getItemAt(2);
                default ->
                    cboMotivoAnulacion.getItemAt(3).replace(" (especificar)", "") + ": " + txtMotivoAnulacion.getText();
            };
            int ide = objE.obtenerIdEmpleado(this.numdoc, this.tipodoc);
            obj.culminarContrato(cboMotivoAnulacion.getSelectedItem().toString(),motivo, this.codigocontrato, ide);
            JOptionPane.showMessageDialog(rootPane, "El contrato fue anulado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    private void cboMotivoAnulacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMotivoAnulacionItemStateChanged
        try {
            if (cboMotivoAnulacion.getSelectedIndex() == 3) {
                txtMotivoAnulacion.setEnabled(true);
            } else {
                txtMotivoAnulacion.setEnabled(false);
                txtMotivoAnulacion.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(jdVentanaPagosPendientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboMotivoAnulacionItemStateChanged

    private void txtMotivoAnulacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoAnulacionKeyTyped
        if (txtMotivoAnulacion.getText().length() >= 300) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMotivoAnulacionKeyTyped

    private void tblPagosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPagosKeyReleased
        if (tblPagos.getSelectedRowCount() > 0) {
            try {
                //Listar detalles de beneficios y descuentos:
                int idboletapago = Integer.parseInt(tblPagos.getValueAt(tblPagos.getSelectedRow(), 0).toString());
                listarBeneficios(idboletapago);
                listarDescuentos(idboletapago);
                //Calcular el total:
                calcularMontoTotal();
                //Habilitar botón
                btnRealizarPago.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(jdVentanaPagosPendientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Listar tablas vacías:
            listarTablasDetallesVacias();
            //Deshabilitar botón de realizar pago
            btnRealizarPago.setEnabled(false);
        }
    }//GEN-LAST:event_tblPagosKeyReleased

    private void listarPagosContrato(int idc, String per) throws Exception {
        BoletaPago obj = new BoletaPago();
        ResultSet rs = obj.obtenerPagosContrato(idc, per);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Fecha pactada");
        modelo.addColumn("Fecha de pago");
        modelo.addColumn("Estado de pago");
        modelo.addColumn("Monto total registrado (S/.)");

        Object datos[] = new Object[5];

        while (rs.next()) {
            datos[0] = rs.getInt("id");
            datos[1] = rs.getString("fechapactada");
            datos[2] = rs.getString("fechapago");
            datos[3] = rs.getString("estadopago");
            datos[4] = rs.getString("montototal");
            modelo.addRow(datos);
        }
        tblPagos.setModel(modelo);
    }

    private void obtenerSetearSalario(int idc) throws Exception {
        Contrato obj = new Contrato();
        double salario = obj.obtenerSalarioAcordadoContrato(idc);
        String txt = String.format("%.2f", salario);
        lblSueldoPorPagar.setText("S/. " + txt);
    }

    private void listarBeneficios(int idpago) throws Exception {
        Beneficio obj = new Beneficio();
        ResultSet rs = obj.listarBeneficiosBoletaPago(idpago);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Beneficio");
        modelo.addColumn("Monto total (S/.)");

        Object datos[] = new Object[2];

        while (rs.next()) {
            datos[0] = rs.getString("nombre_beneficio");
            datos[1] = String.format("%.2f", rs.getDouble("total_beneficio"));
            modelo.addRow(datos);
        }
        tblBeneficios.setModel(modelo);
    }

    private void listarDescuentos(int idpago) throws Exception {
        Descuento obj = new Descuento();
        ResultSet rs = obj.listarDescuentosBoletaPago(idpago);

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Descuento");
        modelo.addColumn("Monto total (S/.)");

        Object datos[] = new Object[2];

        while (rs.next()) {
            datos[0] = rs.getString("nombre_descuento");
            datos[1] = String.format("%.2f", rs.getDouble("total_descuento"));
            modelo.addRow(datos);
        }
        tblDescuentos.setModel(modelo);
    }

    private void calcularMontoTotal() throws Exception {
        if (diasTrabajados() <= 0) {
            obtenerSetearSalario(this.codigocontrato);
        } else {
            lblSueldoPorPagar.setText("S/. 0.00");
        }

        //Total en la tabla de beneficios:
        double totalBenef = 0;
        for (int i = 0; i < tblBeneficios.getRowCount(); i++) {
            double montoBenef = Float.parseFloat(tblBeneficios.getValueAt(i, 1).toString());
            totalBenef += montoBenef;
        }

        //Total en la tabla descuentos:
        double totalDsct = 0;
        for (int i = 0; i < tblDescuentos.getRowCount(); i++) {
            double montoDsct = Float.parseFloat(tblDescuentos.getValueAt(i, 1).toString());
            totalDsct += montoDsct;
        }

        //Obtenemos el sueldo neto:
        Contrato objC = new Contrato();
        double sueldoneto = objC.obtenerSalarioAcordadoContrato(this.codigocontrato);

        //Calculamos el restante de los días que quedan:
        double mntDiasTrab = (sueldoneto / 30) * diasTrabajados();

        //Calculamos el monto a pagar:
        double montoTotal = (sueldoneto + totalBenef + mntDiasTrab) - totalDsct;

        PeriodoPago obj = new PeriodoPago();
        String periodo = obj.obtenerNombrePeriodoPago(this.codigocontrato);

        if (periodo.equals("Mensual")) {
            if (diasTrabajados() > 0) {
                lblMontoToTalBeneficios.setText("S/. 0.00");
                lblMontoTotalDescuentos.setText("S/. " + String.format("%.2f", totalDsct));
                lblMontoDiasTrabajados.setText("S/. " + String.format("%.2f", mntDiasTrab));
                lblMontoTotalPagar.setText("S/. " + String.format("%.2f", mntDiasTrab - totalDsct));
            } else {
                lblMontoToTalBeneficios.setText("S/. " + String.format("%.2f", totalBenef));
                lblMontoTotalDescuentos.setText("S/. " + String.format("%.2f", totalDsct));
                lblMontoDiasTrabajados.setText("S/. " + String.format("%.2f", mntDiasTrab));
                lblMontoTotalPagar.setText("S/. " + String.format("%.2f", montoTotal));
            }
        } else if (periodo.equals("Quincenal")) {
            if (diasTrabajados() > 14) {
                double newmntdias = ((sueldoneto / 30) * diasTrabajados()) - ((sueldoneto / 30) * (diasTrabajados() - 14));
                lblMontoDiasTrabajados.setText("S/. " + String.format("%.2f", newmntdias));
                lblMontoToTalBeneficios.setText("S/. 0.00");
                lblMontoTotalDescuentos.setText("S/. " + String.format("%.2f", totalDsct));
                lblMontoTotalPagar.setText("S/. " + String.format("%.2f", mntDiasTrab - totalDsct));
            } else {
                lblMontoToTalBeneficios.setText("S/. " + String.format("%.2f", totalBenef));
                lblMontoTotalDescuentos.setText("S/. " + String.format("%.2f", totalDsct));
                lblMontoDiasTrabajados.setText("S/. " + String.format("%.2f", mntDiasTrab));
                lblMontoTotalPagar.setText("S/. " + String.format("%.2f", montoTotal));
            }
        }
    }

    private int diasTrabajados() {
        int diferenciaDias = 0;
        String fechaUltimoPago = tblPagos.getValueAt(tblPagos.getSelectedRow(), 1).toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateUltimoPago = LocalDate.parse(fechaUltimoPago, formatter);
        LocalDate dateActual = LocalDate.now();

        if (!dateUltimoPago.isBefore(dateActual)) {
            diferenciaDias = dateUltimoPago.getDayOfMonth() - dateActual.getDayOfMonth();
            return diferenciaDias; //9 días
        } else {
            return diferenciaDias;
        }
    }

    private void listarTablasDetallesVacias() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Beneficio");
        modelo.addColumn("Monto total (S/.)");

        tblBeneficios.setModel(modelo);

        DefaultTableModel modelo1 = new DefaultTableModel();
        modelo1.addColumn("Descuento");
        modelo1.addColumn("Monto total (S/.)");

        tblDescuentos.setModel(modelo1);
    }

    private void setearRecurrenciaPago() {
        if (!this.periodo.isBlank()) {
            lblRecurrenciaPago.setText(periodo);
        }
    }

    private boolean amerita() throws Exception {
        Contrato objC = new Contrato();
        boolean amerita = objC.ameritaCaducarContrato(this.codigocontrato);
        return amerita;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnAnularContrato;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnRealizarPago;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnVolver1;
    private javax.swing.JComboBox<String> cboMotivoAnulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMontoDiasTrabajados;
    private javax.swing.JLabel lblMontoToTalBeneficios;
    private javax.swing.JLabel lblMontoTotalDescuentos;
    private javax.swing.JLabel lblMontoTotalPagar;
    private javax.swing.JLabel lblRecurrenciaPago;
    private javax.swing.JLabel lblSueldoPorPagar;
    private javax.swing.JPanel pnlAnularContrato;
    private javax.swing.JTable tblBeneficios;
    private javax.swing.JTable tblDescuentos;
    private javax.swing.JTable tblPagos;
    private javax.swing.JTextArea txtMotivoAnulacion;
    // End of variables declaration//GEN-END:variables
}
