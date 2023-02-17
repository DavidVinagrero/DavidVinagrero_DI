/* window.addEventListener("load", (e) => {
  console.log("página cargada");
  let inputNombre = document.querySelector("#input_nombre");
}); */

let url = "https://jsonplaceholder.typicode.com/posts";

let arrayPosts = [];

fetch(url)
  .then((ok) => {
    if (ok.status == 200) {
      console.log("Conexion correcta, haciendo cosas...");
      return ok.json();
    } else {
      console.log("Conexion correcta, url no codificada");
    }
  })
  .then((ok1) => {
    ok1.forEach((element) => {
      let post = {
        title: element.title,
        body: element.body,
      };

      arrayPosts.push(post);
    });
  })
  .catch((err) => {
    console.log("Conexión fallida");
  })
  .finally(()=>{
    console.log(arrayPosts.length);
  });

// console.log(arrayPosts.length);