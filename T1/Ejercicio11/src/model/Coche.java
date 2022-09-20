package model;

public class Coche {
    //Propiedades
    private int cv, velocidad;
    private String matricula, modelo;
    private double km;


    //Constructores
    public Coche(){
        cv=0;
        velocidad=0;
        matricula="0000AAA";
        modelo="Sin especificar";
        km= 0.0;
    }

    public Coche(int cv, String matricula, String modelo) {
        this.cv = cv;
        this.matricula = matricula;
        this.modelo = modelo;
    }

    //Métodos
    public void acelerarCoche(int velocidad){
        this.velocidad= this.velocidad+velocidad;
        this.km= velocidad*((cv)*Math.random()*30+10);
        if(this.velocidad>180){
            this.velocidad=180;
            System.out.println("El coche ha sobrepasado la velocidad máxima");
        }
    }

    public void frenarCoche(int velocidad){
        this.velocidad-=velocidad;
        if(this.velocidad<0){
            this.velocidad=0;
            System.out.println("Velocidad mínima alcanzada");
        }
    }

    public void reiniciarVelocidad(){
        this.velocidad=0;
    }

    //Getter & Setter

}
