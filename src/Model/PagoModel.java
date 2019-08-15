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

public class PagoModel  extends database {

    Connection conn;

    protected ResultSet consultarPago() {
        ResultSet rs = Read("SELECT e.id_empleado, e.id_horario, e.id_cargo, e.nombre, "
                + "e.apellido_paterno, e.apellido_materno, e.direccion, e.num_seg_social,"
                + " e.rfc, e.salario, e.curp, e.gratificacion, e.sexo, e.id_departamento,"
                + " p.numero_cuenta, p.numero_tarjeta, p.descripcion_pago "
                + "FROM empleado e LEFT JOIN pago p on p.id_empleado = e.id_empleado");
        return rs;
    }
 protected ResultSet consultarPagoporempleado(String id_empleado) {
        ResultSet rs = Read("select * from pago where id_empleado="+id_empleado+"");
        return rs;
    }
    protected void insertarPago(String id_empleado,String numero_cuenta, String numero_tarjeta, String descripcion_pago) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("insert into pago(id_empleado,numero_cuenta,numero_tarjeta,descripcion_pago) values(?,?,?,?)");
           ps.setString(1, id_empleado);
            ps.setString(2, numero_cuenta);
            ps.setString(3, numero_tarjeta);
            ps.setString(4, descripcion_pago);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PagoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Insertado", "El tipo de pago ha sido registrado con exito", DesktopNotify.SUCCESS);
    }
     protected void modificarPago(String id_empleado,String numero_cuenta, String numero_tarjeta, String descripcion_pago){
       PreparedStatement ps = null;
       conn = GetConnection();
        try {
            ps = conn.prepareStatement("update pago set  numero_cuenta=?,numero_tarjeta=?,descripcion_pago=? where id_empleado=?" );
   
            ps.setInt(1, Integer.parseInt(numero_cuenta));
            ps.setInt(2, Integer.parseInt(numero_tarjeta));
            ps.setString(3, descripcion_pago);
              ps.setInt(4, Integer.parseInt( id_empleado));
            ps.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(PagoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Actualizado", "El tipo de pago ha sido actualizado con exito", DesktopNotify.SUCCESS);
}
     protected void eliminarPago(String id) {
        PreparedStatement ps = null;
        conn = GetConnection();
        try {
            ps = conn.prepareStatement("delete from pago where id_empleado=?");

            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(PagoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Registro Eliminado", "El tipo de pago ha sido eliminado con exito", DesktopNotify.FAIL);
    }
}

