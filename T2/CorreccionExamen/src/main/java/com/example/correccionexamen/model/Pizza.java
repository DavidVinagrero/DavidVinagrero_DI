package com.example.correccionexamen.model;

public class Pizza {

    // Variables
    private String nombre;
    private int precio;

    // Constructores
    public Pizza(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Funciones
    public void mostrarDatos(){
        System.out.print("nombre: "+nombre);
        System.out.println("precio: "+precio);
    }

    // Getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
