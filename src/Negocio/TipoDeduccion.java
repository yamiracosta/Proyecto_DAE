package Negocio;

import Datos.Conexion;
import java.sql.*;

public class TipoDeduccion {
    
    Conexion obj = new Conexion();
    String strSQL;
    ResultSet rs;
    
    public ResultSet cargarTiposDeduccion() throws Exception {
        try {
            strSQL = "select tipo from tipo_deduccion;";
            Connection micon = null;
            obj.conexion();
            micon = obj.getCon();
            PreparedStatement ps = micon.prepareStatement(strSQL);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception ex) {
            throw new Exception("Error al obtener tipos de deducciones --> " + ex.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    //Mantenimiento
    public ResultSet listarTodo() throws Exception{
        try{
            strSQL = "select * from tipo_deduccion;";
            obj.conexion();
            Connection con = null;
            con = obj.getCon();
            PreparedStatement ps = con.prepareStatement(strSQL);
            rs = ps.executeQuery();
            return rs;
        } catch(Exception e){
            throw new Exception("Error al listar los tipos de deducciones --> "+e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public ResultSet filtrarTipoDeduccion(String tipodedu) throws Exception{
        try{
            strSQL = "select * from tipo_deduccion where tipo ilike ?;";
            obj.conexion();
            Connection con = null;
            con = obj.getCon();
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1,"%"+tipodedu+"%");
            rs = ps.executeQuery();
            return rs;
        } catch(Exception e){
            throw new Exception("Error al filtrar los tipos de deducciones --> "+e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public void registrarTipoDeduccion(String tipodedu) throws Exception{
        try{
            strSQL = "insert into tipo_deduccion(tipo) values(?);";
            obj.conexion();
            Connection con = null;
            con = obj.getCon();
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, tipodedu);
            ps.executeUpdate();
        } catch(Exception e){
            throw new Exception("Error al registrar el tipo de deducción --> "+e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public void modificarTipoDeduccion(String tipodedu, int idtipodedu) throws Exception{
        try{
            strSQL = "update tipo_deduccion set tipo=? where id=?;";
            obj.conexion();
            Connection con = null;
            con = obj.getCon();
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, tipodedu);
            ps.setInt(2, idtipodedu);
            ps.executeUpdate();
        } catch(Exception e){
            throw new Exception("Error al modificar el tipo de deducción --> "+e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public void eliminarTipoDeduccion(int idtipodedu) throws Exception{
        try{
            strSQL = "delete from tipo_deduccion where id=?;";
            obj.conexion();
            Connection con = null;
            con = obj.getCon();
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, idtipodedu);
            ps.executeUpdate();
        } catch(Exception e){
            throw new Exception("Error al eliminar el tipo de deducción --> "+e.getMessage());
        } finally {
            obj.desconexion();
        }
    }
    
    public boolean existenRegistrosReferenciados(int idtipodedu) throws Exception{
        try{
            int cantidad=0;
            boolean existe;
            strSQL = "select count(*) as cant from deduccion where idtipodeduccion=?;";
            obj.conexion();
            Connection con = null;
            con = obj.getCon();
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, idtipodedu);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                cantidad=rs.getInt("cant");
            }
            
            if (cantidad >= 1) {
                existe=true;
            }
        } catch(Exception e){
            throw new Exception("Error al eliminar el tipo de deducción --> "+e.getMessage());
        } finally {
            obj.desconexion();
        }
        return false;
    }
    
}
