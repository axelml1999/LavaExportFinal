/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ImportarnominaModel;

/**
 *
 * @author Joel
 */
public class ImportarnominaController  extends ImportarnominaModel{
   
    
    public void insertar_nomina(String idnomina, String semana, String anio, String fechainicio, String fechafin, String textras,
             String t_desc, String total_nom){
        insertarNomina(idnomina, semana, anio, fechainicio, fechafin, textras, t_desc, total_nom);
    }
}
