import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CountryListLimitedComponent } from './components/country-list-limited/country-list-limited.component';
import { CountryListComponent } from './components/country-list/country-list.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { AuthGuard } from './guard/auth.guard'; // Adjusted import path
import { ReviewComponent } from './review/review.component';

const routes: Routes = [
  { path: '', redirectTo: '/countries-limited', pathMatch: 'full' },
  { path: 'countries-limited', component: CountryListLimitedComponent },
  { path: 'countries', component: CountryListComponent, canActivate: [AuthGuard] }, // ✅ Apply AuthGuard here
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'review', component: ReviewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
