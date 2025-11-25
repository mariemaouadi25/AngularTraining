import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { trigger, transition, style, animate } from '@angular/animations';

interface Feedback {
  id: string;
  content: string;
  rate: number;
  date: string;
  createdAt: Date;
}

@Component({
  selector: 'app-form',
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
    ]),
    trigger('slideIn', [
      transition(':enter', [
        style({ opacity: 0, transform: 'translateX(-20px)' }),
        animate('400ms ease-out', style({ opacity: 1, transform: 'translateX(0)' }))
      ])
    ])
  ]
})
export class FormComponent implements OnInit {
  feedbackForm!: FormGroup;
  feedbacks: Feedback[] = [];
  isSubmitting = false;
  showSuccessMessage = false;
  hoverRating = 0;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.initForm();
    this.loadFeedbacks();
  }

  initForm(): void {
    this.feedbackForm = this.fb.group({
      content: ['', [
        Validators.required, 
        Validators.minLength(10), 
        Validators.maxLength(500)
      ]],
      rate: [null, [
        Validators.required, 
        Validators.min(1), 
        Validators.max(5)
      ]],
      date: [this.getTodayDate(), Validators.required]
    });
  }

  getTodayDate(): string {
    return new Date().toISOString().split('T')[0];
  }

  loadFeedbacks(): void {
    const stored = localStorage.getItem('eventfy_feedbacks');
    if (stored) {
      try {
        this.feedbacks = JSON.parse(stored);
      } catch (error) {
        console.error('Erreur lors du chargement des feedbacks', error);
        this.feedbacks = [];
      }
    }
  }

  saveFeedbacks(): void {
    localStorage.setItem('eventfy_feedbacks', JSON.stringify(this.feedbacks));
  }

  setRating(rating: number): void {
    this.feedbackForm.patchValue({ rate: rating });
    this.feedbackForm.get('rate')?.markAsTouched();
  }

  onSubmit(): void {
    if (this.feedbackForm.valid && !this.isSubmitting) {
      this.isSubmitting = true;

      const newFeedback: Feedback = {
        id: this.generateId(),
        content: this.feedbackForm.value.content.trim(),
        rate: this.feedbackForm.value.rate,
        date: this.feedbackForm.value.date,
        createdAt: new Date()
      };

      // Simuler un délai d'API (à remplacer par un vrai appel HTTP)
      setTimeout(() => {
        this.feedbacks.unshift(newFeedback);
        this.saveFeedbacks();
        
        // Réinitialiser le formulaire
        this.feedbackForm.reset({
          content: '',
          rate: null,
          date: this.getTodayDate()
        });
        
        // Marquer tous les champs comme non touchés
        Object.keys(this.feedbackForm.controls).forEach(key => {
          this.feedbackForm.get(key)?.markAsUntouched();
          this.feedbackForm.get(key)?.markAsPristine();
        });

        this.isSubmitting = false;
        this.showSuccessMessage = true;

        // Masquer le message de succès après 3 secondes
        setTimeout(() => {
          this.showSuccessMessage = false;
        }, 3000);
      }, 500);
    } else {
      // Marquer tous les champs comme touchés pour afficher les erreurs
      Object.keys(this.feedbackForm.controls).forEach(key => {
        this.feedbackForm.get(key)?.markAsTouched();
      });
    }
  }

  deleteFeedback(id: string): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce feedback ?')) {
      this.feedbacks = this.feedbacks.filter(fb => fb.id !== id);
      this.saveFeedbacks();
    }
  }

  isFieldInvalid(fieldName: string): boolean {
    const field = this.feedbackForm.get(fieldName);
    return !!(field && field.invalid && field.touched);
  }

  generateId(): string {
    return Date.now().toString(36) + Math.random().toString(36).substr(2);
  }
}