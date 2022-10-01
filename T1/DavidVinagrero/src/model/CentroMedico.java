package model;

import java.util.ArrayList;
import java.util.Scanner;

public class CentroMedico {
    //Variables
    public String nombre;
    private ArrayList<Paciente> pacientes= new ArrayList<Paciente>();
    private ArrayList<Medico> medicos= new ArrayList<Medico>();
    private ArrayList<CitaMedica> citas= new ArrayList<CitaMedica>();
    private Paciente cliente;
    private CitaMedica cita;
    Scanner scanner = new Scanner(System.in);

    //Constructores
    public CentroMedico(String nombre) {
        this.nombre = nombre;
    }
    //Funciones
    public void registrarPaciente(Paciente paciente){
        pacientes.add(paciente);
    }

    public void pedirCitas(){


    }

    public void mostrarPacientes(){
        for (Paciente p:pacientes) {
            p.mostrarDatos();
        }
    }
}
