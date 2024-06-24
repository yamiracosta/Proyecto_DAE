/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Negocio.*;
import java.awt.Frame;
import java.sql.*;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 *
 * @author jefer
 */
public class jdVentanaCalcularRetencionesPorLey extends javax.swing.JDialog {

    JDialog jdRC = new JDialog();

    public void setJdRC(JDialog jdRC) {
        this.jdRC = jdRC;
    }

    String tipoemp = "";
    String tipocontrato = "";
    String periodo = "";

    public void setTipoEmp(String tipoEmp) {
        this.tipoemp = tipoEmp;
    }

    public void setTipoContrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    //Datos que pasarán al resumen de contrato:
    String sueldoneto, fondopensiones, montoFondoPension;
    String montoSeguroSalud; //esto servirá para decidir si asignar o no un seguro de salud al contrato

    public void setSueldoneto(String sueldoneto) {
        this.sueldoneto = sueldoneto;
    }

    public void setFondopensiones(String fondopensiones) {
        this.fondopensiones = fondopensiones;
    }

    public void setMontoFondoPension(String montoFondoPension) {
        this.montoFondoPension = montoFondoPension;
    }

    public void setMontoSeguroSalud(String montoSeguroSalud) {
        this.montoSeguroSalud = montoSeguroSalud;
    }

    Contrato objCont = new Contrato();
    Deduccion objDed = new Deduccion();
    Empleado objEmp = new Empleado();

    public jdVentanaCalcularRetencionesPorLey(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(obtenerImagen());
        setTitle("Detalles de pago");
        setLocationRelativeTo(this);
    }

    private void cargarComboFondoPension() throws Exception {
        cboFondoPension.removeAllItems();
        ResultSet rs = objDed.cargarFondosDePensiones();
        while (rs.next()) {
            cboFondoPension.addItem(rs.getString("nombre"));
        }
    }

    private void calcularMontoTotalRetenciones() {
        if (lblMontoRetencionFondoPension != null || lblMontoRetencionSeguroSalud != null) {
            double montofondo = Double.parseDouble(lblMontoRetencionFondoPension.getText());
            double montoseguro = Double.parseDouble(lblMontoRetencionSeguroSalud.getText());
            double calculado = montofondo + montoseguro;
            lblMontoTotalRetenciones.setText(String.format("%.2f", calculado));
        }
    }

    private void calcularMontoRetencionFondoPension() {
        double sueldo = Double.parseDouble(txtSueldoBruto.getText());
        float porc = Float.parseFloat(lblTotalRetencionFondoPension.getText().substring(0, lblTotalRetencionFondoPension.getText().length() - 2)) / 100;
        double calculado = sueldo * porc;
        lblMontoRetencionFondoPension.setText(String.format("%.2f", calculado));
    }

    private void obtenerSueldoCorrespondiente() throws Exception {
        String tipoEmp = this.tipoemp;
        double sueldo = objEmp.obtenerSalarioTipoEmpleado(tipoEmp);
        String tipoc = this.tipocontrato;
        String per = this.periodo;
        if (tipoc.equals("Tiempo parcial")) {
            sueldo = sueldo / 2;
        }
        if (per.equals("Quincenal")) {
            sueldo = sueldo / 2;
        }
        txtSueldoBruto.setText(String.format("%.2f", sueldo));
    }

    private void calcularDetallesAporteFondoPension() throws Exception {
        String fondo = cboFondoPension.getSelectedItem().toString();
        if (fondo.equals("AFP")) {
            lblAporteObligatorio.setText("10 %");
            lblPrima.setText("1.74 %");
            lblComision.setText("1.6 %");
        } else if (fondo.equals("ONP")) {
            lblAporteObligatorio.setText("13 %");
            lblPrima.setText("0.00 %");
            lblComision.setText("0.00 %");
        }
    }

    private void calcularPorcentajeTotalRetencionFondoPension() {
        String aporteobligatorio = lblAporteObligatorio.getText().substring(0, lblAporteObligatorio.getText().length() - 2);
        String prima = lblPrima.getText().substring(0, lblPrima.getText().length() - 2);
        String comision = lblComision.getText().substring(0, lblComision.getText().length() - 2);
        double suma = Float.parseFloat(aporteobligatorio) + Float.parseFloat(prima) + Float.parseFloat(comision);
        lblTotalRetencionFondoPension.setText(String.format("%.2f", suma) + " %");
    }

