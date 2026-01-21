import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';


import { Router } from '@angular/router';
import { CreateUserRequest } from '../../../model/CreateUserRequest.model';
import { Users } from '../../../model/Users.model';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})

export class InscriptionComponent {

  private userService = inject(UserService);
  private fb = inject(FormBuilder);
  router = inject(Router);

  form = this.fb.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
    phoneNumber: ['', [Validators.required, Validators.pattern('^\\d{10}$')]]
  });

  // ✅ TOUT LE CODE DOIT ÊTRE DANS UNE MÉTHODE
  onSubmit() {

    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const payload: CreateUserRequest = {
      firstName: this.form.value.firstName!,
      lastName: this.form.value.lastName!,
      email: this.form.value.email!,
      password: this.form.value.password!,
      phoneNumber: this.form.value.phoneNumber!
    };

    this.userService.createUser(payload).subscribe({
      next: (response: Users) => {
        console.log('Utilisateur créé avec succes:', response);
        this.router.navigate(['/login']);
        // Après la création réussie, rediriger vers la page d'accueil ou de connexion

      },
      error: (error: any) => {
        console.error('Erreur lors de la création de l\'utilisateur:', error);
      }
    });
  }
}
