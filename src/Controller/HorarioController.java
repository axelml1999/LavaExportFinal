/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CargoModel;
import Model.HorarioModel;
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
public class HorarioController extends HorarioModel {

    public DefaultTableModel tablaHorarios()  {
        String[] titulos = {"Id", "Hora Entrada","Hora Salida","Turno"};
        DefaultTableModel tb = new DefaultTableModel(null, titulos);
        Object[] fila = new Object[4];
        ResultSet rs = consultarHorarios();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("id_horario");
                fila[1] = rs.getString("hora_llegada");
                fila[2] = rs.getString("hora_salida");
                fila[3] = rs.getString("turno");
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }

    public void guardar(String accion, int id,String h_entrada, String h_salida, String turno) {
        if ("I".equals(accion)) {
            insertarHorario(h_entrada, h_salida, turno);
        } else {
            modificarHorario(id, h_entrada, h_salida, turno);
        }
    }

    public void eliminar(int id) {
        
        eliminarHorario(id);
    }
    
    public DefaultComboBoxModel consultarHorariosTodos(){
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        ResultSet rs = consultarHorarios();
        cb.addElement("Selecciona el Horario");
        try {
            while (rs.next()) {
                cb.addElement(rs.getString("turno"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cb;
    }
    
    public String consultarTurnoHorarioController(String turno){
        ResultSet rs = consultarTurnoPorIdHorario(turno);
        String id_horario = null;
        try {
            while (rs.next()) {
                id_horario = rs.getString("id_horario");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_horario;
    }
    
    public String consultarIdHorarioController(String id_horario){
        ResultSet rs = consultarHorarioPorIdHorario(id_horario);
        String turno = null;
        try {
            while (rs.next()) {
                turno = rs.getString("turno");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turno;
    }

}
