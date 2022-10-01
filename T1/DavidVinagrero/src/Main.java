import model.CentroMedico;
import model.CitaMedica;
import model.Medico;
import model.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Medico medico= new Medico("Nick","Rivera","1234567A",011,"Traumatologia",13,6);
        CentroMedico centro= new CentroMedico("A");
        Paciente paciente1;
        CitaMedica citaMedica;
        int opcion=0;
        Scanner scanner = new Scanner(System.in);

        //Programa
        do{
            System.out.println("\n1. Registrar paciente");
            System.out.println("2. Mostrar pacientes");
            opcion= scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("\nNombre:");
                    String Name= scanner.nextLine();
                    System.out.println("Apellido:");
                    String apellido= scanner.nextLine();
                    System.out.println("DNI:");
                    String dni=scanner.nextLine();
                    System.out.println("NSS:");
                    int nss= scanner.nextInt();
                    paciente1= new Paciente(Name,apellido,dni,nss);
                    centro.registrarPaciente(paciente1);
                    break;
                case 2:
                    System.out.println("\nIntroduce el NSS:");
                    int NSS= scanner.nextInt();
                    System.out.println("Introduce la especialidad");
                    String especialidad= scanner.nextLine();
                    System.out.println("Introduce el nº del doctor");
                    int numColelg= scanner.nextInt();
                    System.out.println("Introduce el día");
                    int dia= scanner.nextInt();
                    System.out.println("Introduce el mes");
                    int mes= scanner.nextInt();
                    //CitaMedica= new CitaMedica(NSS,especialidad,numColelg,dia,mes);
                    break;
            }

        }while (opcion!=3);
    }
}
