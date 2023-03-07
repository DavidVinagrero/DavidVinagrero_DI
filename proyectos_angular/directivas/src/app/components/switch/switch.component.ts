import { Component } from '@angular/core';

@Component({
  selector: 'directivas-switch',
  templateUrl: './switch.component.html',
  styleUrls: ['./switch.component.css']
})
export class SwitchComponent {
  seleccion = -1;

  cambioRadio(evento: any) {
    this.seleccion = Number(evento.target.value);
  }
}
