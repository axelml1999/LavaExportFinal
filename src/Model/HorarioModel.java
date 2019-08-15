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
 * @author axeli
 */
public class HorarioModel extends database{
    
     Connection conn;
    
    protected ResultSet consultarHorarios(){
       ResultSet rs = Read("call consultarHorario");
       return rs;
    }
    
    protected void insertarHorario(String h_entrada, String h_salida, String turno){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("call insertarHorario(?,?,?)");
            ps.setString(1, h_entrada);
            ps.setString(2, h_salida);
            ps.setString(3, turno);
            //Error
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Insertado", "El horario ha sido registrado con exito", DesktopNotify.SUCCESS);
    }
    
     protected void modificarHorario(int id,String h_entrada, String h_salida, String turno){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("call modificarHorario(?,?,?,?)");
            ps.setString(1, h_entrada);
            ps.setString(2, h_salida);
            ps.setString(3, turno);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(HorarioModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Actualizado", "El horario ha sido actualizado con exito", DesktopNotify.SUCCESS);
   }
   
   protected void eliminarHorario(int id){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("call eliminarHorario(?)");
            
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(HorarioModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se puede eliminar un registro ligado a otra tabla");
        }
        DesktopNotify.showDesktopMessage("Registro Eliminado", "El horario ha sido eliminado con exito", DesktopNotify.FAIL);
   }
   
   protected ResultSet consultarTurnoPorIdHorario(String turno){
        ResultSet rs = Read("select * from horario where turno='"+turno+"'");
        return rs;
    }
    
    protected ResultSet consultarHorarioPorIdHorario(String id_horario){
        ResultSet rs = Read("select * from horario where id_horario="+id_horario);
        return rs;
    }
    
}
