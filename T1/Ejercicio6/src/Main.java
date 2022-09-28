import model.Coche;
import model.Gasolinera;
import model.Surtidor;

public class Main {
    public static void main(String[] args) {
        // Variables
        Surtidor surtidor1 = new Surtidor(500, "Diesel");
        Surtidor surtidor2 = new Surtidor(100, "Gasolina95");
        Surtidor surtidor3 = new Surtidor("Gasoil");

        Gasolinera gasolinera= new Gasolinera("Gasolinera plus");

        Coche coche= new Coche("Diesel");

        // Programa
        gasolinera.agregarSurtidor(surtidor1);
        gasolinera.agregarSurtidor(surtidor2);
        gasolinera.agregarSurtidor(surtidor3);

        System.out.println("Gasolina antes de repostar: "+coche.getLitrosDeposito());
        System.out.println("Capacidad del surtidor antes de repostar: "+surtidor1.getCapacidadActual());
        coche.ponerGasolina(surtidor1,80);
        System.out.println("Gasolina después de repostar: "+coche.getLitrosDeposito());
        System.out.println("Capacidad del surtidor después de repostar: "+surtidor1.getCapacidadActual()+"\n");

        // Probando los métodos
            // Repostando un tipo de gasolina distinto
            coche.ponerGasolina(surtidor2,60);
            // Repostando en un surtidor vacío
            coche.ponerGasolina(surtidor3,80);
            System.out.printf("");
            // Cambiando un surtidor a averiado e intentando repostar
            surtidor1.setFuncionaSurtidor(false);
            coche.ponerGasolina(surtidor1,20);
            // Repostando en negativo
            coche.ponerGasolina(surtidor1,-10);

    }
}
