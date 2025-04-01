import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone: true,
  imports: [FormsModule, CommonModule]
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  loginError: string = '';

  constructor(private userService: UserService, private router: Router) {}

  login() {
    this.userService.login(this.email, this.password).subscribe(
      (isValidUser) => {
        if (isValidUser) {
          console.log('✅ User logged in successfully!');
          localStorage.setItem('loggedIn', 'true');
          this.router.navigate(['/countries']);
        } else {
          this.loginError = 'Invalid email or password!';
        }
      },
      (error) => {
        console.error('Login Error:', error);
        this.loginError = 'Something went wrong!';
      }
    );
  }
}

