package com.example.repasoexamen.model;

public class Persona {
    // Variables
    private String nombre, apellido, sexo, comida;

    // Constructor
    public Persona(String nombre, String apellido, String sexo, String comida) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.comida = comida;
    }


    // Getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }
}
