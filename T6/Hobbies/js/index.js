let obj1 = {
  nombre: "Valor correcto",
  apellido: "Apellido correcto",
  edad: 23,
  hobbies: ["Futbol", "Series", "Videojuegos", "Cine"],
};

let obj2 = {
  nombre: "Valor",
  apellido: "Apellido",
  edad: 32,
  hobbies: ["Lectura", "Televisión"],
};

let usuarios = [obj1, obj2]

for (let i = 0; i < usuarios.length; i++) {
  if (usuarios[i].nombre.includes("Valor correcto")) {
    console.log(usuarios[i]);
  }
}
