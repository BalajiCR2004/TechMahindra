import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:3000/users';

  constructor(private http: HttpClient) {}

  // ✅ Login: Check if email & password exist in db.json
  login(email: string, password: string): Observable<boolean> {
    return this.http.get<any[]>(this.apiUrl).pipe(
      map(users => {
        const user = users.find(u => u.email === email && u.password === password);
        if (user) {
          localStorage.setItem('loggedIn', 'true');
          return true;
        } else {
          return false;
        }
      })
    );
  }

  // ✅ Logout: Remove from localStorage
  logout(): void {
    localStorage.removeItem('loggedIn');
  }

  // ✅ Check if user is logged in
  isLoggedIn(): boolean {
    return localStorage.getItem('loggedIn') === 'true';
  }
}
