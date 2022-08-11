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
import { HttpClientModule } from '@angular/common/http';
import { ClientHttpService } from './client/client-http.service';
import { AdresseHttpService } from './adresse/adresse-http.service';
import { AppGlobalService } from './app-global.service';

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
    FormsModule,
    HttpClientModule
  ],
  providers: [AppGlobalService, AdresseService, AdresseHttpService, ClientService, ClientHttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
