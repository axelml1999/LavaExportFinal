/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ExtrasModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ExtrasController extends ExtrasModel {

    public DefaultTableModel tablaExtras() {
        String [] titulo = {"Id","extras"};
        DefaultTableModel tb = new DefaultTableModel(null, titulo);


        Object[] fila = new Object[2];

        ResultSet rs = consultarExtras();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("id_extras");
                fila[1] = rs.getString("descripcion_extras");
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExtrasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }
    
    public void guardar(String accion, int id, String descripcion){
        if (accion == "I") {
            insertarExtras(descripcion);
        } else {
            modificarextras(id, descripcion);
        }
    }
     public void eliminar(int id){
         eliminarExtras(id);
     }
}


