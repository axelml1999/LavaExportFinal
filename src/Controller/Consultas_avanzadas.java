/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConsultasModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class Consultas_avanzadas extends ConsultasModel {

    public DefaultTableModel tablaCargos() {
        String[] titulos = {"Nomina", "Año", "Desde", "Hasta", "Extra", "Descuentos", "Total"};
        DefaultTableModel tb = new DefaultTableModel(null, titulos);
        Object[] fila = new Object[7];
        ResultSet rs = Consultar_nominas();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("semana");
                fila[1] = rs.getString("anio");
                fila[2] = rs.getInt("fecha_inicio");
                fila[3] = rs.getString("fecha_fin");
                fila[4] = rs.getInt("total_extras");
                fila[5] = rs.getString("total_desc");
                fila[6] = rs.getInt("total_nom");
                
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }
     public DefaultTableModel tablaCumpleaños() {
        String[] titulos = {"Id_empleado", "Nombre", "Departamento", "Cargo", "Fecha_cumpleaños"};
        DefaultTableModel tb = new DefaultTableModel(null, titulos);
        Object[] fila = new Object[5];
        ResultSet rs = Consultar_nominas();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("id_empleado");
                fila[1] = rs.getString("nombre")+" "+rs.getString("apellido_paterno")+" "+rs.getString("apellido_materno");
                fila[2] = rs.getInt("Area");
                fila[3] = rs.getString("descripcion_cargo");
                fila[4] = rs.getInt("fecha");
                
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }

}
