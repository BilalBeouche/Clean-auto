import { AfterViewInit, Component } from '@angular/core';

declare global {
  interface Window {
    Calendly: any;
  }
}

@Component({
  selector: 'app-reservation',
  imports: [],
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.css'
})
export class ReservationComponent implements AfterViewInit{

 ngAfterViewInit(): void {
    
    if (window.Calendly) {
      window.Calendly.initInlineWidget({
        url: 'https://calendly.com/beouchebilal91/2h',
        parentElement: document.getElementById('calendly-container'),
        height: 700
      });
    }
    console.log('Calendly:', window.Calendly);
  }



}
