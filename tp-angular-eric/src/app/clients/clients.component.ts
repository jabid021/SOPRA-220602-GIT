import { Component, OnInit } from '@angular/core';
import { Client } from '../model';


@Component({
  selector: 'clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: Array<Client> = new Array<Client>();

  recherche: string;

  clientForm: Client = new Client();

  constructor() {
    this.clients.push(new Client("LAY", "Caroline", 125000));
    this.clients.push(new Client("CERTAIN", "Cassandre", 65000));
    this.clients.push(new Client("ATTAOUILE", "Hamza", 525000));
    this.clients.push(new Client("SULTAN", "Eric", -1000));
    this.clients.push(new Client("BOUJDARIA", "Bilel", 5000));
   }

  ngOnInit(): void {
  }

  search(): Array<Client> {
    if (this.recherche) {
      return this.clients.filter(client => client.nom.indexOf(this.recherche) != -1);
    } else {
      return this.clients;
    }

  }

  valid() {
    this.clients.push(this.clientForm);

    this.clientForm = new Client();
  }

}
