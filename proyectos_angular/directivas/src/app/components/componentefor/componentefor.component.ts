import { Component } from '@angular/core';

@Component({
  selector: 'directivas-componentefor',
  templateUrl: './componentefor.component.html',
  styleUrls: ['./componentefor.component.css'],
})
export class ComponenteforComponent {

  coleccionElementos: any[] = [
    "Elemento 1",
    "Elemento 2",
    "Elemento 3",
    "Elemento 4",
    "Elemento 5",
    "Elemento 6",
    "Elemento 7",
    "Elemento 8",
    "Elemento 9",
    "Elemento 10",
    "Elemento 11",
    "Elemento 12"
  ];

  coleccionElementosFiltrados: string[] = [];

  agregarLi(valor:string){
    this.coleccionElementos.push(valor);
  }

  filtrarElementos(valor:string){
    let numero = Number(valor);

    if(isNaN(numero)){
      alert("Por favor introduce un número")
    } else{
      this.coleccionElementosFiltrados = this.coleccionElementos.filter(
        (item)=> item.inclides(numero.toString())
      );
    }
  }

}
