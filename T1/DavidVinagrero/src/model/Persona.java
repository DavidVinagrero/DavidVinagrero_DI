package model;

public abstract class Persona {
    //Variables
    public String nombre;
    public String apellido;
    public String dni;

    //Constructores
    public Persona() {
        nombre = "";
        apellido = "";
        dni = "";
    }

    public Persona(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    //Funciones
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + "\nApellido: " + apellido + "\ndni: " + dni);
    }
}
