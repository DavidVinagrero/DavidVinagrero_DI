package com.example.t4_ejerciciojson;

import com.example.t4_ejerciciojson.model.Personaje;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TablaController implements Initializable {
    @FXML
    private TableColumn<?, ?> columnaFrase;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private Button botonVolver;

    @FXML
    private Label labelError;

    @FXML
    private TableView<Personaje> tabla;
    private ObservableList<Personaje> listaPersonajes;
    private MainController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        configurarTabla();

        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Cargar el fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main-view.fxml"));
                try {
                    Parent root = loader.load();
                    // Crear scene
                    Scene scene = new Scene(root,botonVolver.getScene().getWidth(),botonVolver.getScene().getHeight());
                    // En el stage poner la scene
                    Stage stage = (Stage) botonVolver.getScene().getWindow();
                    stage.setScene(scene);
                    MainController controller = loader.getController();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    private void instancias() {
        listaPersonajes = FXCollections.observableArrayList();

    }

    private void configurarTabla() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                                                                      //frase
        columnaFrase.setCellValueFactory(new PropertyValueFactory<>("fase"));
    }

    public void pasarDatosATabla(ObservableList<Personaje> listaTabla) {
        this.controller = controller;
        tabla.setItems(listaTabla);
        if (tabla.getItems().isEmpty()){
            labelError.setText("Parece que se te ha olvidado algo !!!");
        }
    }
}
