/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.database;
import static DB.database.GetConnection;
import com.mysql.jdbc.Connection;
import java.sql.Date;
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
 * @author Joel
 */
public class ImportarnominaModel extends database{
    
        Connection conn;
     protected void insertarNomina(String semana, String anio, String fechainicio, String fechafin, String textras,
             String t_desc, String total_nom) {
        PreparedStatement ps = null;
     conn = GetConnection();
        try {
            
            ps = conn.prepareStatement("insert into nomina_general(semana,fecha_inicio,fecha_fin,anio,total_extras,total_desc,total_nom) "
                    + "values(?,?,?,?,?,?,?)");
        
            ps.setInt(1, Integer.parseInt(semana));
            ps.setDate(2, Date.valueOf(fechainicio));
            ps.setDate(3, Date.valueOf(fechafin));
            ps.setInt(4, Integer.parseInt(anio));
            ps.setDouble(5, Double.parseDouble(textras));
            ps.setDouble(6,Double.parseDouble( t_desc));
            ps.setDouble(7, Double.parseDouble(total_nom));
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Nomina Ingresada", "La nomina ha sido registrada con exito", DesktopNotify.SUCCESS);
    }
     
     protected ResultSet consultar_id_nomina(){
         ResultSet rs=Read("select MAX(id_nomina_general) from nomina_general");
         return rs;
     }
     
     protected ResultSet consultar_id_nomina_individual(){
         ResultSet rs=Read("select MAX(id_nomina_individual) from nomina_individual");
         return rs;
     }
     
     
     protected void Insertar_nomina_individual_modelo(String id_empleado,String nominaGeneral,String total_indi){
          PreparedStatement ps = null;
     conn = GetConnection();
          try {
          ps = conn.prepareStatement("insert into nomina_individual(id_empleado,id_nomina_general,total_nom_ind)"
                    + "values(?,?,?)");
            ps.setString(1, id_empleado);
            ps.setString(2, nominaGeneral);
            ps.setString(3, total_indi);
             
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
          DesktopNotify.showDesktopMessage("Nomina Individual Ingresada", "La nomina individual ha sido registrada con exito", DesktopNotify.SUCCESS);
           
            
     }
//      protected void Insertar_n(String id_empleado,String nominaGeneral,String total_indi){
//          PreparedStatement ps = null;
//     conn = GetConnection();
//          try {
//          ps = conn.prepareStatement("insert into nomina_individual(id_empleado,id_nomina_general,total_nom_ind"
//                    + "values(?,?,?)");
//            ps.setString(1, id_empleado);
//            ps.setString(2, nominaGeneral);
//            ps.setString(3, total_indi);
//             
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//           
//            
//     }
        protected void NominaTotalProcedure(String id_empleado,String nominaGeneral,String total_indi, String dia1, String dia2, String dia3, String dia4, String dia5,
             String dia6, String dia7,String produ,String velada,String viaje,String domingo,String vacaciones,String extra,String retardo,String otro_desc,String pantalon,String infonavit) {
        PreparedStatement ps = null;
     conn = GetConnection();
        try {
            
            ps = conn.prepareStatement("call NominaIndividual(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
             ps.setString(1, id_empleado);
            ps.setInt(2, Integer.parseInt(nominaGeneral));
            ps.setString(3, total_indi);
            ps.setString(4, dia1);
            ps.setString(5, dia2);
            ps.setString(6, dia3);
            ps.setString(7, dia4);
            ps.setString(8, dia5);
            ps.setString(9, dia6);
            ps.setString(10, dia7);
            
            ps.setDouble(11, Double.parseDouble(produ));
            ps.setDouble(12, Double.parseDouble(velada));
            ps.setDouble(13, Double.parseDouble(viaje));
            ps.setDouble(14, Double.parseDouble(domingo));
            ps.setDouble(15, Double.parseDouble(vacaciones));
            ps.setDouble(16, Double.parseDouble(extra));
            ps.setDouble(17, Double.parseDouble(retardo));
          ps.setDouble(18, Double.parseDouble(otro_desc));
          ps.setDouble(19, Double.parseDouble(pantalon));
          ps.setDouble(20, Double.parseDouble(infonavit));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     
     protected void insertarAsistencia(String idnomina, String dia1, String dia2, String dia3, String dia4, String dia5,
             String dia6, String dia7) {
        PreparedStatement ps = null;
     conn = GetConnection();
        try {
            
            ps = conn.prepareStatement("insert into asistencia(id_nomina_individual,dia1,dia2,dia3,dia4,dia5,dia6,dia7)"
                    + "values(?,?,?,?,?,?,?,?)");
            ps.setString(1, idnomina);
            ps.setString(2, dia1);
            ps.setString(3, dia2);
            ps.setString(4, dia3);
            ps.setString(5, dia4);
            ps.setString(6, dia5);
            ps.setString(7, dia6);
            ps.setString(8, dia7);
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesktopNotify.showDesktopMessage("Asistencia Ingresada", "La asistencia ha sido registrada con exito", DesktopNotify.SUCCESS);
       
    }
         protected void insertar_descuentos(String idnomina, String id_descuento, Double cantidad) {
        PreparedStatement ps = null;
     conn = GetConnection();
        try {
            
            ps = conn.prepareStatement("insert into r_desc_nom_i(id_nomina_individual,id_descuento,cantidad)"
                    + "values(?,?,?)");
         ps.setInt(1, Integer.parseInt(idnomina));
            ps.setInt(2, Integer.parseInt(id_descuento));
            ps.setDouble(3,cantidad);
              
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }   
             protected void insertar_Extra(String idnomina, String id_extra,Double cantidad) {
        PreparedStatement ps = null;
     conn = GetConnection();
        try {
            
            ps = conn.prepareStatement("insert into r_extrasnom_i(id_nomina_individual,id_extras,cantidad)"
                    + "values(?,?,?)");
            ps.setInt(1, Integer.parseInt(idnomina));
            ps.setInt(2, Integer.parseInt(id_extra));
            ps.setDouble(3,cantidad);
              
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
       
        
}
