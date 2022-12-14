package com.example.t4_ejerciciojson.model;

public class Personaje {

    public String fase, nombre, imagen;

    public Personaje(String fase, String nombre, String imagen) {
        this.fase = fase;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return fase;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
