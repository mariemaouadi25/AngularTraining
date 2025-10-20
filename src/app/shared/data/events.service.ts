import { Injectable } from '@angular/core';
import { Eventy } from '../../models/eventy';

@Injectable({
  providedIn: 'root'
})
export class EventsService {
  list: Eventy[] = [
    {
      id: 1,
      title: 'Angular Training',
      description: 'Angular v18',
      date: new Date('2025-11-10'),
      location: 'Tunis',
      price: 50,
      organizerId: 10,
      imageUrl: 'https://th.bing.com/th/id/OIP.58BA6h6N8hyKCe2O9S5NwAHaD4?w=329&h=180&c=7&r=0&o=7&pid=1.7&rm=3',
      nbPlaces: 5,
      nbrLike: 30,
    },
    {
      id: 2,
      title: 'Symfony Training',
      description: 'Symfony Training V6',
      date: new Date('2025-12-10'),
      location: 'Tunis',
      price: 50,
      organizerId: 10,
      imageUrl: 'https://th.bing.com/th/id/OIP.58BA6h6N8hyKCe2O9S5NwAHaD4?w=329&h=180&c=7&r=0&o=7&pid=1.7&rm=3',
      nbPlaces: 0,
      nbrLike: 0,
    },
    {
      id: 3,
      title: 'AI Future Forum',
      description: 'Conférence internationale sur l’intelligence artificielle et ses applications.',
      date: new Date('2025-12-02'),
      location: 'Sousse',
      price: 80,
      organizerId: 103,
      imageUrl: 'https://marcopoloexperience.com/wp-content/uploads/2024/05/digitalfutureforum3-marcopoloexperience.png',
      nbPlaces: 50,
      nbrLike: 12
    },
    {
      id: 4,
      title: 'UX Design Expo',
      description: 'Atelier interactif sur l’expérience utilisateur et le design thinking.',
      date: new Date('2025-10-25'),
      location: 'Nabeul',
      price: 40,
      organizerId: 104,
      imageUrl: 'https://www.comyweb.fr/images/blog/ux-design.jpg',
      nbPlaces: 18,
      nbrLike: 6
    },
    {
      id: 5,
      title: 'CyberSec Challenge',
      description: 'Compétition nationale sur la cybersécurité et le hacking éthique.',
      date: new Date('2025-11-22'),
      location: 'Sfax',
      price: 20,
      organizerId: 105,
      imageUrl: 'https://i.pinimg.com/736x/2b/79/82/2b79823e7488ad86b38afe9c14bfd0ca.jpg',
      nbPlaces: 30,
      nbrLike: 9
    },
    {
      id: 6,
      title: 'Cloud & DevOps Summit',
      description: 'Séminaire sur l’automatisation, les pipelines CI/CD et le cloud computing.',
      date: new Date('2026-01-20'),
      location: 'Sousse',
      price: 60,
      organizerId: 108,
      imageUrl: 'https://i.pinimg.com/736x/25/85/eb/2585eb72e15356116ab53981963aa0db.jpg',
      nbPlaces: 45,
      nbrLike: 4
    },
    {
      id: 7,
      title: 'Green Tech Expo',
      description: 'Salon des technologies vertes et durables pour un futur écologique.',
      date: new Date('2025-12-10'),
      location: 'Gabès',
      price: 25,
      organizerId: 109,
      imageUrl: 'https://i.pinimg.com/736x/dc/cc/2d/dccc2de8fc81583814718694bdd1e689.jpg',
      nbPlaces: 40,
      nbrLike: 8
    },

    {
      id: 8,
      title: 'HealthTech Innovation Day',
      description: 'Forum sur les nouvelles technologies au service de la santé.',
      date: new Date('2025-09-12'),
      location: 'Sousse',
      price: 35,
      organizerId: 111,
      imageUrl: 'https://i.pinimg.com/736x/18/34/18/1834186c75c9142cb6c571f5fbb141d3.jpg',
      nbPlaces: 0,
      nbrLike: 7
    },

    {
      id: 9,
      title: 'Data Science Camp',
      description: 'Atelier intensif sur le machine learning et la visualisation de données.',
      date: new Date('2025-12-05'),
      location: 'Hammamet',
      price: 55,
      organizerId: 113,
      imageUrl: 'https://engineering.nyu.edu/sites/default/files/styles/content_header_default_1x/public/2022-02/Data%20Science%20Bootcamp%20%281%29.jpg?h=2f83cd36&itok=qIg5KFwK',
      nbPlaces: 35,
      nbrLike: 10
    }

  ];

  constructor() { }

  getAllEvents() {
    // Simulation d’un appel backend
    return this.list;
  }

  // ✅ Correction ici : on retourne un Eventy ou undefined
  public getEventById(id: number): Eventy | undefined {
    return this.list.find(event => event.id === id);
  }
}
