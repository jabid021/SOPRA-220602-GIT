import { Injectable } from "@angular/core";
import { Client } from "./model";

@Injectable()
export class ClientService {
    clients: Array<Client> = new Array<Client>();

    constructor() {
        this.clients.push(new Client(1, "LAY", "Caroline", 125000));
        this.clients.push(new Client(2, "CERTAIN", "cassandre", 65000));
        this.clients.push(new Client(5, "ATTAOUILE", "Hamza", 0));
        this.clients.push(new Client(8, "SULTAN", "éric", -1000));
        this.clients.push(new Client(9, "BOUJDARIA", "Bilel", 5000));
    }

    findAll(): Array<Client> {
        return this.clients;
    }

    findAllByNom(nom: string): Array<Client> {
        return this.clients.filter(client => client.nom.indexOf(nom) != -1);
    }

    findById(id: number): Client {
        return this.clients.find(client => client.id == id);
    }

    save(client: Client) {
        if(!client.id) { // ajout d'un client
            let max = 0;
            for(let cli of this.clients) {
              if(cli.id > max) {
                max = cli.id;
              }
            }

            client.id = ++max;

            this.clients.push(client);
        } else { // modification d'un client existant

        }
    }

    delete(id: number) {

    }
}