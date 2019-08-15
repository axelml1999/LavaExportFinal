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
import javax.swing.JOptionPane;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Victor
 */
public class ExtrasModel extends database {
    
    Connection conn;
    
   protected ResultSet consultarExtras(){
       ResultSet rs = Read("call consultarExtras");
       return rs;
   }
   
   protected void insertarExtras(String descripcion) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("call insertarExtras(?)");
            ps.setString(1, descripcion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExtrasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         DesktopNotify.showDesktopMessage("Registro Insertado", "El extra ha sido registrado con exito", DesktopNotify.SUCCESS);
    }
    protected void modificarextras(int id,String descripcion){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("call modificarExtras(?,?)");
            ps.setString(1, descripcion);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(ExtrasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
          DesktopNotify.showDesktopMessage("Registro Actualizado", "El extra ha sido actualizado con exito", DesktopNotify.SUCCESS);
   }
    protected void eliminarExtras(int id){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("call eliminarExtras(?)");
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(ExtrasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
           DesktopNotify.showDesktopMessage("Registro Eliminado", "El extra ha sido eliminado con exito", DesktopNotify.FAIL);
   }
}
