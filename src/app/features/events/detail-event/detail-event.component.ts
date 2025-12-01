import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Eventy } from '../../../models/eventy';
import { FeedbackService } from '../../../shared/data/feedback.service';
import { Feedback } from '../../../models/feedback';
import {CardComponent} from '../../../layout/Card/card.component';
import {EventsService} from '../../../shared/data/events.service';

@Component({
  selector: 'app-detail-event',
  templateUrl: './detail-event.component.html',
  styleUrls: ['./detail-event.component.css'],
  standalone: true,
  imports: [CommonModule, RouterModule, CardComponent]
})
export class DetailEventComponent implements OnInit {

  currentEvent!: Eventy;
  feedbacks: Feedback[] = [];
  localEvents: Eventy[] = [];

  constructor(
    private route: ActivatedRoute,
    private eventsService: EventsService,
    private feedbackService: FeedbackService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.params['id']);

    // 1️⃣ Charger l'événement courant
    this.eventsService.getEventById(id).subscribe({
      next: (event: Eventy) => {
        this.currentEvent = event;

        // Charger les feedbacks
        this.loadFeedbacks(id);

        // Charger les événements du même lieu
        this.loadLocalEvents(event.location, event.id);
      },
      error: (err: any) => console.error("Erreur chargement événement :", err)
    });
  }

  // Charger les feedbacks pour l'événement courant
  private loadFeedbacks(eventId: number): void {
    this.feedbackService.getFeedbacksByEvent(eventId).subscribe({
      next: (data: Feedback[]) => this.feedbacks = data,
      error: (err: any) => console.error("Erreur chargement feedbacks :", err)
    });
  }

  // Charger les événements dans le même lieu
  private loadLocalEvents(location: string, currentId: number): void {
    this.eventsService.searchByLocation(location).subscribe({
      next: (events: Eventy[]) => {
        this.localEvents = events.filter(e => e.id !== currentId); // exclure l'événement courant
      },
      error: (err: any) => console.error("Erreur chargement événements locaux :", err)
    });
  }
}
