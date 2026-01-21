import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { jwtDecode } from 'jwt-decode';


const BASEURL = 'http://localhost:8080/cleanauto/api/auth';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private TOKEN_KEY = 'jwt';

  http = inject(HttpClient);
  constructor() { }


  login(email: string, password: string) {
    return this.http.post<{token: string}>(`${BASEURL}/login`, {email, password})
    
  }
  
  saveToken(jwt: string): void {
    localStorage.setItem(this.TOKEN_KEY, jwt);
  }

  getToken(): string | null {
    return localStorage.getItem(this.TOKEN_KEY);
  }

  isLoggedIn(): boolean {
    return this.getToken() !== null;
  }

  logout(): void { 
    localStorage.removeItem(this.TOKEN_KEY);
  }

  getUser(): any{
    const token = this.getToken();
    if (!token) {
      return null;
    }
    return jwtDecode<any>(token);
  }

  getUserName(): string  {
    const user = this.getUser();
    return user ? user.sub : '';
  }


}
