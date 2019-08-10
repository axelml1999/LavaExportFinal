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
 * @author axeli
 */
public class CargoModel  extends database{
    
     Connection conn;
    
    protected ResultSet consultarCargos(){
       ResultSet rs = Read("select * from cargo");
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
            ps = conn.prepareStatement("insert into cargo(descripcion_cargo) values(?)");
            ps.setString(1, descripcion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CargoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Insertado");
    }
    
     protected void modificarCargo(int id,String descripcion){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("update cargo set descripcion_cargo=? where id_cargo=?");
            ps.setString(1, descripcion);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(CargoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
   }
   
   protected void eliminarCargo(int id){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("delete from cargo where id_cargo=?");
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(CargoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
   }
    
}
