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
public class DescuentoModel extends database {

    Connection conn;

    protected ResultSet consultarDescuento() {
        ResultSet rs = Read("select * from descuento");
        return rs;

    }
  protected ResultSet consultarDescuento_id(String descripcion) {
        ResultSet rs = Read("select * from descuento where descripcion_descuento="+descripcion+"'");
        return rs;

    }
    protected ResultSet consultarDescuento_descripcion(String id) {
        ResultSet rs = Read("select * from descuento where id_descuento="+id+"'");
        return rs;

    }
    protected void insertarDescuento(String nombre) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("insert into descuento(descripcion_descuento) values(?)");
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DescuentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Insertado");
    }

    protected void modificarDescuento(int id, String nombre) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("update descuento set descripcion_descuento=? where id_descuento=?");
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(DescuentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
    }

    protected void eliminarDescuento(int id) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("delete from descuento where id_departamento=?");

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(DescuentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
    }
}
