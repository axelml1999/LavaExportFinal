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
public class DescuentoModel extends database {

    Connection conn;

    protected ResultSet consultarDescuento() {
        ResultSet rs = Read("call consultarDescuento");
        return rs;

    }
  protected ResultSet consultarDescuento_id(String descripcion) {
        ResultSet rs = Read("select * from descuento where descripcion_descuento='"+descripcion+"'");
        return rs;

    }
    protected ResultSet consultarDescuento_descripcion(String id) {
        ResultSet rs = Read("select * from descuento where id_descuento="+id+"");
        return rs;

    }
    protected void insertarDescuento(String nombre) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("call insertarDescuento(?)");
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DescuentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Insertado", "El descuento ha sido registrado con exito", DesktopNotify.SUCCESS);
    }

    protected void modificarDescuento(int id, String nombre) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("call modificarDescuento(?,?)");
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(DescuentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Actualizado", "El descuento ha sido actualizado con exito", DesktopNotify.SUCCESS);
    }

    protected void eliminarDescuento(int id) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("call eliminarDescuento(?)");

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(DescuentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Eliminado", "El descuento ha sido eliminado con exito", DesktopNotify.FAIL);
    }
}
