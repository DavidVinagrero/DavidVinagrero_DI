package com.example.davidvinagreroencina.module;

public class Persona {
    // Variables
    private String nombre;
    private int telefono;

    // Constructores
    public Persona(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }


    // Getter y setter
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
}
