import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[bg-black]'
})
export class BgBlackDirective {

  constructor(private el: ElementRef, private renderer: Renderer2) { 
    renderer.setStyle(el.nativeElement, "backgroundColor", "black");
    renderer.setStyle(el.nativeElement, "color", "white");
  }

}
