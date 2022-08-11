import { Injectable } from '@angular/core';
import { Adresse } from '../model';

@Injectable({
  providedIn: 'root'
})
export class AdresseService {
  adresses: Array<Adresse> = new Array<Adresse>();

  constructor() {
    this.adresses.push(new Adresse(21, "1 rue de la Paix", "75008", "Paris"));
    this.adresses.push(new Adresse(25, "31 rue de la Truanderie", "75012", "Paris"));
  }

  findAll(): Array<Adresse> {
    return this.adresses;
  }

  findById(id: number): Adresse {
    return this.adresses.find(adr => adr.id == id);
  }

  save(adresse: Adresse) {
    if (adresse.id) { // en modification
      let index = this.adresses.findIndex(adr => adr.id == adresse.id);
      this.adresses[index] = adresse;
    } else { // en création
      let max = 0;
      for (let cli of this.adresses) {
        if (cli.id > max) {
          max = cli.id;
        }
      }

      adresse.id = ++max;

      this.adresses.push(adresse);
    }
  }

  delete(id: number) {
    let index = this.adresses.findIndex(adr => adr.id == id);

    if (index != -1) {
      this.adresses.splice(index, 1);
    }
  }}
