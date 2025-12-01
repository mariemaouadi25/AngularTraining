import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Eventy } from '../../models/eventy';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  // Événement obligatoire à afficher
  @Input() event!: Eventy;

  // Filtrage optionnel depuis le parent
  @Input() searchValue?: string;

  // Incrémenter le nombre de likes
  nbrLike(event: Eventy) {
    event.nbrLike++;
  }

  // Décrémenter le nombre de places restantes
  nbrPlaceDecr(event: Eventy) {
    if (event.nbPlaces > 0) {
      event.nbPlaces--;
    }
  }
}
