import { Component, OnInit } from '@angular/core';
import { CountryService } from '../../services/country.service';
import { CommonModule } from '@angular/common';
import { CountryDetailComponent } from '../country-detail/country-detail.component';
import { FormsModule } from '@angular/forms';
import { SearchPipe } from '../../pipes/search.pipe';

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css'],
  standalone: true,
  imports: [CommonModule, CountryDetailComponent, FormsModule, SearchPipe]
})
export class CountryListComponent implements OnInit {
  countries: any[] = [];
  displayedCountries: any[] = [];
  selectedCountry: any = null;
  searchText: string = '';

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.loadCountries();
  }

  loadCountries() {
    this.countryService.getCountries().subscribe(
      (data: any[]) => {
        this.countries = data;
        this.updateDisplayedCountries();
      },
      (error) => console.error('Error fetching countries:', error)
    );
  }

  updateDisplayedCountries(): void {
    this.displayedCountries = this.countries.slice(0, 20);
  }

  viewCountryDetails(country: any) {
    this.selectedCountry = country;
  }

  goBack() {
    this.selectedCountry = null;
  }
  isLoggedIn(): boolean {
    return localStorage.getItem('loggedIn') === 'true';
  }
}
