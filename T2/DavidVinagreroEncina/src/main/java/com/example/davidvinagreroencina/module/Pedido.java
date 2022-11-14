package com.example.davidvinagreroencina.module;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private String nombre, telefono;
    private ArrayList<String> listaPizzas;
    private int totalPrecio;
    private boolean entregado;

    public Pedido(int id, String nombre, String telefono, ArrayList<String> listaPizzas, int totalPrecio, boolean entregado) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.listaPizzas = listaPizzas;
        this.totalPrecio = totalPrecio;
        this.entregado = entregado;
    }

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<String> getListaPizzas() {
        return listaPizzas;
    }

    public void setListaPizzas(ArrayList<String> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }

    public int getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(int totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}
