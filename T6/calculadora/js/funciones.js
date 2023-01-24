function nombreFuncion(p1, p2) {
    console.log("Ejemplo de funcion a ejecutar");
    console.log(p1+p2);
}

function funcionConRetorno(p1, p2) {
    return p1 + p2;
}

let funcionFlecha = (p1, p2) => {
    console.log(p1 +p2);
};

function parametrosAdiciones(p1){
    console.log(p1);
    console.log("Invisibles")
    for (let i = 0; i < arguments.length; i++) {
        console.log(argmuents[i]);
    }
}

function parametroDefecto(p1, p2, p3 = 0) {
    console.log(p1 + p2 + p3);
}

parametroDefecto(1,4,6)
console.log(typeof funcionConRetorno(4,2));