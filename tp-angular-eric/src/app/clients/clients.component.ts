import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../model';
import { ClientService } from './../client.service';


@Component({
  selector: 'clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

 

  recherche: string;

  clientForm: Client = new Client();

  constructor(private router: Router, private clientService: ClientService) {
  
   }

  ngOnInit(): void {
  }

  search(): Array<Client> {
    if (this.recherche) {
      return this.clientService.findAllByNom(this.recherche);
    } else {
      return this.clientService.findAll();
    }

  }

  valid() {
    this.clientService.save(this.clientForm);

    this.clientForm = new Client();
  }

  detail(prenom: string) {
    this.router.navigate(["/client", prenom]);
  }

  edit(id: number) {
    this.clientForm = {...this.clientService.findById(id)};
  }

  delete(id: number) {
    this.clientService.delete(id);
  }

}
