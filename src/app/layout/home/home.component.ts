import { Component, OnInit } from '@angular/core';
import { CardComponent } from '../Card/card.component';
import { Eventy } from '../../models/eventy';
import { EventsService } from '../../shared/data/events.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CardComponent
  ]
})
export class HomeComponent implements OnInit {
  list: Eventy[] = [];     // tous les événements
  topList: Eventy[] = [];  // top 3 par likes
  searchValue: string = ''; // pour filtrage éventuel

  constructor(private service: EventsService) {}

  ngOnInit(): void {
    this.service.getAllEvents().subscribe({
      next: (events: Eventy[]) => {
        this.list = events;

        // Trier par nbrLike décroissant et prendre les 3 premiers
        this.topList = events
          .sort((a, b) => b.nbrLike - a.nbrLike)
          .slice(0, 3);
      },
      error: (err) => console.error('Erreur récupération événements', err)
    });
  }
}
