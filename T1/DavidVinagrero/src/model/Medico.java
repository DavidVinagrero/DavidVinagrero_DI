package model;

public class Medico extends Persona {
    //Variables
    private int numColegiado;
    private String especialidad;
    private int dia;
    private int mes;

    //Constructores
    public Medico(String nombre, String apellido, String dni, int numColegiado, String especialidad, int dia, int mes) {
        super(nombre, apellido, dni);
        this.numColegiado = numColegiado;
        this.especialidad = especialidad;
        this.dia = dia;
        this.mes = mes;
    }
}
