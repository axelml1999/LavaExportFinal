/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DescuentoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axeli
 */
public class DescuentoController extends DescuentoModel {
    
    public DefaultTableModel tablaDescuento() {
        String[] titulos= {"Id","Tipo Descuento"};
        DefaultTableModel tb = new DefaultTableModel(null,titulos);
        
        
        Object[] fila = new Object[2];
        
        ResultSet rs = consultarDescuento();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("id_descuento");
                fila[1] = rs.getString("descripcion_descuento");
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DescuentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tb;
    }
    
    public void guardar(String accion, int id, String nombre) {
        if ("I".equals(accion)) {
            insertarDescuento(nombre);
        } else {
            modificarDescuento(id, nombre);
        }
    }
    
    public void eliminar(int id) {
        eliminarDescuento(id);
    }
    public String consultar_id(String descripcion) {
        ResultSet rs =consultarDescuento_id(descripcion);
     String valor="";
        try {
            while(rs.next()){
                valor=rs.getString("id_descuento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DescuentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;

    }
   public String consultar_descripcion(String id) {
        ResultSet rs =consultarDescuento_descripcion(id);
     String valor="";
        try {
            while(rs.next()){
                valor=rs.getString("descripcion_descuento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DescuentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;

    }
}
