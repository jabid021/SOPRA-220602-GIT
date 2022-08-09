import {Component, HostListener, Input, OnInit} from '@angular/core';

@Component({
  selector: 'asc-tooltip, [asc-tooltip]',
  templateUrl: './asc-tooltip.component.html',
  styleUrls: ['./asc-tooltip.component.css']
})
export class AscTooltipComponent implements OnInit {

  @Input('titre') 
  titre: string = "";
  
  isVisible: boolean = false;

  constructor() {
  }

  @HostListener('mouseenter')
  onMouseEnter() {
    this.isVisible = true;
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.isVisible = false;
  }

  ngOnInit() {
  }

}
