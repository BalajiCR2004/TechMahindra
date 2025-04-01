import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  standalone: true,
  imports: [FormsModule, HttpClientModule] // ✅ Required modules
})
export class SignupComponent {
  username: string = '';
  email: string = '';
  password: string = '';

  constructor(private http: HttpClient) {}

  onSubmit() {
    const user = { username: this.username, email: this.email, password: this.password };

    // ✅ POST request to save user data in db.json
    this.http.post('http://localhost:3000/users', user).subscribe(response => {
      console.log('✅ User saved:', response);
      alert('Signup successful!');
      
      // Clear input fields after signup
      this.username = '';
      this.email = '';
      this.password = '';
    }, error => {
      console.error('❌ Error saving user:', error);
    });
  }
}
