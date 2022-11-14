package com.example.correccionexamen.model;

import java.util.ArrayList;

public class Pedido {

    // Variables
    private int id;
    private String nombre;
    private int telefono, precioTotal;
    private ArrayList<Pizza> listaPizzas;

    // Constructores
    public Pedido(int id, String nombre, int telefono, int precioTotal, ArrayList<?> listaPizzas) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.precioTotal = precioTotal;
        this.listaPizzas = new ArrayList<Pizza>();
    }

    // Mostrar datos
    @Override
    public String toString() {
        return getId() + " " + getNombre();
    }

    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Precio total: " + precioTotal);
        System.out.println("Las pizzas del pedido son:");
        for (Pizza item : listaPizzas) {
            item.mostrar

    // Getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ArrayList<?> getListaPizzas() {
        return listaPizzas;
    }

    public void setListaPizzas(ArrayList<Pizza> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }
}
