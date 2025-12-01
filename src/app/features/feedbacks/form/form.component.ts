import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CardComponent } from '../../../layout/Card/card.component';
import { trigger, transition, style, animate } from '@angular/animations';
import {Eventy} from '../../../models/eventy';
import {EventsService} from '../../../shared/data/events.service';

interface Feedback {
  id: string;
  content: string;
  rate: number;
  date: string;
  createdAt: Date;
  eventId: number;
}

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CardComponent
  ],
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
  animations: [
    trigger('fadeInOut', [
      transition(':enter', [
        style({ opacity: 0, transform: 'translateY(-20px)' }),
        animate('300ms ease-out', style({ opacity: 1, transform: 'translateY(0)' }))
      ]),
      transition(':leave', [
        animate('300ms ease-in', style({ opacity: 0, transform: 'translateY(-20px)' }))
      ])
    ])
  ]
})
export class FormComponent implements OnInit {

  feedbackForm!: FormGroup;
  feedbacks: Feedback[] = [];
  currentEvent!: Eventy;
  samePlaceEvents: Eventy[] = [];
allEvents: Eventy[] = [];
  showSuccessMessage = false;
  isSubmitting = false;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private eventsService: EventsService
  ) {}

  ngOnInit(): void {
    this.initForm();
    this.loadCurrentEvent();
    this.loadAllEvents();
  }

  initForm(): void {
    this.feedbackForm = this.fb.group({
      content: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(500)]],
      rate: [1, [Validators.required, Validators.min(1), Validators.max(5)]],
      date: [this.getTodayDate(), Validators.required]
    });
  }

  getTodayDate(): string {
    return new Date().toISOString().split('T')[0];
  }

  /* Charger événement courant et feedbacks */
  loadCurrentEvent(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.eventsService.getEventById(id).subscribe((event: Eventy) => {
      this.currentEvent = event;
      this.loadFeedbacks(event.id);

      this.eventsService.getAllEvents().subscribe((all: Eventy[]) => {
        this.samePlaceEvents = all.filter(e =>
          e.location === event.location && e.id !== event.id
        );
      });
    });
  }

  loadAllEvents(): void {
    this.eventsService.getAllEvents().subscribe((all: Eventy[]) => {
      this.allEvents = all;
    });
  }

  loadFeedbacks(eventId: number): void {
    const stored = localStorage.getItem('eventfy_feedbacks');
    if (stored) {
      const all = JSON.parse(stored) as Feedback[];
      this.feedbacks = all.filter(f => f.eventId === eventId);
    }
  }

  saveFeedbacks(): void {
    const stored = localStorage.getItem('eventfy_feedbacks');
    let all: Feedback[] = stored ? JSON.parse(stored) : [];
    all = all.filter(f => f.eventId !== this.currentEvent.id);
    all.push(...this.feedbacks);
    localStorage.setItem('eventfy_feedbacks', JSON.stringify(all));
  }

  onSubmit(): void {
    if (!this.feedbackForm.valid || this.isSubmitting) {
      this.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;
    const newFeedback: Feedback = {
      id: Date.now().toString(36) + Math.random().toString(36).substring(2),
      content: this.feedbackForm.value.content.trim(),
      rate: this.feedbackForm.value.rate,
      date: this.feedbackForm.value.date,
      createdAt: new Date(),
      eventId: this.currentEvent.id
    };

    setTimeout(() => {
      this.feedbacks.unshift(newFeedback);
      this.saveFeedbacks();
      this.feedbackForm.reset({ content: '', rate: 1, date: this.getTodayDate() });
      this.isSubmitting = false;
      this.showSuccessMessage = true;
      setTimeout(() => this.showSuccessMessage = false, 3000);
    }, 300);
  }

  deleteFeedback(id: string): void {
    this.feedbacks = this.feedbacks.filter(f => f.id !== id);
    this.saveFeedbacks();
  }

  isFieldInvalid(fieldName: string): boolean {
    const field = this.feedbackForm.get(fieldName);
    return !!(field && field.invalid && field.touched);
  }

  markAllAsTouched(): void {
    Object.keys(this.feedbackForm.controls).forEach(key => {
      this.feedbackForm.get(key)?.markAsTouched();
    });
  }

  createArray(n: number): number[] {
    return Array.from({ length: n }, (_, i) => i);
  }
}
