import { Component, inject, input, OnInit, output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from "@angular/router";
import { AuthService } from '../../clean_auto/auth/service/auth.service';
import { Users } from '../../clean_auto/model/Users.model';
import { ProfileService } from '../../clean_auto/services/profile.service';

@Component({
  selector: 'app-navbar',
  imports: [FormsModule, RouterLink],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent implements OnInit {

  authService = inject(AuthService);
  userService = inject(ProfileService)
  user!: Users;
  router = inject(Router);

  search = input("initial");
  searchChange = output<string>();
 
  
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
    this.router.navigate(["/home"])
   
  }

  // click = 0
  // clickedSearch(){

  //   this.click += 1
  //   console.log("cliquer");
  // }

  // updateSearch(searchText: string){
  //   this.searchChange.emit(searchText);

  // }


}
