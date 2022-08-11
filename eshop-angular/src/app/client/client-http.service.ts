import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AppGlobalService } from '../app-global.service';
import { Client } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ClientHttpService {

  clients: Array<Client> = new Array<Client>();

  apiPath: string;

  constructor(private http: HttpClient, private appGlobal: AppGlobalService) {
    this.apiPath = this.appGlobal.backEndUrl + "client/";
    this.reload();
  }

  findAll(): Array<Client> {
    return this.clients;
  }

  findById(id: number): Observable<Client> {
    return this.http.get<Client>(this.apiPath + id);
  }

  save(client: Client) {
    if(client.adresse && !client.adresse.id) {
      client.adresse = null;
    }

    if(client.id) {
      this.http.put<Client>(this.apiPath + client.id, client)
        .subscribe(resp => {
          this.reload();
        });
    } else {
      this.http.post<Client>(this.apiPath, client)
        .subscribe(resp => {
          this.reload();
        });
    }
  }

  delete(id: number) {
    this.http.delete<void>(this.apiPath + id)
      .subscribe(resp => {
        this.reload();
      });
  }

  reload() {
    this.http.get<Array<Client>>(this.apiPath)
      .subscribe(response => {
        this.clients = response;
      });
  }
}
