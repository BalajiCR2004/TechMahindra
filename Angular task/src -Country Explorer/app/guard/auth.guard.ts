import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const isLoggedIn = localStorage.getItem('loggedIn') === 'true'; // ✅ Ensure it checks against "true"
    
    if (isLoggedIn) {
      return true; // ✅ Allow access if logged in
    } else {
      this.router.navigate(['/login']); // 🚫 Redirect to login if not logged in
      return false;
    }
  }
}
