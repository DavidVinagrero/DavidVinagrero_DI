// Generar un array de cartas desde el 1..13 de corazones, diamantes, tréboles y picas
const palos = [" Corazones", " Picas", " Diamantes", " Tréboles"];
let baraja = [];

for (let i = 0; i < palos.length; i++) {
  for (let j = 0; j < 14; j++) {
    baraja.push(j + palos[i]);
  }
}

// baraja = _.suffle(baraja);
// baraja.forEach((element) => console.log(element));

// lista de los elementos que cumplan con el predicado
// todos los corazones -> lista de elementos
baraja.filter((item) => {
    // predicado
    
    return item.includes("Corazones");
  }).forEach((item1) => {
    console.log(item1);
  });

// el elemento que coincide con el predicado
baraja.find((value) => {
  return value.includes("Diamantes");
});

// una baraja que no tenga el elemento 1 C (Corazones)
let barajaSin1C = baraja.filter((item) => {
                    item != "1 Corazones";
                  });
