import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AppGlobalService } from '../app-global.service';
import { Adresse } from './../model';

@Injectable({
  providedIn: 'root'
})
export class AdresseHttpService {

  adresses: Array<Adresse> = new Array<Adresse>();

  apiPath: string;

  constructor(private http: HttpClient, private appGlobal: AppGlobalService) {
    this.apiPath = this.appGlobal.backEndUrl + "adresse/";
    this.reload();
  }

  findAll(): Array<Adresse> {
    return this.adresses;
  }

  findAllOrphans(): Observable<Array<Adresse>> {
    return this.http.get<Array<Adresse>>(this.apiPath + "orphans");
  }

  findById(id: number): Observable<Adresse> {
    return this.http.get<Adresse>(this.apiPath + id);
  }

  save(adresse: Adresse) {
    if(adresse.id) {
      this.http.put<Adresse>(this.apiPath + adresse.id, adresse)
        .subscribe(resp => {
          this.reload();
        });
    } else {
      this.http.post<Adresse>(this.apiPath, adresse)
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
    this.http.get<Array<Adresse>>(this.apiPath)
      .subscribe(response => {
        this.adresses = response;
      });
  }
}
