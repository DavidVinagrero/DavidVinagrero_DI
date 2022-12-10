package com.example.t4_usuarios;

import com.example.t4_usuarios.model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button botonFiltrar;

    @FXML
    private ComboBox<String> comboGenero;
    private ObservableList<String> listaGeneros;
    @FXML
    private ImageView imagenPerfil;

    @FXML
    private Label labelApellido;

    @FXML
    private Label labelCorreo;

    @FXML
    private Label labelDireccion;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelTelefono;

    @FXML
    private ListView<Usuario> listaResultados;
    private ObservableList<Usuario> listaUsuarios;
    @FXML
    private Spinner<Integer> spinnerNumero;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {
        listaGeneros = FXCollections.observableArrayList();
        listaGeneros.addAll("Todos", "male", "female");

        listaUsuarios = FXCollections.observableArrayList();
    }

    private void asociarDatos() {
        comboGenero.setItems(listaGeneros);

        // Rellenar el Spinner con 0..100 ints
        spinnerNumero.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100));
    }

    private void acciones() {
        botonFiltrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String urlBase = "https://randomuser.me/api/?results=%s&gender=%s";
                try {
                    URL url = new URL(String.format(urlBase, String.valueOf(spinnerNumero.getValue()), comboGenero.getValue()));
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder lectura = new StringBuilder();
                    String linea = null;
                    while ((linea = bufferedReader.readLine()) != null) {
                        lectura.append(linea);
                    }
                    JSONObject objetoResultado = new JSONObject(lectura.toString());
                    JSONArray arrayResultados = objetoResultado.getJSONArray("results");
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        String titulo = arrayResultados.getJSONObject(i).getJSONObject("name").getString("title");
                        String nombre = arrayResultados.getJSONObject(i).getJSONObject("name").getString("first");
                        String apellido = arrayResultados.getJSONObject(i).getJSONObject("name").getString("last");
                        String correo = arrayResultados.getJSONObject(i).getString("email");
                        String telefono = arrayResultados.getJSONObject(i).getString("phone");
                        String imagen = arrayResultados.getJSONObject(i).getJSONObject("picture").getString("large");
                        String direccion = arrayResultados.getJSONObject(i).getJSONObject("location").getString("country");
                        System.out.println(nombre);
                        listaUsuarios.add(new Usuario(nombre,apellido,direccion,telefono,imagen,correo,titulo));
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        listaResultados.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario t1) {
                labelNombre.setText(t1.getNombre());
                labelApellido.setText(t1.getApellido());
                labelCorreo.setText(t1.getCorreo());
                labelDireccion.setText(t1.getDireccion());
                labelTelefono.setText(t1.getTelefono());
                imagenPerfil.setImage(new Image(t1.getImagen()));
            }
        });
    }

}