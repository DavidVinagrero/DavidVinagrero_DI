package com.example.t4_correccion;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NombreController implements Initializable {

    @FXML
    private Button botonNombre;

    @FXML
    private TextField editNombre;
    private  HelloController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonNombre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // darle los dato a la controladora uno
                controller.setNombre(editNombre.getText());
                // y cerrar ventan
                ((Stage)botonNombre.getScene().getWindow()).close();
            }
        });
    }

    public void setController(HelloController controller){
        this.controller = controller;
    }
}
