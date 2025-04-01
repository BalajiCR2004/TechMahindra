import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
  standalone: false
})
export class NavBarComponent {
  constructor(private router: Router) {}

  isLoggedIn(): boolean {
    return localStorage.getItem('loggedIn') === 'true';
  }

  logout(): void {
    localStorage.removeItem('loggedIn'); // ✅ Remove login status
    this.router.navigate(['/login']); // 🚀 Redirect to login
  }
}
