import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';


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

  createAvis(avis : any) :Observable<any>{
    return this.http.post(`${BASE_URL}/createAvis`, avis);
  }

  updateAvis(avis : any){
    return this.http.put(`${BASE_URL}/updateAvis`, avis)
  }
}
