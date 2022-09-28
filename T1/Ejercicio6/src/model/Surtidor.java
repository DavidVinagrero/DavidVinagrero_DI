package model;

public class Surtidor {
    // Variables
    int capacidadTotal, capacidadActual;
    String tipoGasolina;
    boolean funcionaSurtidor;

    // Constructores
    public Surtidor(int capacidadTotal, String tipoGasolina) {
        this.capacidadTotal = capacidadTotal;
        this.tipoGasolina = tipoGasolina;
        funcionaSurtidor = true;
        capacidadActual = capacidadTotal;
    }

    public Surtidor(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
        capacidadTotal = 0;
        capacidadActual = 0;
        funcionaSurtidor = false;
    }

    // Funciones
    public void arreglar() {
        funcionaSurtidor = true;
    }

    public void rellenar(int gasolina) {
        capacidadTotal += gasolina;
    }

    public void quitarGasolina(int gasolina) {
        capacidadActual -= gasolina;
    }

    // Getter y setter
    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public boolean isFuncionaSurtidor() {
        return funcionaSurtidor;
    }

    public void setFuncionaSurtidor(boolean funcionaSurtidor) {
        this.funcionaSurtidor = funcionaSurtidor;
    }
}
