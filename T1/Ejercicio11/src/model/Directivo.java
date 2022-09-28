package model;

public class Directivo extends Persona implements Votante{
    //Variables
    private double procentajeAcciones, beneficios;

    //Constructores
    public Directivo(String nombre, String apellido, String dni, double procentajeAcciones, double beneficios) {
        super(nombre, apellido, dni);
        this.procentajeAcciones = procentajeAcciones;
        this.beneficios = beneficios;
    }

    public Directivo(double procentajeAcciones, double beneficios) {
        this.procentajeAcciones = procentajeAcciones;
        this.beneficios = beneficios;
    }

    //Funciones

    //Métodos override
    @Override
    public int votar(int voto) {
        return voto*2;
    }

    //Getter y setter
    public double getProcentajeAcciones() {
        return procentajeAcciones;
    }

    public void setProcentajeAcciones(double procentajeAcciones) {
        this.procentajeAcciones = procentajeAcciones;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }
}
