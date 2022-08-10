import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-client-detail',
  templateUrl: './client-detail.component.html',
  styleUrls: ['./client-detail.component.css']
})
export class ClientDetailComponent implements OnInit {

  nom: String;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.nom = params['nom'];
    });

   }

  ngOnInit(): void {
  }

}
