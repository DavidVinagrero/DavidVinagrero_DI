import model.Coche;

public class Main {
    public static void main(String[] args) {
        Coche cocheA= new Coche();
        Coche cocheB= new Coche();

        System.out.println("Coche A "+cocheA);
        System.out.println("Coche B "+cocheB);

        cocheA.setCv(200);
        cocheA.setModelo("Audi");
        cocheA.setMatricula("1234ABC");
        cocheA.setVelocidad((int)(Math.random()*21+10));
        cocheB.setVelocidad((int)(Math.random()*21+10));

        System.out.println("\nCoche A "+cocheA);
        System.out.println("Coche B "+cocheB);


        /*//media de CV de los coches que estan en el concesionario
        double media=0;
        for (Coche coche:listaCoches) {
            media+= coche.getCv();
        }
        media/=listaCoches.size();
        System.out.println("La media de CV es: "+media);*/

        /*coche1.acelerarCoche(100);
        coche2.acelerarCoche(100);
        coche1.acelerarCoche(50);
        coche2.acelerarCoche(20);

        System.out.println(coche1);
        System.out.println(coche2+"\n");

        if(!coche1.decelerarCoche(190)){
            System.out.println("Ha ocurrido alg, frenazo en seco");
        }
        System.out.println(coche1);*/
    }

    public static class MainTrabajadores {

    }
}
