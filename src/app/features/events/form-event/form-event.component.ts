import { Component } from '@angular/core';

@Component({
  selector: 'app-form-event',
  templateUrl: './form-event.component.html',
  styleUrl: './form-event.component.css'
})
export class FormEventComponent {


   // modèle lié au formulaire
  event = {
    title: '',
    date: '',
    price: 0,
    place: '',
    description: ''
  };

  // méthode appelée au submit
  onSubmit(form: any) {
    if (form.valid) {
      console.log('Événement ajouté :', this.event);
      alert('Événement ajouté avec succès ✅');
      form.reset();
    } else {
      console.warn('Formulaire invalide ❌');
    }
  }
}


