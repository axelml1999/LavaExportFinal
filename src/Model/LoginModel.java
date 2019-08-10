/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author axeli
 */
public class LoginModel extends database {

    Connection conn;

    protected String validarUsuario(String user, String password) {
        String Usuario = "";
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            System.out.println("1");
            conn = GetConnection();
            ps = conn.prepareStatement("call autentificacion(?,?)");
            ps.setString(1, user);
            ps.setString(2, password);
            System.out.println("2");
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                Usuario = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(Usuario);
        return Usuario;
    }

}
