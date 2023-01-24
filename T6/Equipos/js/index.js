let equipoMadrid = [];
let equipoBarsa = [];
let equipoAtleti = [];

let jugador = {
    nombre: "",
    posicion: "",
    valor: 0
};

// Crea una función en la clase Equipo que se llame addJugador y admita por parámetros un jugador. 
function addJugador(nombre, posicion, valor) {
    jugador.nombre = nombre;
    jugador.posicion = posición;
    jugador.valor = valor;
}
let equipo = {
    nombre: "",
    plantilla: "",
    presupuesto: 0,

    addJugador: function (nombre, posicion, valor){
        this.plantilla = jugador(nombre, posicion, valor);
        this.presupuesto -= valor;        
    }, 

    listarEquipos: function (equipo) {
        console.log(equipo);
    },
    listarPlantilla: function (plantilla) {
        console.log(plantilla.jugador.nombre);
        console.log(plantilla.jugador.posicion);
        console.log(plantilla.jugador.valor);
    },
    listarPosicion: function (posicion) {
        if(jugador.posicion == posicion) {
            console.log(plantilla.jugador.nombre);
            console.log(plantilla.jugador.posicion);
            console.log(plantilla.jugador.valor);
        }
    }
}

