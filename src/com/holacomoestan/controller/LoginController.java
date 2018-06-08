package com.holacomoestan.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
public class LoginController implements Initializable {
    @FXML private TextField txtLogin;
    @FXML private PasswordField txtPassword;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    } 
    public void login(){
        if(txtPassword.getText().equals("admin123")){
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Bienvenido " + txtLogin.getText());
        }else{
            javax.swing.JOptionPane.showMessageDialog(null,
                    "No autorizado");
        }
    }
}
