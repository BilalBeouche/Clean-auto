import { Component, inject, OnInit } from '@angular/core';
import { RouterLink } from "@angular/router";
import { AuthService } from '../../clean_auto/auth/service/auth.service';
import { Users } from '../../clean_auto/model/Users.model';
import { ProfileService } from '../../clean_auto/services/profile.service';

@Component({
  selector: 'app-navbar',
  imports: [RouterLink],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {

  authService = inject(AuthService);
  userService = inject(ProfileService)
  user!: Users;

  
ngOnInit(): void {
  this.userService.getUserMe().subscribe({
    next : (data) => {
      this.user = data;
    }, 
    error: () => console.log("err lors de la recupération du nom de profile")
  })
}
  logout(){
    this.authService.logout();
  }

  

}
