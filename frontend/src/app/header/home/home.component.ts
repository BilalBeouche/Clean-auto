import { Component } from '@angular/core';
import { AvisComponent } from '../../clean_auto/components/pages/avis/avis.component';
import { PrestationsComponent } from '../../clean_auto/components/pages/prestations/prestations.component';

@Component({
  selector: 'app-home',
  imports: [PrestationsComponent, AvisComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
