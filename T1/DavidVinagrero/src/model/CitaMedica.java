package model;

public class CitaMedica {
    //Variables
    private int dia, nss, mes;
    private int numMedico;
    private String comentario;

    //Constructores
    public CitaMedica(int nss, int dia, int mes, int numMedico, String comentario) {
        this.nss= nss;
        this.dia = dia;
        this.mes = mes;
        this.numMedico = numMedico;
        this.comentario = comentario;
    }

    public void mostrarDatos(){
        System.out.println("NSS: "+nss);
        System.out.println("Día: "+dia);
        System.out.println("Mes: "+mes);
        System.out.println("Num Medico: "+numMedico);
        System.out.println("Comentario: "+comentario);
    }

    //Getter y setter
    public int getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(int numMedico) {
        this.numMedico = numMedico;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
