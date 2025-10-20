import { Directive, ElementRef, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: '[ngHover]'  // ⚠️ toujours en minuscule pour le selector
})
export class NgHoverDirective {

  constructor(private el: ElementRef, private renderer: Renderer2) { }

  // Lorsque la souris entre : zoom + transition
  @HostListener('mouseenter') onMouseEnter() {
    this.renderer.setStyle(this.el.nativeElement, 'transform', 'scale(1.05)');
    this.renderer.setStyle(this.el.nativeElement, 'transition', 'transform 0.3s ease');
    this.renderer.setStyle(this.el.nativeElement, 'cursor', 'pointer'); // optionnel
  }

  // Lorsque la souris quitte : retour à la taille normale
  @HostListener('mouseleave') onMouseLeave() {
    this.renderer.setStyle(this.el.nativeElement, 'transform', 'scale(1)');
  }

  // Optionnel : zoom supplémentaire si clic
  @HostListener('click') onClick() {
    this.renderer.setStyle(this.el.nativeElement, 'transform', 'scale(1.1)');
    setTimeout(() => {
      this.renderer.setStyle(this.el.nativeElement, 'transform', 'scale(1.05)');
    }, 200); // revenir après 200ms
  }
}
