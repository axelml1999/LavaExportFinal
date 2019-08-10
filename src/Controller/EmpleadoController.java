/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EmpleadoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author axeli
 */
public class EmpleadoController extends EmpleadoModel {

    DepartamentoController dc=new DepartamentoController();
    CargoController cc = new CargoController();
    HorarioController hc = new HorarioController();
    
    public DefaultTableModel tablaEmpleado() {

        String[] titulos = {"Id", "Nombre","Direccion","Sexo","Estatus","CURP","Horario","Cargo","Departamento","Gratificacion","Salario","NSS","RFC"};
        DefaultTableModel tb = new DefaultTableModel(null, titulos);
        Object[] fila = new Object[13];

        ResultSet rs = consultarEmpleado();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("id_empleado");
                fila[1] = rs.getString("nombre") + " " + rs.getString("apellido_paterno") + " " + rs.getString("apellido_materno");
                fila[2] = rs.getString("direccion");
                fila[3] = rs.getString("sexo");
                fila[4] = rs.getString("estatus");
                fila[5] = rs.getString("curp");
                fila[6] = hc.consultarIdHorarioController(rs.getString("id_horario"));
                fila[7] = cc.consultarDescripcionCargoController(rs.getString("id_cargo"));
                fila[8] = dc.consultarIdDepartamentoController(rs.getString("id_departamento"));

                fila[9] = rs.getString("gratificacion");
                fila[10] = rs.getString("salario");
                fila[11] = rs.getString("num_seg_social");
                fila[12] = rs.getString("rfc");
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }
    
    
    public void guardar(String accion, String id_empleado, String id_horario, String id_cargo, String nombre, String a_paterno, String a_materno, String curp,
             String id_departamento, String direccion, String salario, String sexo, String estatus, String num_seg_social, String rfc, String gratificacion) {
        if ("I".equals(accion)) {
            insertarEmpleado(id_empleado, id_horario, id_cargo, nombre, a_paterno, a_materno, curp, id_departamento, direccion, salario, sexo, estatus, num_seg_social, rfc, gratificacion);
        } else {
            modificarEmpleado(id_empleado, id_horario, id_cargo, nombre, a_paterno, a_materno, curp, id_departamento, direccion, salario, sexo, estatus, num_seg_social, rfc, gratificacion);
        }
    }

    public void eliminar(String id_empleado) {
        eliminarEmpleado(id_empleado);
    }
    
    public ResultSet consultarEmpleadoPorCodigo(String id_empleado){
        ResultSet rs = consultarEmpleadoPorId(id_empleado);
        return rs;
    }
    
    public Integer consMAXEmpleado(){
        int numMax = 0;
        ResultSet rs = consultarMaxEmpleado();
        try {
            while(rs.next()){
                numMax = rs.getInt("id_empleado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(numMax == 0){
            numMax = 1;
        } else {
            numMax = numMax + 1;
            
        }
        return numMax;
    }
    
    
}
