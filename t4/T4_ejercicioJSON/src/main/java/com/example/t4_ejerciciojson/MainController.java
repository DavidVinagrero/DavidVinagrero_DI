package com.example.t4_ejerciciojson;

import com.example.t4_ejerciciojson.model.Personaje;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    @FXML
    private Button botonGenerar;

    @FXML
    private ComboBox<String> comboHistorial;
    private ObservableList<Personaje> listaPersonajes;
    private ObservableList<String> historialCombo;
    private ObservableList<Personaje> listaTabla;
    @FXML
    private ImageView imagenPersonaje;

    @FXML
    private Label labelFrase, labelNombre;

    @FXML
    private ListView<Personaje> listaFrases;

    @FXML
    private MenuItem menuAyuda, menuSalir, menuHistorial, menuBorrarHistorial;

    @FXML
    private RadioButton radioConImagen, radioSinImagen;
    private ToggleGroup grupoRadios;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private TextField editNombre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioConImagen, radioSinImagen);

        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));

        listaPersonajes = FXCollections.observableArrayList();
        historialCombo = FXCollections.observableArrayList();
        listaTabla = FXCollections.observableArrayList();

    }

    private void acciones() {
        radioConImagen.setSelected(true);

        // Menús
        menuSalir.setOnAction(new ManejoPulsaciones());
        menuAyuda.setOnAction(new ManejoPulsaciones());
        menuHistorial.setOnAction(new ManejoPulsaciones());
        menuBorrarHistorial.setOnAction(new ManejoPulsaciones());


        botonGenerar.setOnAction(new ManejoPulsaciones());
        listaFrases.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Personaje>() {
            @Override
            public void changed(ObservableValue<? extends Personaje> observableValue, Personaje personaje, Personaje t1) {
                labelNombre.setText(t1.getNombre());
                labelFrase.setText(t1.getFase());
                Set<String> miSet = new HashSet<>(historialCombo);

                if (radioConImagen.isSelected()) {
                    imagenPersonaje.setImage(new Image(t1.getImagen()));
                } else {
                    imagenPersonaje.setImage(new Image(getClass().getResourceAsStream("/images/fondo.png")));
                }

                listaTabla.add(new Personaje(t1.getFase(), t1.getNombre(), t1.getImagen()));
                historialCombo.add(t1.getNombre());
                comboHistorial.setItems(historialCombo);
            }
        });

    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == menuSalir) {
                System.exit(0);
            } else if (actionEvent.getSource() == menuAyuda) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ayuda.fxml"));
                try {
                    Parent root = loader.load();
                    Stage ventana = new Stage();
                    ventana.setTitle("Ayuda");
                    Scene scene = new Scene(root, 650, 400);

                    AyudaController ayudaController = loader.getController();
                    ayudaController.setController(MainController.this);

                    ventana.setScene(scene);
                    ventana.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (actionEvent.getSource() == menuHistorial) {
                // Cargar el fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tabla.fxml"));
                try {
                    Parent root = loader.load();
                    // Crear scene
                    Scene scene = new Scene(root,botonGenerar.getScene().getWidth(),botonGenerar.getScene().getHeight());
                    // En el stage poner la scene
                    Stage stage = (Stage) botonGenerar.getScene().getWindow();
                    stage.setScene(scene);
                    TablaController controller = loader.getController();
                    controller.pasarDatosATabla(listaTabla);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else if (actionEvent.getSource() == menuBorrarHistorial) {
                historialCombo.clear();
                comboHistorial.setItems(historialCombo);
            } else if (actionEvent.getSource() == botonGenerar) {
                // peticion https
                // 1-URL
                // 2-Conexion por https
                // 3-Evaluar la respuesta
                // 4-String -> JSON
                String urlQuery = "https://thesimpsonsquoteapi.glitch.me/quotes?count=" + spinner.getValue();
                String personajeCombo = "";

                // Si el combo está seleccionado pero no hay nada escrito
                if (comboHistorial.getSelectionModel().getSelectedItem() != null && editNombre.getText().equals("")) {
                    String array[] = comboHistorial.getSelectionModel().getSelectedItem().toString().split(" ", 2);
                    urlQuery += "&character=" + array[0].toLowerCase();
                    //System.out.println("\n\nEsta es la url "+urlQuery+"\n\n"

                // Si el combo no está seleccionado pero si se ha escito algo
                } else if (comboHistorial.getSelectionModel().getSelectedItem() == null && !editNombre.getText().equals("")) {
                    urlQuery += "&character=" + editNombre.getText().toLowerCase();
                // Si el combo está seleccionado y hay algo escrito
                } else if (comboHistorial.getSelectionModel().getSelectedItem() != null && !editNombre.getText().equals("")) {
                    urlQuery += "&character=" + editNombre.getText().toLowerCase();
                }
                URL url = null;
                try {
                    url = new URL(urlQuery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    StringBuilder lectura = new StringBuilder();
                    String linea = null;
                    while ((linea = bufferedInputStream.readLine()) != null) {
                        lectura.append(linea);
                    }

                    //JSONObject jsonGeneral = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = new JSONArray(lectura.toString());
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        JSONObject resultadoUno = arrayResultados.getJSONObject(i);
                        String frase = resultadoUno.getString("quote");
                        String nombre = resultadoUno.getString("character");
                        String imagen = resultadoUno.getString("image");

                        listaPersonajes.add(new Personaje(frase, nombre, imagen));
                        System.out.printf("\n%s: %s %s", nombre, frase, imagen);
                    }

                    listaFrases.setItems(listaPersonajes);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
