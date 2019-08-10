/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DepartamentoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axeli
 */
public class DepartamentoController extends DepartamentoModel {

    public DefaultTableModel tablaDepartamentos() {
        String[] titulos = {"Id","Nombre","Capacidad"};
        DefaultTableModel tb = new DefaultTableModel(null,titulos);
        Object[] fila = new Object[3];

        ResultSet rs = consultarDepartamentos();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("Id_departamento");
                fila[1] = rs.getString("area");
                fila[2] = rs.getInt("num_trab");
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }

    public void guardar(String accion, int id, String nombre, int capacidad) {
        if ("I".equals(accion)) {
            insertarDepartamento(nombre, capacidad);
        } else {
            modificarDepartamento(id, nombre, capacidad);
        }
    }

    public void eliminar(int id) {
        eliminarDepartamento(id);
    }
    
    
    //Modificamos--------------------------------------------------------------------------------------
    
    public DefaultComboBoxModel consultarDepartamentosTodos(){
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        ResultSet rs = consultarDepartamentos();
        cb.addElement("Selecciona el Area");
        try {
            while (rs.next()) {
                cb.addElement(rs.getString("area"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cb;
    }
    
    public String consultarAreaDepartamentoController(String descripcion){
        ResultSet rs = consultarAreaPorIdDepartamento(descripcion);
        String id_departamento = null;
        try {
            while (rs.next()) {
                id_departamento = rs.getString("id_departamento");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_departamento;
    }
    
    public String consultarIdDepartamentoController(String id_departamento){
        ResultSet rs = consultarDepartamentoPorIdDepartamento(id_departamento);
        String descripcion = null;
        try {
            while (rs.next()) {
                descripcion = rs.getString("area");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descripcion;
    }
    
    //----------------------------------------------------------------------------------------------------------
}
