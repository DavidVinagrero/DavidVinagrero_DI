package model;

public final class Jefe extends Trabajador{
    //Variables
    private char nivelResponsabilidad;

    //Constructores
    public Jefe(String nombre, String apellido, String dni, int NSS, char nivelResponsabilidad) {
        super(nombre, apellido, dni, NSS);
        this.nivelResponsabilidad= nivelResponsabilidad;
    }

    //Funciones
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Nivel de responsabilidad: "+nivelResponsabilidad);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calculando jubilación del jefe...");
        double jubilacion= 0.0;
        switch (nivelResponsabilidad){
            case 'A':
                jubilacion= 2000;
                break;
            case 'B':
                jubilacion= 1500;
                break;
            case 'C':
                jubilacion= 1250;
                break;
        }
        System.out.println("La jubilación resultante es "+jubilacion);
    }

    //Getter y Setter
    public char getNivelResponsabilidad() {
        return nivelResponsabilidad;
    }

    public void setNivelResponsabilidad(char nivelResponsabilidad) {
        this.nivelResponsabilidad = nivelResponsabilidad;
    }
}
