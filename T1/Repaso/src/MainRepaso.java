import java.util.Arrays;
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

        Scanner scanner = new Scanner(System.in);
        int[] numeros= null;
        int opcion= 0;

        do{
            System.out.println("\nRellenar   1\n"+
                    "Listar     2\n"+
                    "Ordenar    3\n"+
                    "Vaciar     4\n"+
                    "Buscar     5\n"+
                    "Sustituir  6\n"+
                    "Min y Mas  7\n"+
                    "Salir      8\n"+
                    "\nOpción: ");
            opcion= scanner.nextInt();

            switch (opcion){
                case 1:
                    if(numeros!=null){
                        System.out.println("Ya tiene valores, ¿Quieres volver a rellenarlo?");
                        String opcionRellenar= scanner.next();
                        if(opcionRellenar.equalsIgnoreCase("s")){
                            numeros= new MainRepaso().rellenarArray();
                        } else {
                            System.out.println("Array relleno previamente");
                        }
                    } else {
                        numeros= new MainRepaso().rellenarArray();
                    }
                    break;

                case 2:
                    for(int item:numeros){
                        /*
                        int posicion= 1;
                        System.out.printf("Elemento %d: %d%n",posicion,item);
                        posicion++;*/
                    }
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.printf("Elemento %d: %d%n",i+1,numeros[i]);
                    }
                    break;

                case 3:
                    Arrays.sort(numeros);
                    break;

                case 4:
                    numeros=null;
                    break;

                case 5:
                    if(numeros!=null){
                        System.out.println("¿Que número quieres buscar?");
                        int numeroBuscar= scanner.nextInt();
                        boolean encontrado= false;
                        for(int i= 0; i< numeros.length;i++){
                            if(numeroBuscar==numeros[i]){
                                System.out.println("Encontrado en la posicion "+i+1);
                                encontrado=true;
                                break;
                            }
                            if(!encontrado)
                                System.out.println("No se ha encontrado el numero");
                        }
                    }
                    break;

                case 6:
                    break;

                case 7:
                    int[] clone= numeros.clone();
                    Arrays.sort(clone);
                    System.out.println("El max es "+clone[clone.length-1]);
                    System.out.println("El min es "+clone[0]);
                    break;
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }while (opcion!=8);

        System.out.println("Programa terminado");
    }

    public int[] rellenarArray() {
        int[] numeros= new int[50];
        for(int i=0;i<numeros.length;i++)
            numeros[i] = (int) (Math.random()*200+1);
        return numeros;
    }

    public boolean isArrayVacio(int[] numerosComprobar){
        return numerosComprobar== null;
    }
}

// int[][] matriz= new int[][]
/*
    for(i= 0; i< matriz; i++){
        for(j= 0; matriz[i].length; j++){
            m[i][j]
        }
    }

    for(int[]i:matriz){
        for(int x: i)
    }
*/



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
