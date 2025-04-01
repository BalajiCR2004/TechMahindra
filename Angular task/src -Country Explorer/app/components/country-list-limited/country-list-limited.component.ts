import { Component, OnInit } from '@angular/core';
import { CountryService } from '../../services/country.service';
import { CommonModule } from '@angular/common';
import { CountryDetailComponent } from '../country-detail/country-detail.component';
import { FormsModule } from '@angular/forms';
import { SearchPipe } from '../../pipes/search.pipe';

@Component({
  selector: 'app-country-list-limited',
  templateUrl: './country-list-limited.component.html',
  styleUrls: ['./country-list-limited.component.css'],
  standalone: true,
  imports: [CommonModule, CountryDetailComponent, FormsModule, SearchPipe]
})
export class CountryListLimitedComponent implements OnInit {
  countries: any[] = [];
  displayedCountries: any[] = [];
  selectedCountry: any = null;
  searchText: string = '';

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.countryService.getCountries().subscribe(
      (data: any[]) => {
        this.countries = data;
        this.updateDisplayedCountries();
      },
      (error) => {
        console.error('❌ Error fetching countries:', error);
      }
    );
  }

  updateDisplayedCountries(): void {
    this.displayedCountries = this.countries.slice(0, 20);
  }

  viewCountryDetails(country: any): void {
    this.selectedCountry = country;
  }

  goBack(): void {
    this.selectedCountry = null;
  }
}
