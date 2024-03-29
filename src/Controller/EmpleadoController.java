/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EmpleadoModel;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    
    public String getFecha(JDateChooser jdc){
        if(jdc.getDate()!=null){
            return sdf.format(jdc.getDate());
        }else{
            return null;
        }
    }
    
    public java.util.Date setFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaE = null;
        
        try {
            fechaE=formato.parse(fecha);
            return fechaE;
        } catch (ParseException ex) {
            return null;
        }
        
    }
    
    
    
    public DefaultTableModel tablaEmpleado() {

        String[] titulos = {"Id","Departamento","Nombre","Horario","Fecha Nacimiento","Fecha Ingreso","Estatus"};
        DefaultTableModel tb = new DefaultTableModel(null, titulos);
        Object[] fila = new Object[8];

        ResultSet rs = consultarEmpleado();
        try {
            while (rs.next()) {
                fila[0] = rs.getInt("id_empleado");
                fila[1] = dc.consultarIdDepartamentoController(rs.getString("id_departamento"));
                fila[2] = rs.getString("nombre") + " " + rs.getString("apellido_paterno") + " " + rs.getString("apellido_materno");
                
                
                fila[3] = hc.consultarIdHorarioController(rs.getString("id_horario"));
//                fila[4] = cc.consultarDescripcionCargoController(rs.getString("id_cargo"));
                //System.out.println(rs.getString("id_cargo"));

                fila[4] = rs.getString("fecha_nacimiento");
                fila[5] = rs.getString("fecha_entrada");
                fila[6] = consultarEstatus(rs.getString("estatus"));
                tb.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tb;
    }
    
    
    public void guardar(String accion, String id_empleado, String id_horario, String id_cargo, String nombre, String a_paterno, String a_materno, String curp,
             String id_departamento, String direccion, String salario, String sexo, String estatus, String num_seg_social, String rfc, String gratificacion, String fecha_nacimiento, String fecha_entrada) {
        if ("I".equals(accion)) {
            insertarEmpleado(id_empleado, id_horario, id_cargo, nombre, a_paterno, a_materno, curp, id_departamento, direccion, salario, sexo, estatus, num_seg_social, rfc, gratificacion, fecha_nacimiento, fecha_entrada);
        } else {
            modificarEmpleado(id_empleado, id_horario, id_cargo, nombre, a_paterno, a_materno, curp, id_departamento, direccion, salario, sexo, estatus, num_seg_social, rfc, gratificacion, fecha_nacimiento, fecha_entrada);
        }
    }
    
    public String consultarSexo(String sexo) {
        if (sexo.equals("1")) {
            sexo = "Masculino";
        }else if (sexo.equals("2")) {
            sexo = "Femenino";
        }else if(sexo.equals("3")) {
            sexo = "No especificar";
        }
        
        return sexo;
    }
    
    public String consultarEstatus(String estatus) {
        if (estatus.equals("1")) {
            estatus = "Activo";
        }else if (estatus.equals("2")) {
            estatus = "Inactivo";
        }else if(estatus.equals("3")) {
            estatus = "Lista Negra";
        }
        
        return estatus;
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
