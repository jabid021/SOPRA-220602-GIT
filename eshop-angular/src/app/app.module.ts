import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientComponent } from './client/client.component';
import { ClientService } from './client/client.service';
import { HomeComponent } from './home/home.component';
import { AdresseComponent } from './adresse/adresse.component';
import { AdresseService } from './adresse/adresse.service';

@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    HomeComponent,
    AdresseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AdresseService, ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
