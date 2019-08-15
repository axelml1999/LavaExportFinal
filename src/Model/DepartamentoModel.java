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
import javax.swing.JOptionPane;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author axeli
 */
public class DepartamentoModel extends database {

    Connection conn;

    protected ResultSet consultarDepartamentos() {
        ResultSet rs = Read("call consultarDepartamento");
        return rs;

    }

    //Modificamos-------------------------------------------------------------------------
    protected ResultSet consultarAreaPorIdDepartamento(String descripcion) {
        ResultSet rs = Read("select * from departamento where area='" + descripcion + "'");
        return rs;
    }

    protected ResultSet consultarDepartamentoPorIdDepartamento(String id_departamento) {
        ResultSet rs = Read("select * from departamento where id_departamento='" + id_departamento + "'");
        return rs;
    }

    //------------------------------------------------------------------------------------
    protected void insertarDepartamento(String nombre, int capacidad) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("call insertarDepartamento(?,?)");
            ps.setString(1, nombre);
            ps.setInt(2, capacidad);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Insertado", "El departamento ha sido registrado con exito", DesktopNotify.SUCCESS);
    }

    protected void modificarDepartamento(int id, String nombre, int capacidad) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("call modificarDepartamento(?,?,?)");
            ps.setString(1, nombre);
            ps.setInt(2, capacidad);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(DepartamentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Actualizado", "El departamento ha sido actualizado con exito", DesktopNotify.SUCCESS);
    }

    protected void eliminarDepartamento(int id) {
        PreparedStatement ps = null;
        conn = GetConnection();
        int rowAffected = 0;

        try {
            ps = conn.prepareStatement("call eliminarDepartamento(?)");

            ps.setInt(1, id);
            rowAffected = ps.executeUpdate();

        } catch (SQLException ex) {

            Logger.getLogger(DepartamentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rowAffected == 1) {
            DesktopNotify.showDesktopMessage("Registro Eliminado", "El departamento ha sido eliminado con exito", DesktopNotify.FAIL);
        } else {
            DesktopNotify.showDesktopMessage("ERROR", "No puedes eliminar un registro ligado con otra tabla", DesktopNotify.ERROR);
        }

    }

}
