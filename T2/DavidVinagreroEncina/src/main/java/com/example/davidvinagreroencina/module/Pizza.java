package com.example.davidvinagreroencina.module;

public class Pizza {

    // Variables
    private String pizza;
    private int precio;

    // Constructores
    public Pizza(String pizza, int precio) {
        this.pizza = pizza;
        this.precio = precio;
    }

    // Getter y setter
    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
