package model;

import org.w3c.dom.ls.LSOutput;

public class Persona {
    // Variables
    String nombre, dni, sexo;
    double peso, altura;
    int edad;

    // Constructores
    public Persona() {
        nombre = "defecto";
        dni = "defecto";
        sexo = "defecto";
        peso = 0.0;
        altura = 0.0;
        edad = 0;
    }

    public Persona(String nombre, String sexo, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        dni="defecto";
    }

    public Persona(String nombre, String sexo, double peso, double altura, int edad) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, String sexo, double peso, double altura, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
    }

    // Funciones
    public int calcularIMC(double peso, double altura){
        double resultado=0;

        resultado= (peso/(Math.pow(altura,2)));
        if(resultado<20){
            System.out.println("Estás por debajo de tu peso ideal");
            return -1;
        } if (resultado<=25 && resultado>=20) {
            System.out.println("Estas en tu peso ideal");
            return 0;
        } if (resultado>25) {
            System.out.println("Tienes sobrepeso");
            return 1;
        }
        return 0;

    }

    public boolean esMayorEdad(){
        if (edad>=18){
            return true;
        } else {
            return false;
        }
    }

    // Métodos override
    public void mostrarDatos(){
        System.out.println("\nNombre: "+nombre+
                "\nDNI: "+dni+
                "\nSexo: "+sexo+
                "\nPeso: "+peso+
                "\nAltura: "+altura+
                "\nEdad: "+edad);
    }

    // Gettre y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
