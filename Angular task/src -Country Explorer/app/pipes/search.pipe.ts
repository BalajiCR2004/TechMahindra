import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search',
  standalone: true
})
export class SearchPipe implements PipeTransform {
  transform(countries: any[], searchText: string): any[] {
    if (!countries || !searchText) {
      return countries;  // Return all countries if search is empty
    }
    searchText = searchText.toLowerCase();
    return countries.filter(country =>
      country.name.common.toLowerCase().includes(searchText)
    );
  }
}
