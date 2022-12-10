package com.example.t4_comunicaciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable {
    @FXML
    private Button botonVolvel;

    @FXML
    private Label labelScene2;

    @FXML
    private TextField textFieldScene2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    public void comunicarTexto(String texto){
        labelScene2.setText(texto);
    }

    private void acciones() {

        botonVolvel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("principal-view.fxml"));
                try {
                    Parent root = loader.load();
                    Scene scene = new Scene(root, botonVolvel.getScene().getWidth(), botonVolvel.getScene().getHeight());
                    Stage stage = (Stage) botonVolvel.getScene().getWindow();
                    stage.setScene(scene);

                    MainController controller = loader.getController();
                    controller.comunicarTexto(textFieldScene2.getText());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
