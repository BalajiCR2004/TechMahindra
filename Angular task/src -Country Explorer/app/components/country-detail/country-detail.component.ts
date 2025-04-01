import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-country-detail',
  standalone: true,
  templateUrl: './country-detail.component.html',
  styleUrls: ['./country-detail.component.css'],
  imports: [CommonModule]  // ✅ Import CommonModule for Angular Pipes
})
export class CountryDetailComponent {
  @Input() country: any;  // ✅ Receive country data from parent
  @Output() back = new EventEmitter<void>();  // ✅ Emit event when back button is clicked

  goBack(): void {
    this.back.emit();  // ✅ Emit event to notify parent to reset selection
  }
}
