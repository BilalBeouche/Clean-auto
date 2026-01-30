import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Users } from '../model/Users.model';

const BASE_URL = "http://localhost:8080/cleanauto/api";
@Injectable({
  providedIn: 'root'
})
export class UserService {

  http = inject(HttpClient);

  constructor() { }

  createUser(userData: Users) {

    console.log("Utilisateur crée :", userData);
    return this.http.post<Users>(`${BASE_URL}/users`, userData);
  } 

  getUserById(userId : number, users: Users){
    return this.http.get(`${BASE_URL}/getUserById/${userId}`);
  }

  getAllUsers() {
    return this.http.get<Users[]>(`${BASE_URL}/allUsers`);
  }

  deleteUser(userId: number) {
    return this.http.delete<void>(`${BASE_URL}/deleteUser/${userId}`);
  }

  updateUser(userId: number, userData: Users) {
    return this.http.put<Users>(`${BASE_URL}/updateUser/${userId}`, userData);
  }
}
