import model.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variables
        Scanner scanner = new Scanner(System.in);
        Persona persona1;
        Persona persona2;
        Persona persona3;
        String nombre,sexo,dni;
        double peso,altura;
        int edad;

        System.out.println("Introduce el nombre");
        nombre= scanner.next();
        System.out.println("Introduce la edad");
        edad= scanner.nextInt();
        System.out.println("Introduce el sexo");
        sexo= scanner.next();
        System.out.println("Introduce el peso");
        peso= scanner.nextDouble();
        System.out.println("Introduce la altura en metros");
        altura= scanner.nextDouble();

        persona1= new Persona(nombre,sexo,peso,altura,edad);
        persona2= new Persona(nombre,sexo,edad);
        persona3= new Persona();
        persona3.setAltura(178.4);
        persona3.setPeso(62.1);
        persona3.setEdad(17);

        persona1.mostrarDatos();
        persona1.calcularIMC(peso,altura);
        persona2.mostrarDatos();
        persona2.calcularIMC(peso,peso);
        persona3.mostrarDatos();
        persona3.calcularIMC(peso,peso);

    }

}
