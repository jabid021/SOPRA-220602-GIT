import { Component, OnInit } from '@angular/core';
import { AdresseHttpService } from '../adresse/adresse-http.service';
import { Adresse, Client } from '../model';
import { ClientHttpService } from './client-http.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  client: Client;
  adressesOrphan: Array<Adresse> = new Array<Adresse>();

  constructor(private clientService: ClientHttpService, private adresseService: AdresseHttpService) {
  }

  ngOnInit(): void {
  }

  list(): Array<Client> {
    return this.clientService.findAll();
  }

  listAdresse(): Array<Adresse> {
    return this.adressesOrphan;
  }

  add() {
    this.client = new Client();
    this.client.adresse = new Adresse();

    this.reloadAdresseOrphans();
  }

  edit(id: number) {
    this.clientService.findById(id).subscribe(resp => {
      this.client = resp;
    });

    if(!this.client.adresse) {
      this.client.adresse = new Adresse();
    }

    this.reloadAdresseOrphans();
  }

  save() {
    this.clientService.save(this.client);
    this.cancel();
  }

  delete(id: number) {
    this.clientService.delete(id);
  }

  cancel() {
    this.client = null;
  }

  reloadAdresseOrphans() {
    this.adresseService.findAllOrphans().subscribe( 
      resp => {
        this.adressesOrphan = resp;
      }
    )
  }
}
