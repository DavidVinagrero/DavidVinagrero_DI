import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ciclos',
  templateUrl: './ciclos.component.html',
  styleUrls: ['./ciclos.component.css']
})
export class CiclosComponent {
  // ActivatedRoute
  constructor(private gestorRutas: ActivatedRoute){
      console.log(gestorRutas);
  }
}
