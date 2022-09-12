import java.util.Scanner;

public class MainRepaso {
/*
        // Variables (propiedades,atributos)

        // Constructores

        // Métodos

        // Getter & setter

        // toString

        // TODO caminar
*/
    public static void main(String[] args) {

        String nombre;
        int edad;

        Scanner scanner= new Scanner(System.in);
        System.out.println("Introduce nombre: ");
        nombre= scanner.next();
        System.out.println("Introduce edad: ");
        edad=scanner.nextInt();

        System.out.printf("\n %s tienes %d\n",nombre,edad);

        System.out.println("Ejemplo de proyecto de repaso");

        //Operadores
            //Aritméticos (+ - / * %)
                //Unarios (++ --)
                //Asignacion (+= -= *= /= %=) num1= 8 num2= 9 num1+= num2 --> num1= 8+9
            //Relacionales (> >= < <= == !=)
            //Lógicos (AND && (todas son true) OR || (una es true))
            //Ternario
                // condición?cuando_true:cuando_false
                // condición&cuando_true

        //Estructuras de control
            //if
                /* edad= 20;
                if(edad>=18){
                    System.out.println("Eres mayor de edad");
                }
                else if (edad>=14 && edad<18) {
                    System.out.println("Casi mayor legal");
                }
                else {
                    System.out.println("Eres menor de edad");
                } */
            //switch (string, int, char)
                /* edad=1;
                   switch (edad){
                        case 1:

                        case 2:
                        break;

                        case 3:
                        break;

                        default:
                   }*/
            //Repetición
                //while --> 0 a n
                //do while
                    /* edad= 10;
                       while(edad<18){
                            System.out.println("Todavía eres menor de edad");
                       }
                       do {
                            System.out.println("Todavía eres menor de edad");
                            edad++;
                       }while (edad<18);*/
                //for (int i=0;i<10;i++){ ejecución }
                //for ( : )
    }
}
