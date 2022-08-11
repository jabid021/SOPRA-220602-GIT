import { Component, OnInit } from '@angular/core';
import { Adresse } from '../model';
import { AdresseHttpService } from './adresse-http.service';

@Component({
  selector: 'app-adresse',
  templateUrl: './adresse.component.html',
  styleUrls: ['./adresse.component.scss']
})
export class AdresseComponent implements OnInit {

  adresse: Adresse;

  constructor(private adresseService: AdresseHttpService) { }

  ngOnInit(): void {
  }

  list(): Array<Adresse> {
    return this.adresseService.findAll();
  }

  add() {
    this.adresse = new Adresse();
  }

  edit(id: number) {
    this.adresseService.findById(id).subscribe(
      resp => {
        this.adresse = resp;
      }
    )
  }

  save() {
    this.adresseService.save(this.adresse);
  }

  delete(id: number) {
    this.adresseService.delete(id);
  }

  cancel() {
    this.adresse = null;
  }

}
