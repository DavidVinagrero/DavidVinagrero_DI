package model;

import java.util.ArrayList;

public class Empresa {

    //Variables
    private ArrayList<Trabajador> listaTrabajadores;
    private String CIF;
    private String nombre;
    private int resultadoVotos= 0;

    //Constructores
    public Empresa() {
    }

    public Empresa(String nombre, String CIF) {
        this.CIF = CIF;
        this.nombre = nombre;
        this.listaTrabajadores = new ArrayList<>();
    }

    //Funciones
    public void contratarTrabajador(Trabajador trabajador) {
        // una empresa solo puede contratar
        // trabajadores que no tenga ya
        // contratados solo pueden existir
        // trabajadores con diferentes nss o dni
        if (existeTrabajador(trabajador.getNSS()) == null) {
            listaTrabajadores.add(trabajador);
            System.out.println("Emplado añadido correctamente");
        }
    }

    // otra de las posibilidades de la empresa es la de
    // buscar un trabajador
    // y mostrar sus datos
    // para ello me pide el nss del que quiero mostrar
    // los datos
    public void buscarTrabajador(int nss) {
        if (existeTrabajador(nss) == null) {
            existeTrabajador(nss).mostrarDatos();
        } else {
            System.out.println("El número no existe");
        }
    }

    // listar trabajadores, pero se puede diferenciar
    // el tipo que se quiere
    // mostrar: asalariado, jefe autónomos, todos

    public void listarTrabajadores(String clase) {
        for (Trabajador item: listaTrabajadores) {
            if(item.getClass().getSimpleName().equalsIgnoreCase(clase)){
                item.mostrarDatos();
            } else {
                item.mostrarDatos();
            }
        }
    }

    private Trabajador existeTrabajador(int nss) {
        Trabajador existe = null;
        for (Trabajador item : listaTrabajadores) {
            if (item.getNSS() == nss) {
                System.out.println("El numero ya existe en la BBDD");
                existe = item;
                return item;
            }
        }

        return existe;
    }

    public void registrarVoto(Votante votante, int voto){
        resultadoVotos+= votante.votar(voto);
        // listaTrabajadores --> Personas
        // todos los votantes vote, aleatorio entre 1 y 10
    }

    //Getter y Setter
    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "listaTrabajadores=" + listaTrabajadores +
                ", CIF='" + CIF + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}