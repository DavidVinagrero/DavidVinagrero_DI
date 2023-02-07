// Promise(acepto, rechazo)
/* let promesaInicial = new Promise((res, rej) => {
  // lógica de ejecucion
  setTimeout(() => {
    let numero = Math.random() * 101;

    if (numero >= 50) {
      res(numero);
    } else {
      rej("Promesa con resultado incorrecto");
    }
    // <49 --> resultado correcto res
    // >50--> resultado incorrecto rej
  }, 3000);
}); */

// res --> then definiensdo la funcion del red
// rej --> catch

/* promesaInicial.then((ok) => {
    // resultado correcto
    console.log(`La promesa ha contestado con un resultado de ${ok}`);
}).catch((err) => {
    // resultado incorrecto
    console.log(`${err}`);
}).finally(()=>{
    console.log("Ejecucion en cualquiera de los casos");
});
 */

/* setInterval(()=>{
    console.log("Ejecucion");
}, 2000); */

fetch("https://dummyjson.com/products")
  .then((ok) => {
    console.log("conexión correcta");
    return ok.json();
  })
  .then((ok1) => {})
  .catch((err) => {
    console.log("conexión incorrecta");
});
