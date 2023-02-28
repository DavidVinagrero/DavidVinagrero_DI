import { Component } from '@angular/core';

@Component({
  selector: 'directivas-directivaif',
  templateUrl: './directivaif.component.html',
  styleUrls: ['./directivaif.component.css'],
})
export class DirectivaifComponent {
  mostrar = false;
  situacionAlumno: Number = 0;

  evaluarNota(nota: string, cv: boolean) {
    // el alumno supera y cv
    // el alumno supera y no cv
    // el alumno no supera
    if(Number(nota) > 4 && cv){

    } else if(Number(nota) > 4){

    } else{

    }
  }
}
