import { Routes } from '@angular/router';
import { LoginComponent } from './clean_auto/auth/login/login.component';
import { AvisComponent } from './clean_auto/components/pages/avis/avis.component';
import { InscriptionComponent } from './clean_auto/components/pages/inscription/inscription.component';
import { PrestationsComponent } from './clean_auto/components/pages/prestations/prestations.component';
import { ReservationComponent } from './clean_auto/components/pages/reservation/reservation.component';
import { HomeComponent } from './header/home/home.component';



export const routes: Routes = [  // ✅ mot-clé "export" ajouté ici
  {path:"",redirectTo:'home' ,pathMatch:'full'},
  {path: 'home', component: HomeComponent },
  {path: "prestations", component: PrestationsComponent},
  {path: "reservations", component : ReservationComponent},
  {path: "avis", component : AvisComponent},
  {path:"inscription", component: InscriptionComponent},
  {path:"login", component : LoginComponent}
 
];