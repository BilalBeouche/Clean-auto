import { Component, inject } from '@angular/core';
import { Avis } from '../../../model/Avis.model';
import { AvisService } from '../../../services/avis.service';

@Component({
  selector: 'app-avis',
  imports: [],
  templateUrl: './avis.component.html',
  styleUrl: './avis.component.css'
})
export class AvisComponent {
  
  avis : Avis[] = [];

  avisService = inject(AvisService);

  constructor() {

    this.avisService.getAllAvis().subscribe({
      next: (data) => this.avis = data,
      error: () => this.avis = []
    });
    
  }

}
