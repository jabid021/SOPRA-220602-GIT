import { Component } from '@angular/core';
import { Client } from './model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})


export class AppComponent {
  prenom: string = 'Eric';
  couleur: string = "#000000";

  client: Client = new Client("SULTAN", "Eric", 154000);

  majPrenom() {
    this.prenom = this.prenom.toUpperCase();
  }
}
