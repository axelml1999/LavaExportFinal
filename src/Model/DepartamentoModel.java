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

/**
 *
 * @author axeli
 */
public class DepartamentoModel extends database {

    Connection conn;

    protected ResultSet consultarDepartamentos() {
        ResultSet rs = Read("select * from departamento");
        return rs;

    }
    
    //Modificamos-------------------------------------------------------------------------
    
    protected ResultSet consultarAreaPorIdDepartamento(String descripcion){
        ResultSet rs = Read("select * from departamento where area='"+descripcion+"'");
        return rs;
    }
    
    protected ResultSet consultarDepartamentoPorIdDepartamento(String id_departamento){
        ResultSet rs = Read("select * from departamento where id_departamento="+id_departamento);
        return rs;
    }
    
    //------------------------------------------------------------------------------------

    protected void insertarDepartamento(String nombre, int capacidad) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("insert into departamento(area,num_trab) values(?,?)");
            ps.setString(1, nombre);
            ps.setInt(2, capacidad);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Insertado");
    }

    protected void modificarDepartamento(int id, String nombre, int capacidad) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("update departamento set area=?, num_trab=? where id_departamento=?");
            ps.setString(1, nombre);
            ps.setInt(2, capacidad);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(DepartamentoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
    }

    protected void eliminarDepartamento(int id) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("delete from departamento where id_departamento=?");

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(DepartamentoModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se puede eliminar un registro ligado a otra tabla");
        }
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
    }

}
