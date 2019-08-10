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
public class AsistenciaModel extends database {

    Connection conn;

    protected ResultSet consultarAsistencia() {
        ResultSet rs = Read("select * from asistencia");
        return rs;

    }

    protected void insertarAsistencia(String dia1, String dia2, String dia3, String dia4, String dia5, String dia6, String dia7) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("insert into asistencia(dia1,dia2,dia3,dia4,dia5,dia6,dia7) values(?,?,?,?,?,?,?)");
            ps.setString(1, dia1);
            ps.setString(2, dia2);
            ps.setString(3, dia3);
            ps.setString(4, dia4);
            ps.setString(5, dia5);
            ps.setString(6, dia6);
            ps.setString(7, dia7);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AsistenciaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Insertado");
    }

    protected void modificarAsistencia(int id, String dia1, String dia2, String dia3, String dia4, String dia5, String dia6, String dia7) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("update asistencia set dia1=?,dia2=?,dia3=?,dia4=?,dia5=?,dia6=?,dia7=?, where id_asistencia=?");
            ps.setString(1, dia1);
            ps.setString(2, dia2);
            ps.setString(3, dia3);
            ps.setString(4, dia4);
            ps.setString(5, dia5);
            ps.setString(6, dia6);
            ps.setString(7, dia7);
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(AsistenciaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
    }

    protected void eliminarAsistencia(int id) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("delete from asistencia where id_asistencia=?");

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(AsistenciaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
    }
}
