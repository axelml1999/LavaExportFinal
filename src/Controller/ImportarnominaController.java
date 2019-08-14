/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ImportarnominaModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel
 */
public class ImportarnominaController  extends ImportarnominaModel{
   ExtrasController ex =new ExtrasController();
   DescuentoController dc=new  DescuentoController();
   
    
    public int insertar_nomina(String semana, String anio, String fechainicio, String fechafin, String textras,
             String t_desc, String total_nom){
        insertarNomina( semana, anio, fechainicio, fechafin, textras, t_desc, total_nom);
   int id_nomina=0; 
        ResultSet rs=consultar_id_nomina();
        try {
            while(rs.next()){
                id_nomina=rs.getInt(1);
            }       } catch (SQLException ex) {
            Logger.getLogger(ImportarnominaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_nomina;
    }
    public int insertar_nomina_individual(String id_empleado,String nominaGeneral,String total_indi){
        Insertar_nomina_individual_modelo(id_empleado, nominaGeneral, total_indi);
        
        ResultSet rs=consultar_id_nomina_individual();
     int id_nomina_individual=0;
        try {
            while(rs.next()){
                id_nomina_individual=rs.getInt(1);
            }  } catch (SQLException ex) {
            Logger.getLogger(ImportarnominaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    return id_nomina_individual;
    }
 public void insertar_asistencias(String idnomina, String dia1, String dia2, String dia3, String dia4, String dia5,
             String dia6, String dia7){
     insertarAsistencia(idnomina, dia1, dia2, dia3, dia4, dia5, dia6, dia7);
     
      }
 
 public void Inserta_extra_individual(String id_nomina,Double cantidad,String id_extra){
     
     
     String valor=ex.consultar_id(id_extra);
   
     insertar_Extra(id_nomina, valor, cantidad);
      
     
    }
 public void Inserta_descuento_individual(String id_nomina,Double cantidad,String id_descuento){
     
   
     String valor=dc.consultar_descripcion(id_descuento);
   
     insertar_descuentos(id_nomina, valor, cantidad);
      
 
    }
}
