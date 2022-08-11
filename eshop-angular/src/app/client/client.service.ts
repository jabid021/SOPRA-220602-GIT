import { Injectable } from '@angular/core';
import { Client } from '../model';
import { AdresseService } from './../adresse/adresse.service';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  clients: Array<Client> = new Array<Client>();

  constructor(private adresseService: AdresseService) {
    this.clients.push(new Client(2, "LAY", "Caroline", 27, "caro@gmail.com", "Client exigeant"));
    this.clients.push(new Client(5, "BOUJDARIA", "Bilel", 27, "bilel@gmail.com", "Livraison rapide demandée"));
    this.clients.push(new Client(6, "SULTAN", "Eric", 44, "eric@gmail.com", "Raleur !!!"));
  }

  findAll(): Array<Client> {
    return this.clients;
  }

  findById(id: number): Client {
    return this.clients.find(client => client.id == id);
  }

  save(client: Client) {
    if (client.id) { // en modification
      let index = this.clients.findIndex(cli => cli.id == client.id);
      this.clients[index] = client;
    } else { // en création
      let max = 0;
      for (let cli of this.clients) {
        if (cli.id > max) {
          max = cli.id;
        }
      }

      client.id = ++max;

      this.clients.push(client);
    }

    if(client.adresse.id) {
      let adresse = this.adresseService.findById(client.adresse.id);
      client.adresse = adresse;
    } else {
      client.adresse = null;
    }

  }

  delete(id: number) {
    let index = this.clients.findIndex(cli => cli.id == id);

    if (index != -1) {
      this.clients.splice(index, 1);
    }
  }
}
