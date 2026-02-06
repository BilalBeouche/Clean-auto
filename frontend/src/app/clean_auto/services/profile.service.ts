import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Users } from '../model/Users.model';



const BASE_URL = "http://localhost:8080/cleanauto/api";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  http = inject(HttpClient);

  constructor() { }

    updateUserMe(userData: Users){
    return this.http.put<Users>(`${BASE_URL}/updateMe`,userData)
  }
  

  getUserMe(){
    return this.http.get<Users>(`${BASE_URL}/me`)
  }
}
