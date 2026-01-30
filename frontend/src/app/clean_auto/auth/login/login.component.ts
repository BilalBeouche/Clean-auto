import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  authService = inject(AuthService);  
  route = inject(Router)

  email = "" ;
  password = "";

  err = "";
  succes = "";



  login(){
    this.authService.login(this.email, this.password).subscribe({
      next: (res : any)=>{
        localStorage.setItem('jwt', res.jwt);
        console.log("Token saved:", res.jwt, this.email, );
        this.succes = "Connection reussie !";
        this.err = "";
        this.route.navigate(['/home']);
   
      },
      error: (err : any)=>{
        this.err = err.error.message || "Email ou mot de passe incorrect";
        this.succes = "";
      }
    })
  }
}