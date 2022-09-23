package model;

public final class Autonomo extends Trabajador {
    //Variables
    private int cuotaSS, totalFactura;

    //Funciones
    public Autonomo(String nombre, String apellido, String dni, int NSS, int cuotaSS, int totalFactura) {
        super(nombre, apellido, dni, NSS);
        this.cuotaSS = cuotaSS;
        this.totalFactura = totalFactura;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Cuota SS: " + cuotaSS);
        System.out.println("Total factura: " + totalFactura);
    }

    @Override
    public void calcularJubilacion() {
        System.out.println("Calculando jubilación del autónomo...");
        System.out.println("Tu jubilación es: " + cuotaSS / 2);
    }

    //Getter y Setter

    public int getCuotaSS() {
        return cuotaSS;
    }

    public void setCuotaSS(int cuotaSS) {
        this.cuotaSS = cuotaSS;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }
}
