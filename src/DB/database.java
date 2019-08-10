/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mysql.jdbc.Connection;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axeli
 */
public class database   {

    protected Connection con;
    protected Statement pst;

    public static Connection GetConnection() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String server = "jdbc:mysql://localhost/nomina";
            String user = "root";
            String password = "";
            conexion = (Connection) DriverManager.getConnection(server, user, password);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        } finally {
            return conexion;
        }

    }

    protected ResultSet Read(String sql) {
        try {
            con = GetConnection();
            pst=con.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
