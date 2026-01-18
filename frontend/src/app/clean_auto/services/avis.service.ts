import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';


const BASE_URL = "http://localhost:8080/cleanauto/api/avis" ;
@Injectable({
  providedIn: 'root'
})
export class AvisService {

  http = inject(HttpClient);

  constructor() { }

  getAllAvis(){
    return this.http.get<any[]>(`${BASE_URL}/allAvis`);
  }
  
}
