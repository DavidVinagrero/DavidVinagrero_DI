import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Variables
        Scanner scanner = new Scanner(System.in);
        int opcion=0;
        double dato;
        ArrayList<Double> temperaturas= new ArrayList<>();

        //Programa
        do {
            System.out.println("\n1. Introducir temperaturas en ºC");
            System.out.println("2. Mostrar temperaturas");
            System.out.println("3. Ordenar temperaturas");
            System.out.println("4. Mostrar extremos");
            System.out.println("5. Mostrar media");
            System.out.println("6. Salir");
            opcion= scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("\nIntroduce un decimal, para terminar 99");
                    do {
                        System.out.println("---");
                        dato= scanner.nextDouble();
                        temperaturas.add(dato);
                    }while (dato!=99);
                    temperaturas.remove(dato);
                    System.out.println("\nHas introducido "+temperaturas.size()+" temperaturas");
                    break;

                case 2:
                    if(!temperaturas.isEmpty()){
                    for (int i = 0; i < temperaturas.size(); i++) {
                        System.out.println("Tempreratura: "+ temperaturas.get(i)+"ºC");
                    }break;
                    }else {
                        System.out.println("Todavía no has introducido temperaturas");
                        break;
                    }

                case 3:
                    if(!temperaturas.isEmpty()) {
                        Collections.sort(temperaturas);
                        break;
                    }else {
                        System.out.println("Todavía no has introducido temperaturas");
                        break;
                    }

                case 4:
                    if(!temperaturas.isEmpty()) {
                        ArrayList<Double> clone = (ArrayList<Double>) temperaturas.clone();
                        Collections.sort(clone);
                        double ultimo= clone.size() - 1;
                        double ultimoValor = clone.get((int) ultimo);
                        System.out.println("La temperatúra máxima era de " +ultimoValor+"ºC");
                        System.out.println("La temperatúra mínimo era de " + clone.get(0)+"ºC");
                        break;
                    } else {
                        System.out.println("Todavía no has introducido temperaturas");
                        break;
                    }

                case 5:
                    if(!temperaturas.isEmpty()){
                        double num= 0;
                        for (int i = 0; i < temperaturas.size(); i++){
                            num+= Double.parseDouble(temperaturas.get(i).toString());
                        }
                        System.out.println("La media de las temperaturas es "+num/temperaturas.size()+"ºC");
                    } else {
                        System.out.println("Todavía no has introducido temperaturas");
                        break;
                    }
            }

        }while (opcion!=6);
        System.out.println("Programa terminado");

    }
}
