package com.example.t4_comunicaciones;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondController implements Initializable {

    @FXML
    private Label labelStage2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void comunicarDatos(String texto){
        labelStage2.setText(texto);
    }
}
