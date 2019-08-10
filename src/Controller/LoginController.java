/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoginModel;

/**
 *
 * @author axeli
 */
public class LoginController extends LoginModel {

    public String autenticacion(String User, String pass) {
        String valor = "V";
        String user = validarUsuario(User, pass);
        if (user.equals("")) {
            valor = "F";
        }
        return valor;
    }

}
