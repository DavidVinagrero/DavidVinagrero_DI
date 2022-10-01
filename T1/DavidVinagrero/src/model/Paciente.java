package model;

public class Paciente extends Persona {
    //Variables
    private int nss;
    private CitaMedica cita;

    //Constructores
    public Paciente(String nombre, String apellido, String dni, int nss) {
        super(nombre, apellido, dni);
        this.nss = nss;
    }

    //Funciones
    public void mostrarDatos(){
        System.out.println("\nNombre: "+this.nombre);
        System.out.println("Apellido: "+this.apellido);
        System.out.println("DNI: "+this.dni);
        System.out.println("NSS: "+this.nss);
    }

    //Getter y setter
    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public CitaMedica getCita() {
        return cita;
    }

    public void setCita(CitaMedica cita) {
        this.cita = cita;
    }
}
