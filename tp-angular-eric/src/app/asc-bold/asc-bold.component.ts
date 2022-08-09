import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: '[asc-bold]',
  templateUrl: './asc-bold.component.html',
  styleUrls: ['./asc-bold.component.css']
})
export class AscBoldComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @HostListener("click")
  alerte() {
    alert("on a cliqué");
  }

}
