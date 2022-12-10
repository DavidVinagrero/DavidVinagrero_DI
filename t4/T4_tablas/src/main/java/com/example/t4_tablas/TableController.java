package com.example.t4_tablas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class TableController implements Initializable {

    @FXML
    private Button botonAniadir, botonEliminar, botonDetalle;
    @FXML
    private TableColumn columnaApellido;

    @FXML
    private TableColumn columnaCorreo;

    @FXML
    private TableColumn columnaNombre;

    @FXML
    private TableColumn columnaTelefono;

    @FXML
    private TextField textoFiltrar;
    @FXML
    private TableView<Usuario> tabla;
    private ObservableList<Usuario> listaUsuarios;
    private FilteredList<Usuario> listaFiltrada;

    private Usuario usuarioSeleccionado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(new Usuario("Juanito","Martín","correo@ejemplo.es","123456A",654321234));
        listaUsuarios.addAll(new Usuario("Celia","Smith","correo@ejemplo.es","878263H",656534534));
        listaUsuarios.addAll(new Usuario("Pedro","García","correo@ejemplo.es","129342687B",654345634));

        listaFiltrada = new FilteredList(listaUsuarios);
    }

    private void asociarDatos() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        columnaTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
        tabla.setItems(listaFiltrada);
    }

    private void acciones() {

        textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                listaFiltrada.setPredicate(new Predicate<Usuario>() {
                    @Override
                    public boolean test(Usuario usuario) {
                        return usuario.getNombre().contains(t1);
                    }
                });
            }
        });

        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario t1) {
                //System.out.println(t1);
                usuarioSeleccionado = t1;
            }
        });

        botonAniadir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(usuarioSeleccionado != null)
                    listaUsuarios.add(usuarioSeleccionado);
            }
        });

        botonEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(usuarioSeleccionado != null)
                    listaUsuarios.remove(usuarioSeleccionado);
            }
        });

        botonDetalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(usuarioSeleccionado != null)
                    System.out.println(usuarioSeleccionado);
            }
        });
    }
}
