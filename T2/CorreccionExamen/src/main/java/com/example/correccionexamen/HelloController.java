package com.example.correccionexamen;

import com.example.correccionexamen.model.Pedido;
import com.example.correccionexamen.model.Pizza;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button botonAniadir;

    @FXML
    private Button botonEntregar;

    @FXML
    private Button botonFinalizar;

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoTelefono;

    @FXML
    private ComboBox<Pizza> choicePizza;
    private ObservableList<Pizza> pizzasDisponibles;

    @FXML
    private ListView<Pedido> listaPedidos;
    private ObservableList<Pedido> pedidosActuales;

    @FXML
    private ListView<Pizza> listaPizzas;
    private ObservableList<Pizza> pizzasPedidoActual;
    private int idPedido = 1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void instancias() {
        pizzasDisponibles = FXCollections.observableArrayList();
        pizzasDisponibles.addAll(
                new Pizza("Carbonara", 14),
                new Pizza("Cuatro quesos", 17),
                new Pizza("Jamón y queso", 10),
                new Pizza("Hawaiana", 12));

        pizzasPedidoActual = FXCollections.observableArrayList();
        pedidosActuales = FXCollections.observableArrayList();
    }

    private void asociarDatos() {
        choicePizza.setItems(pizzasDisponibles);
        listaPedidos.setItems(pedidosActuales);
        listaPizzas.setItems(pizzasPedidoActual);
    }

    private void acciones() {
        botonAniadir.setOnAction(new ManejoPulsaciones());
        botonEntregar.setOnAction(new ManejoPulsaciones());
        botonFinalizar.setOnAction(new ManejoPulsaciones());
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonAniadir) {
                // No añade null
                if (choicePizza.getSelectionModel().getSelectedIndex() >= 0) {
                    pizzasPedidoActual.add(choicePizza.getSelectionModel().getSelectedItem());
                }
            } else if (actionEvent.getSource() == botonFinalizar) {
                if (!campoTelefono.getText().isEmpty() && !campoNombre.getText().isEmpty() && pizzasPedidoActual.size() > 0) {
                    Pedido pedido = new Pedido(idPedido,campoNombre.getText(),Integer.valueOf(campoTelefono.getText()),);
                }

            } else if (actionEvent.getSource() == botonEntregar) {

            }
        }
    }
}