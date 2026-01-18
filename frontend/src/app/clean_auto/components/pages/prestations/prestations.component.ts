import { Component, inject } from '@angular/core';
import { RouterLink } from "@angular/router";
import { Prestations } from '../../../model/Prestations.model';
import { PrestationService } from '../../../services/prestation.service';

@Component({
  selector: 'app-prestations',
  imports: [RouterLink],
  templateUrl: './prestations.component.html',
  styleUrl: './prestations.component.css'
})
export class PrestationsComponent {

  prestations: Prestations[] = [];

  prestationService = inject(PrestationService)

   constructor() {
    this.prestationService.getAllPrestation().subscribe({
      next: (data) => this.prestations = data,
      error: () => this.prestations = []  
    });
  }

}
