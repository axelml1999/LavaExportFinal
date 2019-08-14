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
/**
 *
 * @author Victor
 */
public class ExtrasModel extends database {
    
    Connection conn;
    
   protected ResultSet consultarExtras(){
       ResultSet rs = Read("select * from extras");
       return rs;
   }
     
   protected ResultSet consultarExtras_id(String descripcion){
       ResultSet rs = Read("select * from extras where descripcion='"+descripcion+"'");
       return rs;
   }
   
   protected ResultSet consultarExtras_descripcion(String id){
       ResultSet rs = Read("select * from extras where extras='"+id+"'");
       return rs;
   }
   protected void insertarExtras(String descripcion) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("insert into extras(descripcion_extras) values(?)");
            ps.setString(1, descripcion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ExtrasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Insertado");
    }
    protected void modificarextras(int id,String descripcion){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("update extras set descripcion_extras=? where id_extras=?");
            ps.setString(1, descripcion);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(ExtrasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
   }
    protected void eliminarExtras(int id){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("delete from extras where id_extras=?");
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(ExtrasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
   }
}
