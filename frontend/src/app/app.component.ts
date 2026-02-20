import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from "./header/navbar/navbar.component";

@Component({
  selector: 'app-root',
  standalone: true,           // <-- important pour Angular standalone
  imports: [RouterModule, NavbarComponent, FooterComponent],     // <-- permet d'utiliser routerLink et routerLinkActive
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'nettoyage-auto';

  searchText = "";
}