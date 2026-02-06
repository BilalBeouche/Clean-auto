import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../../../auth/service/auth.service';
import { Users } from '../../../model/Users.model';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-profil',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './profil.component.html',
  styleUrl: './profil.component.css'
})
export class ProfilComponent implements OnInit {

  authService = inject(AuthService);
  userService = inject(UserService);
  fb = inject(FormBuilder);

  user!: Users;
  profileForm! : FormGroup;

  ngOnInit(): void {
    
    this.profileForm = this.fb.group({
      firstName : [""],
      lastName : [""],
      email : [""],
      phoneNumber : [""],
  
    })

    this.userService.getUserMe().subscribe({
      next: (data) => {
        this.user = data;
        console.log(this.user.email);

        this.profileForm.patchValue({
          firstName: data.firstName,
          lastName: data.lastName,
          phoneNumber: data.phoneNumber,
          email: data.email
        }
        )
      },
      error: (err) => {
        console.error('Erreur récupération utilisateur', err);
      }
    });



  }

  // ngOnInit(): void {

  //   // 1️⃣ Toujours créer le form AVANT
  //   this.profileForm = this.fb.group({
  //     firstName: [''],
  //     lastName: [''],
  //     email: [''],
  //     phoneNumber: ['']
  //   });

  //   // 2️⃣ Charger l'utilisateur connecté
  //   this.userService.getUserMe().subscribe({
  //     next: (data) => {
  //       this.user = data;

  //       // 3️⃣ Remplir le formulaire
  //       this.profileForm.patchValue({
  //         firstName: data.firstName,
  //         lastName: data.lastName,
  //         email: data.email,
  //         phoneNumber: data.phoneNumber
  //       });
  //     },
  //     error: (err) => {
  //       console.error('Erreur récupération utilisateur', err);
  //     }
  //   });
  // }
  
  
  onSubmit(){
    if(this.profileForm.invalid) return ;
    this.userService.updateUserMe(this.profileForm.value).subscribe({
      next : () => console.log("Profil mise à jours")
    })

  }
}