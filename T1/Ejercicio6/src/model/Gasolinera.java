package model;

import java.util.ArrayList;

public class Gasolinera {
    // Variables
    String nombre;
    ArrayList<Surtidor> listaSurtidores = new ArrayList<>();
    int ganancias;

    // Constructores
    public Gasolinera(String nombre) {
        this.nombre = nombre;
        listaSurtidores = new ArrayList<>();
        ganancias = 0;
    }

    // Funciones
    public void agregarSurtidor(Surtidor surtidor) {
        listaSurtidores.add(surtidor);
    }

    public int obtenerGanancias() {
        return ganancias;
    }

    // Getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Surtidor> getListaSurtidores() {
        return listaSurtidores;
    }

    public void setListaSurtidores(ArrayList<Surtidor> listaSurtidores) {
        this.listaSurtidores = listaSurtidores;
    }

    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }
}

