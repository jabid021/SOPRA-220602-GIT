import {Component, HostListener, Input, OnInit} from '@angular/core';

@Component({
  selector: 'asc-bold-element',
  templateUrl: './asc-bold-element.component.html',
  styleUrls: ['./asc-bold-element.component.css']
})
export class AscBoldElementComponent implements OnInit {

  @Input("prefix")
  monPrefixe: string ="";

  @Input("text")
  monTexte: string = "";

  constructor() {
    
   }

  ngOnInit(): void {
    
  }

  @HostListener("click")
  alerte() {
    alert(this.monTexte);
  }

}
