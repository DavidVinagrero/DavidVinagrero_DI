package model;

public class Accionista extends Persona implements Votante{
    // Variables
    private double porcentajeAcciones;

    //Constructores
    public Accionista(String nombre, String apellido, String dni, double porcentajeAcciones) {
        super(nombre, apellido, dni);
        this.porcentajeAcciones = porcentajeAcciones;
    }

    public Accionista(double porcentajeAcciones) {
        this.porcentajeAcciones = porcentajeAcciones;
    }

    //Funciones
    public void calcularJubilacion() {

    }

    //Métodos override
    @Override
    public int votar(int voto) {
        return 0;
    }

    //Getter y Setter
    public double getPorcentajeAcciones() {
        return porcentajeAcciones;
    }

    public void setPorcentajeAcciones(double porcentajeAcciones) {
        this.porcentajeAcciones = porcentajeAcciones;
    }

}
