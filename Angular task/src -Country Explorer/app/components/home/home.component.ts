import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone:false
})
export class HomeComponent {

  constructor(private router: Router) {}

  goToCountries() {
    this.router.navigate(['/countries-limited']); // ✅ Ensure this route matches your app's routing module
  }
}
