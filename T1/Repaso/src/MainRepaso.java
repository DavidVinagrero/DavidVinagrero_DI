import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class MainRepaso {
    /*
            // Variables (propiedades,atributos)

            // Constructores

            // Métodos

            // Getter & setter

            // toString


    */
    public static void main(String[] args) {
        int[] elementos =new int [50];
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("\nRellenar 1\n"+
                    "Listar   2\n"+
                    "Ordenar  3\n"+
                    "Vaciar   4\n"+
                    "Salir    5\n"+
                    "Opción: ");
            opcion= scanner.nextInt();

            switch (opcion){
                case 1:
                    for (int i=0;i<elementos.length;i++)
                        elementos[i] = (int) (Math.random()*200)+1;
                    break;
                case 2:
                    for (int i = 0; i < elementos.length; i++)
                        System.out.print(elementos[i] + ", ");
                    break;
                case 3:
                    Arrays.sort(elementos);
                    break;
                case 4:
                    for (int i=0;i<elementos.length;i++)
                        elementos[i] = 0;
                    break;
                case 5:
                    break;
            }
        }while (opcion!=5);

        System.out.println("Programa terminado");
    }
}


/* Ejercicio 1
Scanner scanner= new Scanner(System.in);
        String nombre,continuar, saludoPerso;
        String saludo= "%s %s son las %d:%d del %d de %s de %d";
        String[] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiemnre","Octubre","Noviembre","Diciembre"};
        Calendar calendar= null;
        int dia, mes, anio, hora, minuto;

        System.out.println("Indica cual es tu nombre: ");
        nombre= scanner.next();

        do {
            calendar= Calendar.getInstance();
            dia= calendar.get(Calendar.DAY_OF_MONTH);
            mes= calendar.get(Calendar.MONTH);
            anio= calendar.get(Calendar.YEAR);
            hora= calendar.get(Calendar.HOUR_OF_DAY);
            minuto= calendar.get(Calendar.MINUTE);

            //saludo
            if(hora>6 && hora<12){
                saludoPerso= "Buenos días";
            } else if (hora>=12 && hora<20) {
                saludoPerso= "Buenas tardes";
            } else {
                saludoPerso= "Buenas noches";
            }

            System.out.printf(saludo,saludoPerso,nombre,hora,minuto,dia,mes,anio);

            System.out.println("\n¿Quieres volver a comprobar la hora?");
            continuar= scanner.next();

        }while (continuar.equalsIgnoreCase("s"));

        System.out.println("Programa finalizado");
*/

/* Ejercicio 2
    for(int i=0;i<11;i++){
            System.out.println("Tabla del "+i);
            for(int j=0;j<10;j++){
                System.out.printf("\t %d * %d = %d%n",i,j,i*j);
            }
        }
*/