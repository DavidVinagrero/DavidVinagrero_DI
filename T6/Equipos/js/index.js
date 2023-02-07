let equipoMadrid = new equipo("Madrid",150000);
let equipoBarcelona = new equipo("Barcelona",1300000);
let equipoAtletico = new equipo("Atletico",1450000);

equipoMadrid.addJugador(new Jugador("vallejo", "Defensa",10000));
equipoMadrid.addJugador(new Jugador("Benzema", "Delantero",10000));

setTimeout(()=>{
    equipoMadrid.addJugador(new Jugador("Benzema", "Delantero",50000));
}, 5000);

equipoMadrid.listarPlantilla();

let liga = [equipoAtletico, equipoBarcelona, equipoMadrid];

