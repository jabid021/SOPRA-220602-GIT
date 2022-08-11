import { Component, OnInit } from '@angular/core';
import { Adresse, Client } from '../model';
import { ClientService } from './client.service';
import { AdresseService } from './../adresse/adresse.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  client: Client;

  constructor(private clientService: ClientService, private adresseService: AdresseService) { }

  ngOnInit(): void {
  }

  list(): Array<Client> {
    return this.clientService.findAll();
  }

  listAdresse(): Array<Adresse> {
    return this.adresseService.findAll();
  }

  add() {
    this.client = new Client();
    this.client.adresse = new Adresse();
  }

  edit(id: number) {
    this.client =  {...this.clientService.findById(id)};

    if(!this.client.adresse) {
      this.client.adresse = new Adresse();
    }
  }

  save() {
    this.clientService.save(this.client);
  }

  delete(id: number) {
    this.clientService.delete(id);
  }

  cancel() {
    this.client = null;
  }
}
