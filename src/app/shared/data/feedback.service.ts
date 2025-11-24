import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Feedback } from '../../models/feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  // etape 0 : import de httpClientModule dans appModule
  // etape 1 : define the urlBackend 
  urlBackend="http://localhost:3000/feedbacks/";
  // etape 2 : inject the httpClientService
  constructor(private httpClient:HttpClient) { 

  }

  // etape 3 : preparer l'entite model sous le dossier model
 createFeedback(fb: Feedback) { return this.httpClient.post<Feedback>(this.urlBackend, fb); }
getFeedbacks() { return this.httpClient.get<Feedback[]>(this.urlBackend); }
deleteFeedback(id: number) { return this.httpClient.delete(`${this.urlBackend}${id}`); }
updateFeedback(fb: Feedback) { return this.httpClient.put<Feedback>(`${this.urlBackend}${fb.id}`, fb); }

}
