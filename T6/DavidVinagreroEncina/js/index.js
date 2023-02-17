// Variables index
let etiquetaNombre = document.getElementById("input_nombre");
let etiquetaApellido = document.getElementById("input_apellido");
let divAlerta = document.getElementById("div_alerta");
// let checkEstado = document.getElementById("check_estado").value;

// Variables noticias
let url = "https://content.guardianapis.com/search?api-key=dab9d894-424d-487f-bbce-36df08477f0d&";
let inputPalabra = document.getElementById("input_palabra");
let numeroResultados = document.querySelector("#input_num_resultados");
let noticias = {};
let botonBuscar = document.getElementById("boton_resultados");
let divCartas = document.getElementById("div_cartas")

function comprobarDatos(nombre, apellido){
    if(nombre == "" || apellido == ""){
        alert("Faltan datos");
        return false;
    }
}

// Buscar por palabra y resultado
function buscarNoticia(palabra, resultados){
    if(palabra != "" || numeroResultados == 0 ){
        let parametros = `q=${palabra}&page-size=${numeroResultados.value}`;
        console.log(url+parametros);

        fetch(url+parametros)
        .then((res) => {
            console.log(res);
            return res.json();
        }).then((res1) => {
            res1.response.results.forEach((element) => {
                // console.log(element.webTitle);
                divCartas.innerHTML += `<div class="col">
                <div class="card" style="width: 18rem">
                    <div class="card-body">
                    <h5 class="card-title">${element.webTitle}</h5>
                    <a href="${element.webUrl}" target="blank"><button class="btn btn-primary">Ir a la noticia</button></a>
                    </div>
                </div>
                </div>`;
            });
        })
        .catch((rej) => {
            console.log(`Ha habido algún tipo de fallo: ${rej}`);
        });
    }else{
        alert("Faltan datos")
    }
}

// Buscar por categoría
function buscarCategoria(categoria){
    let parametro = `section=${categoria}`;
    console.log(url+parametro);

    if(categoria == "science" || categoria == "technology" || categoria == "sport"){
        fetch(url+parametro)
        .then((res) => {
            console.log(res);
            return res.json();
        }).then((res1) => {
            res1.response.results.forEach((element) => {
                // console.log(element.webTitle);
                divCartas.innerHTML += `<div class="col">
                <div class="card" style="width: 18rem">
                    <div class="card-body">
                    <h5 class="card-title">${element.webTitle}</h5>
                    <a href="${element.webUrl}" target="blank"><button class="btn btn-primary">Ir a la noticia</button></a>
                    </div>
                </div>
                </div>`;
            });
        }).catch((rej) => {
            console.log(`Ha habido algún tipo de fallo: ${rej}`);
        });
    } else{
        alert("Faltan datos, las categorías admitidas son: science, technology y sport")
    }
}
