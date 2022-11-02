package com.example.pestanias.model;

public class CambioBase {
    // Variables
    private int numeroDecimal;
    private String numeroConv="";
    private int base;

    // Constructores
    public CambioBase(int numeroDecimal, int base) {
        this.numeroDecimal = numeroDecimal;
        this.base = base;
    }

    // Funciones
    public void operacionCambioBase() {
        switch (base){
            case 2:
                do{
                    numeroConv += String.valueOf(numeroDecimal%2);
                    numeroDecimal = numeroDecimal/2;
                }while(numeroDecimal > 2);

                for (int i = numeroConv.length()-1; i >=0 ; i--) {
                    System.out.println(numeroConv.charAt(i));
                }
                break;

            case 8:
                break;

            case 16:
                break;
        }
    }

    // Getter y Setter
    public int getNumeroDecimal() {
        return numeroDecimal;
    }

    public void setNumeroDecimal(int numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }

    public String getNumeroConv() {
        return numeroConv;
    }

    public void setNumeroConv(String numeroComv) {
        this.numeroConv = numeroComv;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }



}
