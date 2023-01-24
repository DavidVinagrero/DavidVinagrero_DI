/* Nada más arrancar la página aparece un cuadro pidiendo el nombre
     - Si he metido el nombre aparece un cuadro de diálogo indicando que introduzca un operador
     - aparece un cuadro de diálogo indicando que introduzca un operador

         - en el caso de pulsar sí
            se mostrará un cuadro de diálogo de alerta con cada una de las operaciones XXX + XXX = XXX
            se mostrará un cuadro de diálogo de alerta con cada una de las operaciones XXX - XXX = XXX
            se mostrará un cuadro de diálogo de alerta con cada una de las operaciones XXX * XXX = XXX
            se mostrará un cuadro de diálogo de alerta con cada una de las operaciones XXX / XXX = XXX
            se mostrará un cuadro de diálogo de alerta con cada una de las operaciones XXX % XXX = XXX

        - en el caso de pulsar no
            se mostrará un cuadro de diálogo de alerta indicando que el proceso termina

    - Comprobación de errores*/

let nombre = prompt("Introduce tu nombre: ");
if(nombre.length > 0 || nombre.length != null) {
    // He introducido el nombre
    let operandoUno = parseInt(prompt("Introduce el primer operando: "));
    let operandoDos = parseInt(prompt("Introduce el segundo operando: "));

    if(!isNaN(operandoUno) && !isNaN(operandoDos)) {
        // Cuando los dos operandos son números
        alert(`${operandoUno} + ${operandoDos} = ${operandoUno + operandoDos}`);
        alert(`${operandoUno} - ${operandoDos} = ${operandoUno - operandoDos}`);
        alert(`${operandoUno} * ${operandoDos} = ${operandoUno * operandoDos}`);
        alert(`${operandoUno} / ${operandoDos} = ${operandoUno / operandoDos}`);
        alert(`${operandoUno} % ${operandoDos} = ${operandoUno % operandoDos}`);

    } else {
        alert(`${nombre}, hay un fallo en alguno de los datos`)
    }
} else {
    alert(`Fallo en el nombre`)
}
