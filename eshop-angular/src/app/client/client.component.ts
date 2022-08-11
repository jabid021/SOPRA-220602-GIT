import { Component, OnInit } from '@angular/core';
import { Client } from '../model';
import { ClientService } from './client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit {

  client: Client;

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
  }

  list(): Array<Client> {
    return this.clientService.findAll();
  }

  add() {
    this.client = new Client();
  }

  edit(id: number) {
    this.client =  {...this.clientService.findById(id)};
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
