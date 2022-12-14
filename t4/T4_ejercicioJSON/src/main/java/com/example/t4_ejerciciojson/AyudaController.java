package com.example.t4_ejerciciojson;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.IdentityHashMap;
import java.util.ResourceBundle;

public class AyudaController implements Initializable {
    @FXML
    private ImageView imagen;
    @FXML
    private Button botonVolver;
    private MainController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imagen.setImage(new Image("https://media.revistagq.com/photos/6159fff48af7075628780553/master/pass/homher-flnaders.png"));
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage)botonVolver.getScene().getWindow()).close();
            }
        });
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }
}
