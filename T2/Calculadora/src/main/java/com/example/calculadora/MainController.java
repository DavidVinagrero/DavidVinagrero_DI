package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    // Variables
    @FXML
    private Button boton_cero, boton_uno, boton_dos, boton_tres, boton_cuatro, boton_cinco, boton_seis, boton_siete, boton_ocho, boton_nueve,
                   boton_sumar, boton_restar, boton_dividir, boton_multiplicar, boton_igual, boton_limpiar ;

    @FXML
    private Label etiqueta_resultado;

    // Funciones
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //etiqueta_resultado.setText("");
        acciones();
    }

    private void acciones() {
        boton_cero.setOnAction(new ManejoPulsaciones());
    }


    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == boton_cero) {

            }
        }
    }
}