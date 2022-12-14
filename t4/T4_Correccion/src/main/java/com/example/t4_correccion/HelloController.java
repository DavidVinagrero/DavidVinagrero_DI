package com.example.t4_correccion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HelloController implements Initializable {

    @FXML
    private Button botonCorreo;

    @FXML
    private Button botonDNI;

    @FXML
    private Button botonNombre;

    @FXML
    private Button botonTelefono;

    @FXML
    private TableColumn<?, ?> columnaCorreo;

    @FXML
    private TableColumn<?, ?> columnaDNI;

    @FXML
    private TableColumn<?, ?> columnaID;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private Label labelCorreo;

    @FXML
    private Label labelDNI;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelTelefono;

    @FXML
    private MenuItem menuAyuda;

    @FXML
    private MenuItem menuAñadir;

    @FXML
    private MenuItem menuBorrar;

    @FXML
    private MenuItem menuDNI;

    // La tabla debe tener una lista asociada
    @FXML
    private TableView<Usuario> tablaUsuarios;
    private ObservableList<Usuario> listaUsuarios;

    @FXML
    private MenuItem menuReset;

    @FXML
    private MenuItem menuSalir;

    private int id = 0;
    private FilteredList<Usuario> listaFiltrada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        configurarTabla();
        acciones();
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaFiltrada = new FilteredList<Usuario>(listaUsuarios);
    }

    private void configurarTabla() {
        // Añade el contenido que vaya a tener la lista a la tabla
        tablaUsuarios.setItems(listaFiltrada);
        // Mostrará en las columnas las variables del Usuario (deben tener el mimso nombre)
        columnaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaDNI.setCellValueFactory(new PropertyValueFactory<>("dni"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    }

    private void acciones() {
        botonNombre.setOnAction(new ManejoPulsaciones());
        menuSalir.setOnAction(new ManejoPulsaciones());
        botonCorreo.setOnAction(new ManejoPulsaciones());
        menuAñadir.setOnAction(new ManejoPulsaciones());
        menuBorrar.setOnAction(new ManejoPulsaciones());
        menuDNI.setOnAction(new ManejoPulsaciones());
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir) {
                System.exit(0);
            } else if (actionEvent.getSource() == botonNombre) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("nombre.fxml"));
                try {
                    Parent root = loader.load();
                    Stage ventana = new Stage();
                    Scene scene = new Scene(root, 400, 400);

                    NombreController nombreController = loader.getController();
                    nombreController.setController(HelloController.this);

                    ventana.setScene(scene);
                    ventana.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else if (actionEvent.getSource() == botonCorreo) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("correo.fxml"));

                try {
                    // Crear el parent
                    Parent root = loader.load();
                    // Crear la escena
                    Scene scene = new Scene(root, 400, 400);
                    // Crear la ventana
                    Stage stage = new Stage();

                    // Creo una clase de la controladora a la que quiero enviar
                    CorreoController controller = loader.getController();
                    // Le doy al controlador el controlador de esta escena
                    controller.setController(HelloController.this);

                    // Asignar la ventana a la escena
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {

                }

            } else if (actionEvent.getSource() == menuAñadir) {
                // TODO terminar todos los campos
                // TODO preguntar que todos los campos están rellenos

                Usuario usuario = new Usuario(id, labelNombre.getText(), labelCorreo.getText(), "1234B", 987);
                Usuario usuario2 = new Usuario(id, labelNombre.getText(), labelCorreo.getText(), "123454X", 987);
                listaUsuarios.add(usuario);
                listaUsuarios.add(usuario2);
                id++;
                limpiarTextos();

            } else if (actionEvent.getSource() == menuBorrar) {
                if (tablaUsuarios.getSelectionModel().getSelectedIndex() > -1) {
                    listaUsuarios.remove(tablaUsuarios.getSelectionModel().getSelectedIndex());
                }

            } else if (actionEvent.getSource() == menuDNI) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return false;
                    }
                });

            }
        }
    }

    public void limpiarTextos() {
        labelNombre.setText("");
        labelCorreo.setText("");
        labelDNI.setText("");
        labelTelefono.setText("");
    }

    public void setNombre(String nombre) {
        this.labelNombre.setText(nombre);

    }

    public void setCorreo(String correo) {
        this.labelCorreo.setText(correo);
    }
}
