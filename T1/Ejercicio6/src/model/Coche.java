package model;

public class Coche {
    // Variables
    String gasolina;
    int litrosDeposito;

    // Constructores

    public Coche(String gasolina) {
        this.gasolina = gasolina;
        litrosDeposito = 0;
    }

    // Funciones
    public void ponerGasolina(Surtidor surtidor, int cantidadLitros) {
        if (cantidadLitros<0){
            System.out.println("No puedes poner un valor negativo");
        } else if (surtidor.getCapacidadActual() < cantidadLitros || surtidor.getCapacidadActual() == 0) {
            System.out.println("El surtidor no tiene suficiente gasolina o está vacío");
        } else if (!surtidor.isFuncionaSurtidor()) {
            System.out.println("El surtidor no funciona en este momento");
        } else if (!(surtidor.getTipoGasolina().equalsIgnoreCase(gasolina))) {
            System.out.println("EL tipo de gasolina del coche no es el mismo del surtidor");
        } else {
            litrosDeposito += cantidadLitros;
            surtidor.quitarGasolina(cantidadLitros);
        }
    }

    // Getter y setter
    public String getGasolina() {
        return gasolina;
    }

    public void setGasolina(String gasolina) {
        this.gasolina = gasolina;
    }

    public int getLitrosDeposito() {
        return litrosDeposito;
    }

    public void setLitrosDeposito(int litrosDeposito) {
        this.litrosDeposito = litrosDeposito;
    }
}
