import model.*;

import java.util.ArrayList;

public class MainTrabajadores {
    public static void main(String[] args) {
        //Variables
        Autonomo autonomo= new Autonomo("Pedro","Gómez","1234567A",1234,1000,10000);
        Asalariado asalariado= new Asalariado("Juan","García","1234567B",5678,15,600,3000);
        Asalariado asalariado2= new Asalariado("Juan","García","1234567B",5678,15,600,3000);
        Jefe jefe= new Jefe("Antonio","Hernández","123456C",7891,'B');
        Empresa empresa= new Empresa("Retamar","0001A");
        Directivo directivo= new Directivo("A","B","1234567A",12.8,33.3);
        Accionista accionista= new Accionista("A","B","123456D",23.9);

        empresa.contratarTrabajador(asalariado);
        empresa.contratarTrabajador(autonomo);
        empresa.contratarTrabajador(jefe);
        empresa.registrarVoto(accionista,2);
        empresa.registrarVoto(jefe,1);


        //Programa
        /*ArrayList<Trabajador> listaEmpresa= new ArrayList<>();
        listaEmpresa.add(autonomo);
        listaEmpresa.add(asalariado);
        listaEmpresa.add(jefe);

        for (Trabajador trabajador: listaEmpresa) {
            System.out.println("\nMostrando los datos del trabajador: ");
            trabajador.mostrarDatos();
            System.out.println("Calcular jubilación");
            trabajador.calcularJubilacion();

            if(trabajador instanceof Asalariado){
                ((Asalariado)trabajador).mostrarSueldoNeto(10);
            }
        }*/
    }
}
