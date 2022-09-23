package model;

public abstract class Trabajador extends Persona {
    //Variables
    protected final int NSS;


    //Getter y Setter
    public int getNSS() {
        return NSS;
    }


    //Constructores
    public Trabajador(String nombre, String apellido, String dni, int NSS) {
        super(nombre, apellido, dni);
        this.NSS = NSS;
    }


    //Funciones
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("NSS: "+NSS);
    }

    @Override
    public void calcularJubilacion() {

    }
}
