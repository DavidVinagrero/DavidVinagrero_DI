import { Component } from '@angular/core';

@Component({
  selector: 'app-uno',
  templateUrl: './uno.component.html',
  styleUrls: ['./uno.component.css'],
})
export class UnoComponent {
  contador: number = 0;
  base: number = 0;

  realizarOperacion(opcion: number) {
    switch (opcion) {
      case 1: {
        this.contador++;
        break;
      }

      case 2: {
        this.contador--;
        break;
      }

      case 3: {
        this.contador = 0;
        break;
      }
    }
  }

  aniadirNumero(base:string){
    this.base = Number(base);
    this.contador = Number(base)
  }
}
