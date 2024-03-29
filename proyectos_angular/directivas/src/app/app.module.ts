import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DirectivaifComponent } from './components/directivaif/directivaif.component';
import { SwitchComponent } from './components/switch/switch.component';
import { Componente1Component } from './components/componente1/componente1.component';
import { Componente2Component } from './components/componente2/componente2.component';
import { Componente3Component } from './components/componente3/componente3.component';
import { ComponenteforComponent } from './components/componentefor/componentefor.component';

@NgModule({
  declarations: [
    AppComponent,
    DirectivaifComponent,
    SwitchComponent,
    Componente1Component,
    Componente2Component,
    Componente3Component,
    ComponenteforComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
