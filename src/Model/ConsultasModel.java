/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;

/**
 *
 * @author Joel
 */
public class ConsultasModel extends DB.database{
    
    
    protected ResultSet consultar_antiguedad(){
        ResultSet rs= Read("select * from empleado ORDER by empleado.fecha_entrada DESC");
        return rs;
        
    }
    
    protected ResultSet Consultar_nominas(){
        ResultSet rs= Read("select * from nomina_general order by id_nomina");
        return rs;
    }
    protected ResultSet Consultar_nominas_individual(String id_nomina){
        ResultSet rs= Read("SELECT e.nombre, e.apellido_paterno, e.apellido_materno, e.gratificacion,"
                + " a.dia1, a.dia2, a.dia3, a.dia4, a.dia5, a.dia6, a.dia7, rdn.cantidad as descuento,"
                + " d.descripcion_descuento as tipo_descuento FROM empleado e INNER JOIN nomina_individual ni on ni.id_empleado"
                + " = e.id_empleado INNER JOIN asistencia a on a.id_asistencia = ni.id_asistencia INNER JOIN r_desc_nom_i rdn on "
                + "rdn.id_nomina_individual = ni.id_nomina_individual INNER JOIN descuento d on d.id_descuento = rdn.id_descuento");
        return rs;
    } 
        protected ResultSet Consultar_cumpleaños(String id_nomina){
        ResultSet rs= Read("SELECT e.id_empleado, e.nombre, e.apellido_paterno, e.apellido_materno, "
                + "concat(day(e.fecha_nacimiento),'-',Date_format(e.fecha_nacimiento, '%M'))"
                + " as fecha, c.descripcion_cargo, d.area FROM empleado e INNER JOIN cargo c on "
                + "c.id_cargo = e.id_cargo INNER JOIN departamento d on d.id_departamento = e.id_departamento");
        return rs;
    } 
    
    
}
