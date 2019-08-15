/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.database;
import static DB.database.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ds.desktop.notify.DesktopNotify;
import ds.desktop.notify.NotifyTheme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author axeli
 */
public class EmpleadoModel extends database {

    Connection conn;

    protected ResultSet consultarEmpleado() {
        ResultSet rs = Read("call consultarEmpleados");
        return rs;
    }
    
     protected ResultSet consultarEmpleadoPorId(String id_empleado) {
        ResultSet rs = Read("select * from empleado where id_empleado = "+id_empleado);
        return rs;
    }
     
     protected ResultSet consultarMaxEmpleado() {
        ResultSet rs = Read("select max(id_empleado) from empleado");
        return rs;
    }

    protected void insertarEmpleado(String id_empleado, String id_horario, String id_cargo, String nombre, String a_paterno, String a_materno, String curp,
             String id_departamento, String direccion, String salario, String sexo, String estatus, String num_seg_social, String rfc, String gratificacion, String fecha_nacimiento, String fecha_entrada) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            
            ps = conn.prepareStatement("insert into empleado(id_empleado,id_horario,id_cargo,nombre,apellido_paterno,apellido_materno,"
                   + "curp,id_departamento,direccion,salario,sexo,estatus,num_seg_social,rfc,gratificacion,fecha_nacimiento,fecha_entrada) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, id_empleado);
            ps.setString(2, id_horario);
            ps.setString(3, id_cargo);
            ps.setString(4, nombre);
            ps.setString(5, a_paterno);
            ps.setString(6, a_materno);
            ps.setString(7, curp);
            ps.setString(8, id_departamento);
            ps.setString(9, direccion);
            ps.setString(10, salario);
            ps.setString(11, sexo);
            ps.setString(12, estatus);
            ps.setString(13, num_seg_social);
            ps.setString(14, rfc);
            ps.setString(15, gratificacion);
            ps.setString(16, fecha_nacimiento);
            ps.setString(17, fecha_entrada);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Insertado", "El empleado ha sido registrado con exito", DesktopNotify.SUCCESS);
    }

    protected void modificarEmpleado(String id_empleado, String id_horario, String id_cargo, String nombre, String a_paterno, String a_materno, String curp,
             String id_departamento, String direccion, String salario, String sexo, String estatus, String num_seg_social, String rfc, String gratificacion, String fecha_nacimiento, String fecha_entrada) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("update empleado set id_empleado=?, id_horario=?, id_cargo=?, nombre=?, apellido_paterno=?, apellido_materno=?,"
                    + "curp=?, id_departamento=?, direccion=?, salario=?, sexo=?, estatus=?, num_seg_social=?, rfc=? ,gratificacion=?, fecha_nacimiento=?, fecha_entrada=? where id_empleado=?");
            ps.setString(1, id_empleado);
            ps.setString(2, id_horario);
            ps.setString(3, id_cargo);
            ps.setString(4, nombre);
            ps.setString(5, a_paterno);
            ps.setString(6, a_materno);
            ps.setString(7, curp);
            ps.setString(8, id_departamento);
            ps.setString(9, direccion);
            ps.setString(10, salario);
            ps.setString(11, sexo);
            ps.setString(12, estatus);
            ps.setString(13, num_seg_social);
            ps.setString(14, rfc);
            ps.setString(15, gratificacion);
            ps.setString(16, fecha_nacimiento);
            ps.setString(17, fecha_entrada);
            ps.setString(18, id_empleado);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Actualizado", "El empleado ha sido actualizado con exito", DesktopNotify.SUCCESS);
    }
    
    protected void eliminarEmpleado(String id_empleado){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("delete from empleado where id_empleado=?");
            
            ps.setString(1, id_empleado);
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Eliminado", "El empleado ha sido eliminado con exito", DesktopNotify.FAIL);
   }

}
