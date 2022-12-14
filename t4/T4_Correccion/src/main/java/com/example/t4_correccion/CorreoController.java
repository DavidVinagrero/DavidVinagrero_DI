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

public class CorreoController implements Initializable {

    @FXML
    private TextField editCorreo;

    @FXML
    private Button botonCorreo;

    private HelloController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonCorreo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                controller.setCorreo(editCorreo.getText());
                ((Stage) botonCorreo.getScene().getWindow()).close();
            }
        });
    }

    public void setController(HelloController controller) {
        this.controller = controller;
    }
}
