package Negocio;

import Datos.Conexion;
import java.sql.*;
import javax.swing.JTable;

public class BoletaPago {

    Connection micon = null;
    ResultSet rs = null;
    Conexion objcon = new Conexion();
    String strSQL = "";
    PreparedStatement ps = null;
    
    Beneficio objBnf = new Beneficio();
    Descuento objDsct = new Descuento();

    public ResultSet obtenerPagosContrato(int idcont, String periodo) throws Exception {
        /*
            Método que retorna todos los pagos que corresponden al contrato (los atrasados y el próximo a pagarse)
         */
        strSQL = "select * from listar_ultimos_pagos(?,?);";
        objcon.conexion();
        micon = objcon.getCon();
        try {
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcont);
            ps.setString(2, periodo);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener los pagos --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public void cancelarBoletaPago(int idboletapago, double montosueldo, double montobeneficios, double montodscts, double montodiastrabjds,
            double montototal) throws Exception {
        strSQL = "update boleta_pago "
                + "set sueldopagado=?,"
                + "montototalbeneficios=?,"
                + "montototaldescuentos=?,"
                + "montodiastrabajados=?,"
                + "montototal=?,"
                + "estado=true,"
                + "fechapago=current_date,"
                + "idoperador=? "
                + "where id=?";
        try {
            objcon.conexion();
            micon = objcon.getCon();
            micon.setAutoCommit(false);
            ps = micon.prepareStatement(strSQL);
            ps.setDouble(1, montosueldo);
            ps.setDouble(2, montobeneficios);
            ps.setDouble(3, montodscts);
            ps.setDouble(4, montodiastrabjds);
            ps.setDouble(5, montototal);
            ps.setInt(6, Empleado.ID_USUARIO_LOGGEADO);
            ps.setInt(7, idboletapago);
            ps.executeUpdate();
            micon.commit();
        } catch (SQLException ex) {
            throw new Exception("Error al cancelar boleta de pago --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public ResultSet listarPagosContratoTrabajador(int idcont) throws Exception {
        strSQL = """
                 select bp.id,
                 case
                 when bp.montototal is null then 'No registra'
                 else TO_CHAR(bp.montototal, 'FM99999999999999990.00')
                 end as montototal,
                 bp.fechapactada,
                 coalesce(to_char(bp.fechapago,'dd-mm-YYYY'),'No registra') as fechapago,
                 case
                 when bp.estado = true then 'Pagado'
                 when bp.estado = false then 'Pendiente'
                 end as estadopago
                 from boleta_pago bp
                 where idcontrato=? order by bp.fechapactada asc;
                 """;
        objcon.conexion();
        micon = objcon.getCon();
        try {
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcont);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener la lista de pagos --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public boolean verificarNumMaximoBoletasPago(int codcont) throws Exception {
        strSQL = "select fn_verificar_num_boletas_pago(?) as nummax;";
        objcon.conexion();
        micon = objcon.getCon();
        try {
            boolean excede = true;
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, codcont);
            rs = ps.executeQuery();
            while (rs.next()) {
                excede = rs.getBoolean("nummax");
            }
            return excede;
        } catch (SQLException ex) {
            throw new Exception("Error al verificar el número máximo de boletas de pago permitidas --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public void generarNuevaBoletaPago(int codcont) throws Exception {
        strSQL = "select pa_insert_prox_boleta_pago(?);";
        objcon.conexion();
        micon = objcon.getCon();
        try {
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, codcont);
            ps.execute();
        } catch (SQLException ex) {
            throw new Exception("Error al generar nueva boleta de pago --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public Date obtenerFechaProxPago(int idcont) throws Exception {
        strSQL = "select pa_insert_prox_boleta_pago(?) as fechaproxpago;";
        objcon.conexion();
        micon = objcon.getCon();
        Date fechaproxpago = null;
        try {
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcont);
            rs = ps.executeQuery();
            while (rs.next()) {
                fechaproxpago = rs.getDate("fechaproxpago");
            }
            return fechaproxpago;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener fecha del próximo pago --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public ResultSet obtenerDatosBoletaPagoSeleccionada(int idboletapago) throws Exception {
        strSQL = """
                 select bp.id,
                 case
                 when bp.montototal is null then 'No registra'
                 else TO_CHAR(bp.montototal, 'FM99999999999999990.00')
                 end as montototal,
                 bp.fechapactada,
                 coalesce(to_char(bp.fechapago,'dd-mm-YYYY'),'No registra') as fechapago,
                 case
                 when bp.estado = true then 'Pagado'
                 when bp.estado = false then 'No pagado'
                 end as estadopago
                 from boleta_pago bp
                 where bp.id=?;
                 """;
        objcon.conexion();
        micon = objcon.getCon();
        try {
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idboletapago);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener información de fecha de pago seleccionada --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public boolean correspondeAsignacionFamiliar(int idboletapago) throws Exception {
        strSQL = """
                 select e.tienehijos from empleado e
                 inner join contrato c on c.idempleado=e.id
                 inner join boleta_pago bp on c.id=bp.idcontrato
                 where bp.id=?;
                 """;
        objcon.conexion();
        micon = objcon.getCon();
        try {
            boolean corresponde = false;
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idboletapago);
            rs = ps.executeQuery();
            while (rs.next()) {
                corresponde = rs.getBoolean("tienehijos");
            }
            return corresponde;
        } catch (SQLException ex) {
            throw new Exception("Error al comprobar si corresponde asignación familiar --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public double obtenerMontoGrati(int idboletapago) throws Exception {
        strSQL = "select fn_calcular_monto_grati(?) as montograti";
        objcon.conexion();
        micon = objcon.getCon();
        try {
            double monto = 0;
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idboletapago);
            rs = ps.executeQuery();
            while (rs.next()) {
                monto = rs.getDouble("montograti");
            }
            return monto;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener el monto de la gratificación --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public double obtenerMontoCTS(int idcont, int idboletapago) throws Exception {
        strSQL = "select fn_calcular_monto_CTS(?,?); as montocts";
        objcon.conexion();
        micon = objcon.getCon();
        try {
            double monto = 0;
            ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcont);
            ps.setInt(2, idboletapago);
            rs = ps.executeQuery();
            while (rs.next()) {
                monto = rs.getDouble("montocts");
            }
            return monto;
        } catch (SQLException ex) {
            throw new Exception("Error al obtener el monto de la CTS --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }

    public void registrarPagoBoleta(JTable tblDetalleBenef, JTable tblDetalleDscto, double sueldoPagado, double montoTotBenef,
            double montoTotalDscts, double montoTotalPagar, int idboletapago) throws Exception {
        try {
            objcon.conexion();
            micon = objcon.getCon();
            micon.setAutoCommit(false);
            
            //Insertar en BOLETA_PAGO:
            strSQL = "update boleta_pago set fechapago=current_date, estado=true, sueldopagado=?, montototalbeneficios=?, "
                    + "montototaldescuentos=?, montodiastrabajados=0.00, montototal=?, idoperador=? where id=?";
            ps = micon.prepareStatement(strSQL);
            ps.setDouble(1, sueldoPagado);
            ps.setDouble(2, montoTotBenef);
            ps.setDouble(3, montoTotalDscts);
            ps.setDouble(4, montoTotalPagar);
            ps.setInt(5, Empleado.ID_USUARIO_LOGGEADO);
            ps.setInt(6, idboletapago);
            ps.executeUpdate();
            
            //Insertar en DETALLE_BENEFICIO:
            String strSQL2 = "insert into detalle_beneficio(idbeneficio,idpago,monto) values(?,?,?);";
            PreparedStatement ps2 = micon.prepareStatement(strSQL2);
            for (int i = 0; i < tblDetalleBenef.getRowCount(); i++) {
                int idbenef = objBnf.obtenerIdBeneficio(tblDetalleBenef.getValueAt(i, 0).toString());
                double montobenef = Double.parseDouble(tblDetalleBenef.getValueAt(i, 1).toString().replace("S/. ", ""));
                ps2.setInt(1, idbenef);
                ps2.setInt(2, idboletapago);
                ps2.setDouble(3, montobenef);
                ps2.executeUpdate();
            }
            
            //Insertar en DETALLE_DESCUENTO:
            String strSQL3 = "insert into detalle_descuento(iddescuento,idpago,monto,descripcion) values(?,?,?,?);";
            PreparedStatement ps3 = micon.prepareStatement(strSQL3);
            for (int i = 0; i < tblDetalleDscto.getRowCount(); i++) {
                if (!tblDetalleDscto.getValueAt(i, 0).toString().equals("Servicio o beneficio adicional")) {
                    int iddesc = objDsct.obtenerIdDescuento(tblDetalleDscto.getValueAt(i, 0).toString());
                    double montoDscto = Double.parseDouble(tblDetalleDscto.getValueAt(i, 1).toString().replace("S/. ", ""));
                    ps3.setInt(1, iddesc);
                    ps3.setInt(2, idboletapago);
                    ps3.setDouble(3, montoDscto);
                    ps3.setNull(4, Types.NULL);
                    ps3.executeUpdate();
                }
            }
            
            //Si todo fue bien:
            micon.commit();
        } catch (SQLException ex) {
            micon.rollback();
            throw new Exception("Error al registrar pago de boleta --> " + ex.getMessage());
        } finally {
            objcon.desconexion();
        }
    }
}
