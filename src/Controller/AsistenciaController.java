/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AsistenciaModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axeli
 */
public class AsistenciaController extends AsistenciaModel {

    public DefaultTableModel tablaAsistencias() {
        String[] titulos={"Id","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        DefaultTableModel tb = new DefaultTableModel(null,titulos);

        Object[] fila = new Object[7];

        ResultSet rs = consultarAsistencia();
        try {
            while (rs.next()) {
                fila[0] = rs.getString("id_asistencia");
                fila[1] = rs.getString("dia1");
                fila[2] = rs.getString("dia2");
                fila[3] = rs.getString("dia3");
                fila[4] = rs.getString("dia4");
                fila[5] = rs.getString("dia5");
                fila[6] = rs.getString("dia6");
                fila[7] = rs.getString("dia7");
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsistenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }

    public void guardar(String accion, int id, String dia1, String dia2, String dia3, String dia4, String dia5, String dia6, String dia7) {
        if ("I".equals(accion)) {
            insertarAsistencia(dia1, dia2, dia3, dia4, dia5, dia6, dia7);
        } else {
            modificarAsistencia(id, dia1, dia2, dia3, dia4, dia5, dia6, dia7);
        }
    }

    public void eliminar(int id) {
        eliminarAsistencia(id);
    }
}
