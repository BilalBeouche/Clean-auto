import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Prestations } from '../model/Prestations.model';

const BASE_URL = "http://localhost:8080/cleanauto/api/prestations" ;
@Injectable({
  providedIn: 'root'
})
export class PrestationService {

  http = inject(HttpClient);

  constructor() { }
  
  getAllPrestation(){
    
    return this.http.get<Prestations[]>(`${BASE_URL}/allPrestations`);

  }

  deletePrestation(){

  }


}
