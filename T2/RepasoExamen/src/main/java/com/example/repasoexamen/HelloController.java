package com.example.repasoexamen;

import com.example.repasoexamen.model.Persona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button botonAceptar;

    @FXML
    private TextField textoNombre, textoApellido;

    @FXML
    private RadioButton radioHombre, radioMujer;

    @FXML
    private ChoiceBox<Persona> choice;
    
    @FXML
    private CheckBox checkDesayunado, checkComido;

    private ToggleGroup grupoRadios;
    private String nombre, apellido, sexo, comida;
    private ObservableList<Persona> listaPersonas;
    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioHombre,radioMujer);

        listaPersonas= FXCollections.observableArrayList();

    }


    private void acciones() {
        botonAceptar.setOnAction(new ManejoPulsaciones());

        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radioSeleccionado = (RadioButton) t1;
                sexo = radioSeleccionado.getText();
                //System.out.println(sexo);
            }
        });
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == botonAceptar){

            }
        }
    }
}