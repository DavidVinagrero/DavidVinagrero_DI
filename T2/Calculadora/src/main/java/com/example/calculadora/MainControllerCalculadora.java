package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.spreadsheet.Grid;

import java.net.URL;
import java.util.ResourceBundle;

public class MainControllerCalculadora implements Initializable {
    @FXML
    private Button boton_cero, boton_uno, boton_dos, boton_tres, boton_cuatro, boton_cinco, boton_seis, boton_siete, boton_ocho, boton_nueve,
            boton_coma, boton_e;

    @FXML
    private Button boton_sumar, boton_restar, boton_registro, boton_igual, boton_multiplicar, boton_dividir, boton_ocultar, boton_cientifica,
            boton_limpiar, boton_porcentaje;

    @FXML
    private GridPane panel_visible;

    @FXML
    private BorderPane panel_general;

    @FXML
    private Label etiqueta_resultado;

    @FXML
    private TextArea text_registro;

    private double operando1 = 0.0;
    private double operando2 = 0.0;
    private int tipoOperacion = 0;
    private double resultado = 0.0;
    private String aux = "";
    private Boolean pulsado_registro = false;
    private Boolean pulsado_cientifica = false;
    private Boolean pulsado_coma = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initGUI();
        acciones();
    }

    private void acciones() {
        boton_cientifica.setOnAction(new ManejoPulsaciones());
        boton_ocultar.setOnAction(new ManejoPulsaciones());
        boton_limpiar.setOnAction(new ManejoPulsaciones());
        boton_sumar.setOnAction(new ManejoPulsaciones());
        boton_igual.setOnAction(new ManejoPulsaciones());
        boton_dividir.setOnAction(new ManejoPulsaciones());
        boton_multiplicar.setOnAction(new ManejoPulsaciones());
        boton_registro.setOnAction(new ManejoPulsaciones());
        boton_porcentaje.setOnAction(new ManejoPulsaciones());
        boton_restar.setOnAction(new ManejoPulsaciones());

        boton_cero.setOnAction(new ManejoPulsaciones());
        boton_uno.setOnAction(new ManejoPulsaciones());
        boton_dos.setOnAction(new ManejoPulsaciones());
        boton_tres.setOnAction(new ManejoPulsaciones());
        boton_cuatro.setOnAction(new ManejoPulsaciones());
        boton_cinco.setOnAction(new ManejoPulsaciones());
        boton_seis.setOnAction(new ManejoPulsaciones());
        boton_siete.setOnAction(new ManejoPulsaciones());
        boton_ocho.setOnAction(new ManejoPulsaciones());
        boton_nueve.setOnAction(new ManejoPulsaciones());
        boton_coma.setOnAction(new ManejoPulsaciones());
        boton_e.setOnAction(new ManejoPulsaciones());
    }

    private void initGUI() {

        panel_general.getChildren().remove(panel_visible);
        panel_general.getChildren().remove(text_registro);
    }

    private class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            // Transformar el número del boton a string y lo introduce en la etiqueta
            Button boton1 = (Button) actionEvent.getSource();
            etiqueta_resultado.setText(etiqueta_resultado.getText() + boton1.getText());

            if (actionEvent.getSource() == boton_cientifica) {
                if (!pulsado_cientifica) {
                    eliminarCientifico();
                    panel_general.setLeft(panel_visible);
                    pulsado_cientifica = true;

                } else if (pulsado_cientifica) {
                    eliminarCientifico();
                    panel_general.getChildren().remove(panel_visible);
                    pulsado_cientifica = false;
                }

            } else if (actionEvent.getSource() == boton_registro) {
                if (!pulsado_registro) {
                    eliminarRegistro();
                    panel_general.setRight(text_registro);
                    pulsado_registro = true;
                } else if (pulsado_registro) {
                    eliminarRegistro();
                    panel_general.getChildren().remove(text_registro);
                    pulsado_registro = false;
                }


            } else if (actionEvent.getSource() == boton_ocultar) {
                // Eliminar la palabra >> si la etiqueta está vacía
                if (etiqueta_resultado.getText().equals("")) {
                    etiqueta_resultado.setText("");
                } else {
                    // Recoge lo que hay en la etiqueta excepto la palabra
                    aux = etiqueta_resultado.getText().replaceAll("[>>]", "");
                    etiqueta_resultado.setText(aux);
                }
                panel_general.getChildren().remove(panel_visible);

            } else if (actionEvent.getSource() == boton_limpiar) {
                etiqueta_resultado.setText("");

            } else if (actionEvent.getSource() == boton_e) {
                if (etiqueta_resultado.getText().equals("")) {
                    etiqueta_resultado.setText("");
                } else {
                    aux = etiqueta_resultado.getText().replaceAll("[E]", "");

                    etiqueta_resultado.setText(aux + "2.71828");
                }

            } else if (actionEvent.getSource() == boton_sumar) {
                if (tipoOperacion == 0) {
                    // Pasa todos los números de la etiqueta y los añade a la variable quitando el signo
                    operando1 = Double.parseDouble(etiqueta_resultado.getText().replaceAll("[+]", ""));
                    setOperacion(1);
                    etiqueta_resultado.setText("");
                    // Comprobar por la terminal los valores
                    System.out.println("Operando 1 = " + operando1 + "\nTipo operacion = " + tipoOperacion);
                }

            } else if (actionEvent.getSource() == boton_restar) {
                if (tipoOperacion == 0) {
                    operando1 = Double.parseDouble(etiqueta_resultado.getText().replaceAll("[-]", ""));
                    setOperacion(2);
                    etiqueta_resultado.setText("");
                    System.out.println("Operando 1 = " + operando1 + "\nTipo operacion = " + tipoOperacion);
                }

            } else if (actionEvent.getSource() == boton_multiplicar) {
                if (tipoOperacion == 0) {
                    operando1 = Double.parseDouble(etiqueta_resultado.getText().replaceAll("[x]", ""));
                    setOperacion(3);
                    etiqueta_resultado.setText("");
                    System.out.println("Operando 1 = " + operando1 + "\nTipo operacion = " + tipoOperacion);
                }

            } else if (actionEvent.getSource() == boton_dividir) {
                if (tipoOperacion == 0) {
                    operando1 = Double.parseDouble(etiqueta_resultado.getText().replaceAll("[÷]", ""));
                    setOperacion(4);
                    etiqueta_resultado.setText("");
                    System.out.println("Operando 1 = " + operando1 + "\nTipo operacion = " + tipoOperacion);
                }

            } else if (actionEvent.getSource() == boton_porcentaje) {
                if (tipoOperacion <= 3 || tipoOperacion >= 0) {
                    operando2 = Double.parseDouble(etiqueta_resultado.getText().replaceAll("[%]", ""));
                    Double porcentaje = (operando1 * 100) / operando2;
                    switch (tipoOperacion) {
                        case 1:
                            // Calcula el aumento
                            porcentaje += operando1;
                            etiqueta_resultado.setText(porcentaje + "");
                            reiniciarValores();
                            break;

                        case 2:
                            // Calcula el descuento
                            porcentaje -= operando1;
                            etiqueta_resultado.setText(((porcentaje * 100.0) / 100.0) + "");
                            reiniciarValores();
                            break;
                    }
                }
            } else if (actionEvent.getSource() == boton_coma) {
                if (!pulsado_coma) {
                    pulsado_coma = true;
                } else if (pulsado_coma) {
                    if (etiqueta_resultado.getText().equals("")) {
                        etiqueta_resultado.setText("");
                    } else {
                        aux = etiqueta_resultado.getText().replaceAll("[.]", "");
                        // Como la elimina y luego no deja volver a añadir la pongo al final del número
                        etiqueta_resultado.setText(aux + ".");
                    }
                }

            } else if (actionEvent.getSource() == boton_igual) {
                if (tipoOperacion != 0) {
                    operando2 = Double.parseDouble(etiqueta_resultado.getText().replaceAll("[=]", ""));

                    // Calcular tipo de operacion
                    switch (tipoOperacion) {
                        case 1:
                            resultado = operando1 + operando2;
                            System.out.println("Operando 2 = " + operando2);
                            System.out.println("Resultado = " + resultado);
                            etiqueta_resultado.setText("" + ((int) resultado));
                            text_registro.appendText("" + (operando1) + " + " + (operando2) + "\n=" + Math.round(resultado * 100.0) / 100.0);
                            reiniciarValores();
                            break;

                        case 2:
                            resultado = operando1 - operando2;
                            System.out.println("Resultado = " + resultado);
                            etiqueta_resultado.setText("" + ((int) resultado));
                            break;

                        case 3:
                            resultado = operando1 * operando2;
                            System.out.println("Resultado = " + resultado);
                            etiqueta_resultado.setText("" + ((int) resultado));
                            break;

                        case 4:
                            resultado = operando1 / operando2;
                            System.out.println("Resultado = " + resultado);
                            etiqueta_resultado.setText("" + resultado);
                            break;


                    }


                }
            }


        }

        private void reiniciarValores() {
            //Reiniciar los valores
            tipoOperacion = 0;
            operando1 = 0.0;
            operando2 = 0.0;
            aux = "";
            resultado = 0.0;
            pulsado_coma = false;
        }

        private void eliminarRegistro() {
            if (etiqueta_resultado.getText().equals("")) {
                etiqueta_resultado.setText("");
            } else {
                // Recoge lo que hay en la etiqueta excepto la palabra
                aux = etiqueta_resultado.getText().replaceAll("[Registro]", "");
                etiqueta_resultado.setText(aux);
            }
        }

        private void eliminarCientifico() {
            if (etiqueta_resultado.getText().equals("")) {
                etiqueta_resultado.setText("");
            } else {
                // Recoge lo que hay en la etiqueta excepto la palabra
                aux = etiqueta_resultado.getText().replaceAll("[SCI]", "");
                etiqueta_resultado.setText(aux);
            }
        }

        private void setOperacion(int i) {
            /*
             Tipos operacion
             0 -> Nulo
             1 -> Suma
             2 -> Resta
             3 -> Multiplicacion
             4 -> Division
             */
            tipoOperacion = i;
        }
    }
}