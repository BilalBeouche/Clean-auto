import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { AuthService } from '../../../auth/service/auth.service';
import { Avis } from '../../../model/Avis.model';
import { AvisService } from '../../../services/avis.service';

@Component({
  selector: 'app-avis',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './avis.component.html',
  styleUrl: './avis.component.css'
})
export class AvisComponent implements OnInit {
avis: Avis[] = [];
afficherAvis: Avis[] = [];

avisService = inject(AvisService);
authService = inject(AuthService);
router = inject(Router);
private fb = inject(FormBuilder);

isHomePage(): boolean {
  return this.router.url === '/home';
}

avisForm!: FormGroup;

succes = "";
err = "";

ngOnInit(): void {

  this.avisForm = this.fb.group({
    commentaire: ['', [Validators.required, Validators.minLength(10)]],
    note: [5, [Validators.required, Validators.min(1), Validators.max(10)]],
    dateAvis: [new Date().toISOString()] // ✅ fonction appelée
  });

  this.avisService.getAllAvis().subscribe({
    next: (data) => {
      this.avis = data;

      // ✅ Trier par date DESC + prendre les 4 derniers
      this.afficherAvis = [...this.avis]
        .sort((a, b) =>
          new Date(b.dateAvis).getTime() - new Date(a.dateAvis).getTime()
        )
        .slice(0, 4);
    },
    error: () => {
      this.avis = [];
      this.afficherAvis = [];
    }
  });
}


onSubmit(): void {
  if (this.avisForm.invalid) {
    this.avisForm.markAllAsTouched();
    return;
  }

  this.avisService.createAvis(this.avisForm.value).subscribe({
    next: (avis) => {
      console.log('Avis créé', avis);
      this.avisService.getAllAvis();
      this.avisForm.reset({ note: 5 });
      this.succes = "avis créer"
    },
    error: (err) => {
      console.error('Erreur création avis', err);
      this.err =" votre avis n'as pas etait publier"    }
  });
  
}
}
