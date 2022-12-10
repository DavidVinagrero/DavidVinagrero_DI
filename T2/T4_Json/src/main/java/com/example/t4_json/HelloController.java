package com.example.t4_json;

import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button botonJSON;

    @FXML
    private Label etiquetaNombre, etiquetaCorreo, etiquetaTelefono, etiquetaDireccion;
    @FXML
    private ListView listaDatos;
    @FXML
    private Spinner spinner;
    @FXML
    private ComboBox combo;

    private ObservableList<String> listaGenero;
    private ObservableList<Integer> listaSpinner;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {
        listaGenero = FXCollections.observableArrayList();
        listaGenero.addAll("Hombre","Mujer","Todos");

        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
    }

    private void asociarDatos() {
        combo.setItems(listaGenero);
    }

    private void acciones() {

        botonJSON.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // peticion https
                // 1-URL
                // 2-Conexion por https
                // 3-Evaluar la respuesta
                // 4-String -> JSON
                String urlQuery = "https://randomuser.me/api/?results=5";
                try {
                    URL url = new URL(urlQuery);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedInputStream =
                            new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    //System.out.println(bufferedInputStream.readLine());

                    StringBuilder lectura = new StringBuilder();
                    String linea = null;
                    while ((linea = bufferedInputStream.readLine())!=null){
                        lectura.append(linea);
                    }
                    //System.out.println(lectura.toString());
                    JSONObject jsonGeneral = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = jsonGeneral.getJSONArray("results");
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        JSONObject resultadoUno = arrayResultados.getJSONObject(i);
                        JSONObject jsonNombre = resultadoUno.getJSONObject("name");
                        // resultadoUno.getJSONObject("name").getString("last");
                        String title = jsonNombre.getString("title");
                        String first = jsonNombre.getString("first");
                        String last = jsonNombre.getString("last");
                        System.out.printf("\n%s %s %s", title, first, last);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}