    private void validarCheckBox() {
        if (ckbSi.isSelected()) {
            ckbSi.setText("Sí");
        } else {
            ckbSi.setText("No");
        }
    }

    private void calcularMontoRetencionSeguroSalud() {
        if (!ckbSi.isSelected()) {
            lblMontoRetencionSeguroSalud.setText("0.00");
        } else if (ckbSi.isSelected()) {
            float porc = (float) 0.09;
            double remuneracion = Float.parseFloat(txtSueldoBruto.getText());
            double calculado = remuneracion * porc;
            lblMontoRetencionSeguroSalud.setText(String.format("%.2f", calculado));
        }
    }

    private void calcularSueldoNeto() {
        double montoRet = Double.parseDouble(lblMontoTotalRetenciones.getText());
        double sueldo = Double.parseDouble(txtSueldoBruto.getText());
        double calculado = sueldo - montoRet;
        lblSueldoNeto.setText(String.format("%.2f", calculado));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSueldoBruto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ckbSi = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboFondoPension = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblAporteObligatorio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblPrima = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblComision = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalRetencionFondoPension = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMontoRetencionFondoPension = new javax.swing.JLabel();
        lblMontoRetencionSeguroSalud = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblMontoTotalRetenciones = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblSueldoNeto = new javax.swing.JLabel();
        btnGuardarCambios = new btn_efecto01_jwc.btn_efecto_V1_JWC();
        btnVolver1 = new btn_efecto01_jwc.btn_efecto_V1_JWC();

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("RETENCIONES POR LEY");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sueldo bruto (S/.) :");

        txtSueldoBruto.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        txtSueldoBruto.setText("0.00");
        txtSueldoBruto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSueldoBrutoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoBrutoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seguro de salud (9 %):");

        ckbSi.setBackground(new java.awt.Color(51, 51, 51));
        ckbSi.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        ckbSi.setForeground(new java.awt.Color(255, 255, 255));
        ckbSi.setSelected(true);
        ckbSi.setText("Sí");
        ckbSi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ckbSiItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fondo de pensiones:");

        cboFondoPension.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        cboFondoPension.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboFondoPensionItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Aporte obligatorio:");

        lblAporteObligatorio.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Prima de seguro:");

        lblPrima.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Comisión:");

        lblComision.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total retención:");

        lblTotalRetencionFondoPension.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalRetencionFondoPension.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblTotalRetencionFondoPensionPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboFondoPension, 0, 99, Short.MAX_VALUE)
                            .addComponent(lblAporteObligatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(lblTotalRetencionFondoPension, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFondoPension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblAporteObligatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblComision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalRetencionFondoPension, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ckbSi)
                            .addComponent(txtSueldoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSueldoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbSi))
                .addGap(24, 24, 24))
        );

        jPanel3.setBackground(new java.awt.Color(69, 161, 137));

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Monto por retención de seguro de salud:");

        jLabel9.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Monto por retención de fondo de pensiones:");

        lblMontoRetencionFondoPension.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        lblMontoRetencionFondoPension.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoRetencionFondoPension.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoRetencionFondoPension.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblMontoRetencionFondoPensionPropertyChange(evt);
            }
        });

        lblMontoRetencionSeguroSalud.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        lblMontoRetencionSeguroSalud.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoRetencionSeguroSalud.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoRetencionSeguroSalud.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblMontoRetencionSeguroSaludPropertyChange(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Monto total de retenciones:");

        lblMontoTotalRetenciones.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        lblMontoTotalRetenciones.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoTotalRetenciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sueldo neto (S/.) :");

        lblSueldoNeto.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        lblSueldoNeto.setForeground(new java.awt.Color(255, 255, 255));
        lblSueldoNeto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnGuardarCambios.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/btn_guardar.png"))); // NOI18N
        btnGuardarCambios.setText("Guardar cambios y ver resumen");
        btnGuardarCambios.setBackground_Hover_1(new java.awt.Color(255, 204, 0));
        btnGuardarCambios.setBackground_Hover_2(new java.awt.Color(255, 204, 0));
        btnGuardarCambios.setBackground_No_Hover_1(new java.awt.Color(255, 204, 0));
        btnGuardarCambios.setBackground_No_Hover_2(new java.awt.Color(255, 204, 0));
        btnGuardarCambios.setColor_Hover_text(new java.awt.Color(0, 0, 0));
        btnGuardarCambios.setColor_NoHover_text(new java.awt.Color(0, 0, 0));
        btnGuardarCambios.setEsquina_inferior_derecho(20);
        btnGuardarCambios.setEsquina_inferior_izquierdo(20);
        btnGuardarCambios.setEsquina_superior_derecho(20);
        btnGuardarCambios.setEsquina_superior_izquierdo(20);
        btnGuardarCambios.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        btnGuardarCambios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardarCambios.setIconTextGap(8);
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoTotalRetenciones, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoRetencionSeguroSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMontoRetencionFondoPension, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMontoRetencionFondoPension, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMontoRetencionSeguroSalud, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMontoTotalRetenciones, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lblSueldoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void cboFondoPensionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboFondoPensionItemStateChanged
        try {
            calcularDetallesAporteFondoPension();
            calcularPorcentajeTotalRetencionFondoPension();
            calcularMontoRetencionFondoPension();
            calcularMontoTotalRetenciones();
            calcularSueldoNeto();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_cboFondoPensionItemStateChanged

    private void ckbSiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ckbSiItemStateChanged
        validarCheckBox();
        calcularMontoRetencionSeguroSalud();
        calcularMontoTotalRetenciones();
        calcularSueldoNeto();
    }//GEN-LAST:event_ckbSiItemStateChanged

    private void txtSueldoBrutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoBrutoKeyReleased
        if (txtSueldoBruto.getText().isBlank()) {
            txtSueldoBruto.setText("0");
        }

        calcularMontoRetencionFondoPension();
    }//GEN-LAST:event_txtSueldoBrutoKeyReleased

    private void txtSueldoBrutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoBrutoKeyTyped
        if (txtSueldoBruto.getText().length() >= 8) {
            evt.consume();
        }

        calcularMontoRetencionFondoPension();
        calcularMontoTotalRetenciones();
        calcularSueldoNeto();
    }//GEN-LAST:event_txtSueldoBrutoKeyTyped

    private void lblTotalRetencionFondoPensionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblTotalRetencionFondoPensionPropertyChange

    }//GEN-LAST:event_lblTotalRetencionFondoPensionPropertyChange

    private void lblMontoRetencionFondoPensionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblMontoRetencionFondoPensionPropertyChange

    }//GEN-LAST:event_lblMontoRetencionFondoPensionPropertyChange

    private void lblMontoRetencionSeguroSaludPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblMontoRetencionSeguroSaludPropertyChange

    }//GEN-LAST:event_lblMontoRetencionSeguroSaludPropertyChange

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        guardarCambiosVerResumen();
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            cargarComboFondoPension();
            obtenerSueldoCorrespondiente();
            calcularPorcentajeTotalRetencionFondoPension();
            calcularMontoRetencionSeguroSalud();
            calcularMontoRetencionFondoPension();
            calcularMontoTotalRetenciones();
            calcularSueldoNeto();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_formWindowActivated

    private void guardarCambiosVerResumen() {
        SimpleDateFormat formato = new SimpleDateFormat("dd MMM yyy");

        jdVentanaResumenContrato objRes = new jdVentanaResumenContrato((Frame) SwingUtilities.getWindowAncestor(this), true);
        objRes.setJdRPL(this);
        //Trabajador
        objRes.setApepat(this.apepatRSMN);
        objRes.setApemat(this.apematRSMN);
        objRes.setNombres(this.nombresRSMN);
        objRes.setNumdoc(this.numdocRSMN);
        objRes.setTipdoc(this.tipdocRSMN);
        objRes.setTipoemp(this.tipoempRSMN);
        objRes.setArea(this.areaRSMN);

        //Contrato
        objRes.setTipocont(this.tipocontRSMN);

        try {
            Date fechainicio = formato.parse(this.fechainicioRSMN);
            objRes.setFechainicio(formato.format(fechainicio));
            Date fechaFin = formato.parse(this.fechaterminoRSMN);
            objRes.setFechatermino(formato.format(fechaFin));
        } catch (ParseException ex) {
        }

        objRes.setPeriodopago(this.periodopagoRSMN);
        objRes.setTurno(this.turnoRSMN);
        objRes.setHorariotrabajo(this.horariotrabajoRSMN);
        objRes.setDerechovacas(this.derechovacasRSMN);
        objRes.setResponsabilidades(this.responsabilidadesRSMN);

        //Detalles de pago
        objRes.setSueldoneto(lblSueldoNeto.getText());
        objRes.setMontofondopensiones(lblMontoRetencionFondoPension.getText());
        objRes.setMontosegurosalud(lblMontoRetencionSeguroSalud.getText());
        objRes.setFondopensiones(cboFondoPension.getSelectedItem().toString());
        objRes.setLocationRelativeTo(this);
        objRes.setVisible(true);
    }

    //Datos de trabajador
    String apepatRSMN;
    String apematRSMN;
    String nombresRSMN;
    String numdocRSMN;
    String tipdocRSMN;
    String tipoempRSMN;
    String areaRSMN;

    public void setApepatRSMN(String apepatRSMN) {
        this.apepatRSMN = apepatRSMN;
    }

    public void setApematRSMN(String apematRSMN) {
        this.apematRSMN = apematRSMN;
    }

    public void setNombresRSMN(String nombresRSMN) {
        this.nombresRSMN = nombresRSMN;
    }

    public void setNumdocRSMN(String numdocRSMN) {
        this.numdocRSMN = numdocRSMN;
    }

    public void setTipdocRSMN(String tipdocRSMN) {
        this.tipdocRSMN = tipdocRSMN;
    }

    public void setTipoempRSMN(String tipoempRSMN) {
        this.tipoempRSMN = tipoempRSMN;
    }

    public void setAreaRSMN(String areaRSMN) {
        this.areaRSMN = areaRSMN;
    }

    //Datos de contrato
    String tipocontRSMN;
    String fechainicioRSMN;
    String fechaterminoRSMN;
    String periodopagoRSMN;
    String turnoRSMN;
    String horariotrabajoRSMN;
    String derechovacasRSMN;
    String responsabilidadesRSMN;

    public void setTipocontRSMN(String tipocontRSMN) {
        this.tipocontRSMN = tipocontRSMN;
    }

    public void setFechainicioRSMN(String fechainicioRSMN) {
        this.fechainicioRSMN = fechainicioRSMN;
    }

    public void setFechaterminoRSMN(String fechaterminoRSMN) {
        this.fechaterminoRSMN = fechaterminoRSMN;
    }

    public void setPeriodopagoRSMN(String periodopagoRSMN) {
        this.periodopagoRSMN = periodopagoRSMN;
    }

    public void setTurnoRSMN(String turnoRSMN) {
        this.turnoRSMN = turnoRSMN;
    }

    public void setHorariotrabajoRSMN(String horariotrabajoRSMN) {
        this.horariotrabajoRSMN = horariotrabajoRSMN;
    }

    public void setDerechovacasRSMN(String derechovacasRSMN) {
        this.derechovacasRSMN = derechovacasRSMN;
    }

    public void setResponsabilidadesRSMN(String responsabilidadesRSMN) {
        this.responsabilidadesRSMN = responsabilidadesRSMN;
    }

    public static Image obtenerImagen() {
        Image icono = null;
        try {
            icono = new ImageIcon(jdVentanaCalcularRetencionesPorLey.class.getResource("/Recursos/btn_calcular_sueldo.png")).getImage();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: " + e.getMessage());
        }
        return icono;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnGuardarCambios;
    private btn_efecto01_jwc.btn_efecto_V1_JWC btnVolver1;
    private javax.swing.JComboBox<String> cboFondoPension;
    private javax.swing.JCheckBox ckbSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAporteObligatorio;
    private javax.swing.JLabel lblComision;
    private javax.swing.JLabel lblMontoRetencionFondoPension;
    private javax.swing.JLabel lblMontoRetencionSeguroSalud;
    private javax.swing.JLabel lblMontoTotalRetenciones;
    private javax.swing.JLabel lblPrima;
    private javax.swing.JLabel lblSueldoNeto;
    private javax.swing.JLabel lblTotalRetencionFondoPension;
    private javax.swing.JTextField txtSueldoBruto;
    // End of variables declaration//GEN-END:variables
}
