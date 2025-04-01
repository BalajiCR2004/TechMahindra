import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators,ReactiveFormsModule } from '@angular/forms';
import { ReviewService } from '../services/review.service';
import {CommonModule} from '@angular/common'; 

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css'],
  standalone: true,
  imports:[ReactiveFormsModule,CommonModule]
})
export class ReviewComponent {
  reviewForm: FormGroup;
  reviews: any[] = [];

  constructor(private fb: FormBuilder, private reviewService: ReviewService) {
    this.reviewForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required, Validators.email]],
      rating: ['', [Validators.required, Validators.min(1), Validators.max(5)]],
      review: ['', [Validators.required, Validators.minLength(10)]]
    });

    this.loadReviews(); // Load reviews on component initialization
  }

  // ✅ Load all reviews from the database
  loadReviews() {
    this.reviewService.getReviews().subscribe((data) => {
      this.reviews = data;
    });
  }

  // ✅ Submit a new review
  submitReview() {
    if (this.reviewForm.valid) {
      this.reviewService.addReview(this.reviewForm.value).subscribe(() => {
        alert('Review Submitted Successfully! ✅');
        this.reviewForm.reset();
        this.loadReviews(); // Refresh reviews
      });
    } else {
      alert('Please fill out all required fields correctly! ❌');
    }
  }
}
