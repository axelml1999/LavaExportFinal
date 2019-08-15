/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.database;
import static DB.database.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author axeli
 */
public class CargoModel  extends database{
    
     Connection conn;
    
    protected ResultSet consultarCargos(){
       ResultSet rs = Read("call consultarCargo");
       return rs;
    }
    
    protected ResultSet consultarIdPorAreaCargo(String descripcion){
        ResultSet rs = Read("select * from cargo where descripcion_cargo='"+descripcion+"'");
        return rs;
    }
    
    protected ResultSet consultarAreaPorIdCargo(String id_cargo){
        ResultSet rs = Read("select * from cargo where id_cargo="+id_cargo);
        return rs;
    }
    
    protected void insertarCargo(String descripcion){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("call insertarCargo(?)");
            ps.setString(1, descripcion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CargoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Insertado", "El cargo ha sido registrado con exito", DesktopNotify.SUCCESS);
    }
    
     protected void modificarCargo(int id,String descripcion){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("call modificarCargo(?,?)");
            ps.setString(1, descripcion);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(CargoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Actualizado", "El cargo ha sido actualizado con exito", DesktopNotify.SUCCESS);
   }
   
   protected void eliminarCargo(int id){
       PreparedStatement ps = null;
       conn = GetConnection();
       int rowAffected = 0;
        try {
            ps = conn.prepareStatement("call eliminarCargo(?)");
            
            ps.setInt(1, id);
            rowAffected = ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(CargoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (rowAffected == 1) {
            DesktopNotify.showDesktopMessage("Registro Eliminado", "El cargo ha sido eliminado con exito", DesktopNotify.FAIL);
        } else {
            DesktopNotify.showDesktopMessage("ERROR", "No puedes eliminar un registro ligado con otra tabla", DesktopNotify.ERROR);
        }
        
   }
    
}
