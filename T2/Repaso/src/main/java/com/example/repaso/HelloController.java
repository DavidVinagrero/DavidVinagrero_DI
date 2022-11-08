package com.example.repaso;

import com.example.repaso.modelo.Equipo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ImageView imagen;

    @FXML
    private RadioButton radio_rayo, radio_madrid, radio_atleti;

    private ToggleGroup grupoEquipos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        grupoEquipos.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                Equipo seleccionado = (Equipo) ((RadioButton)t1).getUserData();
                imagen.setImage(new Image(seleccionado.getImagen()));
            }
        });
    }

    private void instancias() {
        grupoEquipos = new ToggleGroup();
        grupoEquipos.getToggles().addAll(radio_rayo, radio_madrid, radio_atleti);
    }

    private void asociarDatos(){
        radio_rayo.setUserData(new Equipo(
                "Rayo Vallecano",
                "https://imgs.search.brave.com/W4Xxyx_CzwOacJH3TYfeDHxClKFgLUsSoGycFdQ-Kds/rs:fit:474:225:1/g:ce/aHR0cHM6Ly90c2Uy/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC5J/ampCN0Jxb0FIdzZE/NHB3bGhQcEVnSGFI/YSZwaWQ9QXBp",
                "Vallecas"));
        radio_madrid.setUserData(new Equipo(
                "Real Madrid",
                "https://imgs.search.brave.com/A60v1ycMHlEOx7WHsw-R66Z9wJk1u95qo28AO8_c5DE/rs:fit:339:225:1/g:ce/aHR0cHM6Ly90c2Uz/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC5l/ZEw5VUJuMEg2emVG/dHlDMjBudzF3SGFL/VyZwaWQ9QXBp",
                "Bernabeu"));
        radio_atleti.setUserData(new Equipo(
                "Atlético",
                "https://imgs.search.brave.com/lgEE6xNPrmHkRho_6DkTKxT6gG53JHOgwI6gU0eTtm4/rs:fit:341:225:1/g:ce/aHR0cHM6Ly90c2Ux/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC5P/X2l1X2hPSjNVSWx6/ZFU3alYyZHZRSGFL/UiZwaWQ9QXBp",
                "Metropolitano"));
    }
}