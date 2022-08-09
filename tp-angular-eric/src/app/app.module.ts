import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AscBoldElementComponent } from './asc-bold-element/asc-bold-element.component';
import { AscBoldComponent } from './asc-bold/asc-bold.component';
import { AscTooltipComponent } from './asc-tooltip/asc-tooltip.component';
import { MonComposantComponent } from './mon-composant/mon-composant.component';
import { BgBlackDirective } from './bg-black.directive';
import { ClientsComponent } from './clients/clients.component';

@NgModule({
  declarations: [
    AppComponent,
    MonComposantComponent,
    AscBoldComponent,
    AscBoldElementComponent,
    AscTooltipComponent,
    BgBlackDirective,
    ClientsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
