/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CargoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axeli
 */
public class CargoController  extends CargoModel {

   public DefaultTableModel tablaCargos() {
        String[] titulos = {"Id", "Cargo"};
        DefaultTableModel tb = new DefaultTableModel(null, titulos);
        Object[] fila = new Object[2];
        ResultSet rs = consultarCargos();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("id_cargo");
                fila[1] = rs.getString("descripcion_cargo");
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }

    public void guardar(String accion, int id, String descripcion) {
        if ("I".equals(accion)) {
            insertarCargo(descripcion);
        } else {
            modificarCargo(id, descripcion);
        }
    }

    public void eliminar(int id) {
        eliminarCargo(id);
    }
    
     public DefaultComboBoxModel consultarCargosTodos(){
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        ResultSet rs = consultarCargos();
        cb.addElement("Selecciona el Cargo");
        try {
            while (rs.next()) {
                cb.addElement(rs.getString("descripcion_cargo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cb;
    }
    
    public String consultarIdeCargoController(String descripcion){
        ResultSet rs = consultarIdPorAreaCargo(descripcion);
        String id_cargo = null;
        try {
            while (rs.next()) {
                id_cargo = rs.getString("id_cargo");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_cargo;
    }
    
    public String consultarDescripcionCargoController(String id_cargo){
        ResultSet rs = consultarAreaPorIdCargo(id_cargo);
        String descripcion_cargo = null;
        try {
            while (rs.next()) {
                descripcion_cargo = rs.getString("descripcion_cargo");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descripcion_cargo;
    }
}
