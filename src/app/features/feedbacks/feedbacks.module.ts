import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { FeedbacksRoutingModule } from './feedbacks-routing.module';
import { FeedbacksComponent } from './feedbacks.component';
import { FormComponent } from './form/form.component';

@NgModule({
  declarations: [
    FeedbacksComponent,
    FormComponent
  ],
  imports: [
    CommonModule,
    FeedbacksRoutingModule,
    FormsModule,
    ReactiveFormsModule  // ✅ Nécessaire pour les formulaires réactifs
  ]
})
export class FeedbacksModule { }