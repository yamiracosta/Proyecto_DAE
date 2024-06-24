package Negocio;

import Datos.Conexion;
import java.sql.*;

public class Contrato {

    Conexion obj = new Conexion();
    String strSQL;
    ResultSet rs;
    Deduccion objD = new Deduccion();

    public int generarNumContrato(int idempleado) throws Exception {
        try {
            int idcontrato = -1;
            strSQL = "select coalesce(max(id)+1,1) as numcontrato from contrato;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                idcontrato = rs.getInt("numcontrato");
            }
            return idcontrato;
        } catch (Exception ex) {
            throw new Exception("Error al generar el número de contrato --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void registrarContratoBD(int idcontrato, Date fechainicio, Date fechatermino, int idtipocontrato, double salarioAcordado,
            String responsabilidades, String estado, int idempleado, int idperiodopago, boolean vacacionespagadas, int idhorariotrabajo,
            int idoperador, double salarioBruto) throws Exception {
        strSQL = "INSERT INTO public.contrato(id, fechainicio, fechatermino, idtipocontrato, salarioacordado, responsabilidades, estado,"
                + "idempleado, idperiodopago, fecharegistro, vacacionespagadas, idhorariotrabajo,idoperador,salariobruto) "
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, current_date, ?, ?, ?, ?);";
        try {
            obj.conexion();
            Connection micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcontrato);
            ps.setDate(2, fechainicio);
            ps.setDate(3, fechatermino);
            ps.setInt(4, idtipocontrato);
            ps.setDouble(5, salarioAcordado);
            if (responsabilidades.isBlank()) {
                ps.setNull(6, Types.VARCHAR);
            } else {
                ps.setString(6, responsabilidades);
            }
            ps.setString(7, estado);
            ps.setInt(8, idempleado);
            ps.setInt(9, idperiodopago);
            ps.setBoolean(10, vacacionespagadas);
            ps.setInt(11, idhorariotrabajo);
            ps.setInt(12, idoperador);
            ps.setDouble(13, salarioBruto);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al insertar en contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public ResultSet obtenerDatosContratoTrabajador(String numdoc, int idtipodoc) throws Exception {
        strSQL = "select c.id as codigocontrato, "
                + "tc.nombre as tipocontrato, "
                + "c.fechainicio, "
                + "c.fechatermino, "
                + "pp.nombre as periodopago, "
                + "ht.turno, "
                + "concat( "
                + "to_char(ht.horaentrada,'HH12:MI AM') "
                + "|| ' - ' || "
                + "to_char(ht.horasalida,'HH12:MI AM')) "
                + "as horario_trabajo, "
                + "case "
                + "when c.vacacionespagadas = true then 'Sí' "
                + "when c.vacacionespagadas = false then 'No' "
                + "end as derechovacas, "
                + "coalesce(c.responsabilidades,'No especificadas') as responsabilidades, "
                + "c.salarioacordado "
                + "from contrato c "
                + "inner join periodo_pago pp on c.idperiodopago=pp.id "
                + "inner join tipo_contrato tc on tc.id=c.idtipocontrato "
                + "inner join horario_trabajo ht on ht.id=c.idhorariotrabajo "
                + "inner join empleado e on e.id=c.idempleado "
                + "where e.numdocumento=? and e.idtipodocumento=? and c.estado='V';"; //idtipodoc se tiene que calcular aparte
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setString(1, numdoc);
            ps.setInt(2, idtipodoc);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new Exception("Error al obtener datos de contrato del empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public double obtenerSalarioAcordadoContrato(int idc) throws Exception {
        double salario = -1;
        strSQL = "select c.salarioacordado from contrato c where c.id=?;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idc);
            rs = ps.executeQuery();
            while (rs.next()) {
                salario = rs.getDouble("salarioacordado");
            }
            return salario;
        } catch (SQLException e) {
            throw new Exception("Error al obtener salario acordado del contrato del trabajador --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void culminarContrato(String estado, String motivotermino, int idcont, int idempl) throws Exception {
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        micon.setAutoCommit(false);
        try {
            int cont = idcont;
            int empl = idempl;
            String motivo = motivotermino;

            if (estado.equals("Contrato caducado")) {
                strSQL = "update contrato set estado = 'T', motivotermino=? where id=?";
            } else {
                strSQL = "update contrato set estado = 'A', motivotermino=? where id=?";
            }
            String strSQL2 = "delete from boleta_pago where estado=false and idcontrato=?";
            String strSQL3 = "update empleado set estado='N' where id=?";
            String strSQL4 = "delete from asistencia where idempleado=?";

            //Actualizar contrato a 'A':
            PreparedStatement ps3 = micon.prepareStatement(strSQL);
            ps3.setString(1, motivo);
            ps3.setInt(2, cont);
            ps3.executeUpdate();

            //Actualizar estado del empleado a 'N':
            PreparedStatement ps2 = micon.prepareStatement(strSQL3);
            ps2.setInt(1, empl);
            ps2.executeUpdate();

            //Eliminar boletas de pago restantes:
            PreparedStatement ps1 = micon.prepareStatement(strSQL2);
            ps1.setInt(1, cont);
            ps1.executeUpdate();

            //Eliminar ficha de asistencia del empleado:
            PreparedStatement ps4 = micon.prepareStatement(strSQL4);
            ps4.setInt(1, empl);
            ps4.executeUpdate();

            micon.commit();
        } catch (SQLException e) {
            micon.rollback();
            throw new Exception("Error al anular contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    //
    public boolean contratoAnulado(int codcont) throws Exception {
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            strSQL = "select estado from contrato where id=?";
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, codcont);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("estado").equals("A")) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al obtener salario acordado del contrato del trabajador --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
        return false;
    }

    public boolean ameritaCaducarContrato(int idc) throws Exception {
        //False: no amerita (desactivar botón de cancelar contrato)
        strSQL = "select fn_amerita_contrato_caducado(?) as amerita;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        boolean amerita = false;
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idc);
            rs = ps.executeQuery();
            while (rs.next()) {
                amerita = rs.getBoolean("amerita");
            }
            return amerita;
        } catch (SQLException e) {
            throw new Exception("Error al verificar si el contrato ya amerita cancelación por caducación --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public String[] obtenerFechasContrato(int idempl) throws Exception {
        strSQL = """
                 select to_char(fechainicio,'dd-MM-yyyy') as fechainicio,
                 to_char(fechatermino,'dd-MM-yyyy') as fechatermino from contrato
                 where idempleado=? and vacacionespagadas=true and estado='V';
                 """;
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        String fechas[] = new String[2];
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idempl);
            rs = ps.executeQuery();
            while (rs.next()) {
                fechas[0] = rs.getString("fechainicio");
                fechas[1] = rs.getString("fechatermino");
            }
            return fechas;
        } catch (SQLException e) {
            throw new Exception("Error al obtener fechas del contrato --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public double[] obtenerSalarioContratoEmpleado(int idempl) throws Exception {
        strSQL = "select salarioacordado as salarioneto,salariobruto as salariobruto from contrato where idempleado=? and estado='V';";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        double salario[] = new double[2];
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idempl);
            rs = ps.executeQuery();
            while (rs.next()) {
                salario[0] = rs.getDouble("salarioneto");
                salario[1] = rs.getDouble("salariobruto");
            }
            return salario;
        } catch (SQLException e) {
            throw new Exception("Error al obtener salario de contrato de empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public int obtenerIdContratoTrabajador(int idempl) throws Exception {
        strSQL = "select id from contrato where idempleado=? and estado='V'";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        int idcont = -1;
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idempl);
            rs = ps.executeQuery();
            while (rs.next()) {
                idcont = rs.getInt("id");
            }
            return idcont;
        } catch (SQLException e) {
            throw new Exception("Error al obtener ID de contrato del trabajador --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public void actualizaRetencionesContratoEmpleado(int idempl, String ret, double montoRet, String seguro, double montoSeg, double salarioBr,
            double salarioNeto) throws Exception { //ret="AFP"; en BD: AFP
        //Actualizar monto del contrato (salario acordado y salario neto):
        String sql1 = "update contrato set salarioacordado = ?, salariobruto=? where id=?";
        //Actualizar monto de retención de seguro de fondo de pensiones:
        String sql2 = "update detalle_deduccion set iddeduccion = ?,monto=? where iddeduccion=? and idcontrato=? ";
        //Agregar seguro de salud (si es que lo registra):
        String sql3 = "insert into detalle_deduccion(idcontrato,iddeduccion,monto) values(?,?,?)";
        Connection micon = null;

        try {
            int idcontr = -1;
            int iddedactualizar = -1;

            int iddedexs = -1;
            String retDif = "";
            int idseguro = -1;

            obj.conexion();
            micon = obj.getCon();
            micon.setAutoCommit(false);

            idcontr = obtenerIdContratoTrabajador(idempl);
            PreparedStatement ps1 = micon.prepareStatement(sql1);
            ps1.setDouble(1, salarioNeto);
            ps1.setDouble(2, salarioBr);
            ps1.setDouble(3, idcontr);
            ps1.executeUpdate();

            iddedexs = objD.obtenerIdDeduccionExistente(idcontr); //AFP: 1
            iddedactualizar = objD.obtenerIdDeduccion(ret); //ONP: 2
            if (iddedexs == iddedactualizar) {
                iddedactualizar = iddedexs;
            }
            PreparedStatement ps2 = micon.prepareStatement(sql2);
            ps2.setInt(1, iddedactualizar);
            ps2.setDouble(2, montoRet);
            ps2.setInt(3, iddedexs);
            ps2.setInt(4, idcontr);
            ps2.executeUpdate();

            if (!seguro.equals("")) {
                boolean tiene = tieneSeguroSalud(seguro, idcontr);
                if (!tiene) {
                    idseguro = objD.obtenerIdDeduccion(seguro);
                    PreparedStatement ps3 = micon.prepareStatement(sql3);
                    ps3.setInt(1, idcontr);
                    ps3.setInt(2, idseguro);
                    ps3.setDouble(3, montoSeg);
                    ps3.executeUpdate();
                }
            }
            micon.commit();
        } catch (SQLException e) {
            micon.rollback();
            throw new Exception("Error al actualizar retenciones de contrato del empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

    public boolean tieneSeguroSalud(String seguro, int idcont) throws Exception {
        strSQL = """
                 select count(dd.*) as cant from detalle_deduccion dd
                 inner join deduccion d on dd.iddeduccion = d.id
                 where idcontrato=? and d.nombre=?;
                 ;
                 """;
        try {
            int cantidad = 0;
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcont);
            ps.setString(2, seguro);
            rs = ps.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt("cant");
            }
            if (cantidad >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new Exception("Error al comprobar si el contrato tiene seguro de salud --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public Date obtenerFechaTerminoContratoVigenteEmpleado(int idempl) throws Exception{
        strSQL = "select * from contrato where idempleado=? and estado='V';";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        Date fechaTermino = null;
        try {
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idempl);
            rs = ps.executeQuery();
            while (rs.next()) {
                fechaTermino = rs.getDate("fechatermino");
            }
            return fechaTermino;
        } catch (SQLException e) {
            throw new Exception("Error al obtener fecha de término de contrato vigente de trabajador --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public double obtenerSalarioNetoEmpleado(int idcont) throws Exception{
        strSQL = "select salarioacordado from contrato where id=?;";
        Connection micon = null;
        obj.conexion();
        micon = obj.getCon();
        try {
            double salariobr = 0;
            PreparedStatement ps = micon.prepareStatement(strSQL);
            ps.setInt(1, idcont);
            rs = ps.executeQuery();
            while (rs.next()) {
                salariobr = rs.getDouble("salarioacordado");
            }
            return salariobr;
        } catch (SQLException e) {
            throw new Exception("Error al obtener salario neto del contrato del empleado --> " + e.getMessage());
        } finally {
            obj.desconexion();
        }
    }

}
