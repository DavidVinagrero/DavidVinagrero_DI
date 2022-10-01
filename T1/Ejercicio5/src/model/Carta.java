package model;

public class Carta {
    //Variables
    private int numero;
    private String palo;
    public static final String[] PALOS= {"Espadas","Oros","Bastos","Copas"};

    //Constructores
    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    //Funciones
    @Override
    public String toString() {
        return "numero: "+numero+"\npalo: "+palo;
    }

    //Getter y Setter
    public int getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo;
    }

    public String[] getPALOS() {
        return PALOS;
    }
}
