fetch("https://dummyjson.com/products")
  .then((ok) => ok.json())
  .then((ok1) => {
    console.log(ok1);
    ok1.products.forEach((element) => {
      console.log(element.title);
    });
  })
  .catch((err) => {
    console.log("Conexion incorrecta");
  });

let urlProductos = "https://dummyjson.com/products/category/";
let selectCategorias = document.querySelector("select");
let filaCartas = document.querySelectorAll(".row")[2];
let botonFiltrar = document.querySelector("#filtrar");
let productosMostrar = [];
let listaCarrito = document.getElementById("lista_carrito");
let totalCarrito = document.getElementById("total_carrito");
let precioFiltro = document.querySelector("input");
 
botonFiltrar.addEventListener("click", (e) => {
  filaCartas.innerHTML = "";
  productosMostrar
    .filter((element) => element.price > 35)
    .forEach((item) => {
      console.log(item);
      pintarProducto(item);
    });
});

selectCategorias.addEventListener("change", (e) => {
  consultarProductos(e.target.value);
});

function consultarProductos(categoria) {
  filaCartas.innerHTML = "";
  fetch(urlProductos + categoria)
    .then((ok) => {
      console.log(ok);
      return ok.json();
    })
    .then((ok1) => {
      productosMostrar = ok1.products;
      ok1.products.forEach((element) => {
        //console.log(element.title);
        // pintar cada carta en el innerHTML de la row
        if(element.price <= precioFiltro.valueAsNumber){
          pintarProducto(element);
        } else{
          pintarProducto(element)
        }
      });
    })
    .catch((err) => {
      alert("Conexion incorrecta");
    });
}

botonFiltrar.addEventListener("click", (e)=>{
  consultarProductos(categoria)
})

function pintarProducto(producto) {
  
    filaCartas.innerHTML += `<div class="col">
              <div class="card" style="width: 18rem">
                <img src="${producto.images[0]}" class="card-img-top" alt="..." />
                <div class="card-body">
                  <h5 class="card-title">${producto.title}</h5>
                  <h6 class="card-title">${producto.price}€</h6>
                  <p class="card-text">
                   ${producto.description}
                  </p>
                  <button class="btn btn-primary">Agregar a carrito</button>
                </div>
              </div>
            </div>`;
  }

fetch("https://dummyjson.com/products/categories")
  .then((ok) => ok.json())
  .then((ok1) => {
    ok1.forEach((element) => {
      selectCategorias.innerHTML += `<option>${element}</option>`;
    });
  });