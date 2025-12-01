// feedbacks.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { FeedbacksRoutingModule } from './feedbacks-routing.module';
import { FeedbacksComponent } from './feedbacks.component';
import { FormComponent } from './form/form.component';  // composant classique


@NgModule({
  declarations: [
    FeedbacksComponent// ✅ déclarer le composant ici, pas dans imports
  ],
  imports: [
    CommonModule,
    FeedbacksRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    FormComponent
    ReactiveFormsModule  // ✅ Nécessaire pour les formulaires réactifs
  ]
})
export class FeedbacksModule { }