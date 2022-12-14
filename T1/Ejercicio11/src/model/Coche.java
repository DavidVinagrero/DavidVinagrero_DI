package model;

import java.util.ArrayList;

public class Coche {
    //Propiedades
    private int cv, velocidad;
    private String matricula, modelo;
    private double km;


    //Constructores
    public Coche() {
        cv = 0;
        velocidad = 0;
        matricula = "0000AAA";
        modelo = "Sin especificar";
        km = 0.0;

        ArrayList<Coche> listaCoches= new ArrayList<>();
    }

    public Coche(int cv, String matricula, String modelo) {
        this.cv = cv;
        this.matricula = matricula;
        this.modelo = modelo;
    }

    //Métodos
    public void acelerarCoche(int velocidad) {
        this.velocidad = this.velocidad + velocidad;
        this.km = velocidad * ((cv) * Math.random() * 20+11);
        if (this.velocidad > 180) {
            this.velocidad = 180;
            System.out.println("El coche ha sobrepasado la velocidad máxima");
        }
    }

    public void frenarCoche(int velocidad) {
        this.velocidad -= velocidad;
        if (this.velocidad < 0) {
            this.velocidad = 0;
            System.out.println("Velocidad mínima alcanzada");
        }
    }

    public void reiniciarVelocidad() {
        this.velocidad = 0;
    }

    public void reiniciarVelocidadKilometros(){
        this.velocidad=0;
        this.km=0;
    }

    //Getter & Setter
    public int getCv() {
        return cv;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKm() {
        return km;
    }

    public void setCv(int cv) {
        this.cv = cv;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Matrícula: " +matricula+
                " Modelo: "+modelo+
                " CV: "+cv+
                " Velocidad: "+velocidad+
                " Kilómetros: "+km;
    }
}
