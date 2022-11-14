package com.example.davidvinagreroencina;

import com.example.davidvinagreroencina.module.Pedido;
import com.example.davidvinagreroencina.module.Persona;
import com.example.davidvinagreroencina.module.Pizza;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import kotlin.text.MatchNamedGroupCollection;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button botonAniadir, botonFinalizar, botonEntregar;

    @FXML
    private TextField textoNombre, textoTelefono;

    @FXML
    private ListView cajaPizzas, cajaPedidos;

    @FXML
    private ComboBox combo;

    private ObservableList<String> listaPizzas;
    private String nombre, telefono, pizza, idSeleccionado;
    private int id, precio;
    private ArrayList<String> pedido = new ArrayList<>();
    private ArrayList<String> cabecera = new ArrayList<>();
    private int total = 0;
    private Pedido elPedido;
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        // Lista de las pizzas
        listaPizzas = FXCollections.observableArrayList();
        listaPizzas.addAll("Barbacoa", "Hawaiana",
                "Jamón y queso", "Cuatro quesos", "Carbonara");

        combo.setItems(listaPizzas);
    }

    private void acciones() {
        botonAniadir.setOnAction(new ManejoPulsaciones());
        botonEntregar.setOnAction(new ManejoPulsaciones());
        botonFinalizar.setOnAction(new ManejoPulsaciones());

        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue,
                                String oldValue, String newValue) {
                pizza = newValue;
            }
        });

        cajaPedidos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               idSeleccionado = newValue.toString();
               // ID del pedido
               idSeleccionado = idSeleccionado.replaceAll( "- "+nombre,"");
                System.out.println(idSeleccionado);
            }
        });
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            // Boton añadir pizzas a la primera lisview
            if (actionEvent.getSource() == botonAniadir) {

                if (validarCampos()) {
                    nombre = textoNombre.getText();
                    telefono = textoTelefono.getText();
                    //System.out.println("Nombre: "+nombre+"\nTeléfono: "+telefono+"\nPizza: "+pizza);

                    switch (pizza) {

                        case "Barbacoa":
                            System.out.println("Barbacoa");
                            precio = 12;
                            total = total + precio;
                            break;

                        case "Hawaiana":
                            precio = 10;
                            total = total + precio;
                            break;

                        case "Jamón y queso":
                            precio = 10;
                            total = total + precio;


                        case "Cuatro quesos":
                            precio = 17;
                            total = total + precio;
                            break;

                        case "Carbonara":
                            precio = 14;
                            total = total + precio;
                            break;
                    }

                    pedido.add(pizza + " , " + precio + "€");
                    aniadirPizzas();
                    System.out.println("Total: " + total);

                }
            } else if (actionEvent.getSource() == botonFinalizar) {
                id++;
                elPedido = new Pedido(id, nombre, telefono, pedido, total, false);
                cabecera.add(id + " - " + nombre);

                ObservableList pedidosListView = FXCollections.observableArrayList();
                pedidosListView.addAll(cabecera);

                cajaPedidos.setItems(pedidosListView);

                textoTelefono.setText("");
                textoNombre.setText("");



            }
        }

        private void aniadirPizzas() {
            ObservableList listaListView = FXCollections.observableArrayList();
            listaListView.addAll(pedido);

            cajaPizzas.setItems(listaListView);
        }

        private boolean validarCampos() {
            if (textoNombre.getText().equals("") || textoTelefono.getText().equals("") || combo.getSelectionModel().equals(""))
                return false;

            return true;
        }
    }
}