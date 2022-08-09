import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'mon-composant, [mon-comp]',
  templateUrl: './mon-composant.component.html',
  styleUrls: ['./mon-composant.component.css']
})
export class MonComposantComponent implements OnInit {

  @Input()
  libelle: string;


  constructor() { }

  ngOnInit(): void {
  }

  @HostListener("mouseenter")
  jeRentreSurLeComposant() {
    console.log("fdqsjhdeiuhbdkjnfjkdls");
  }

}
