import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { CountryListComponent } from './components/country-list/country-list.component';
import { CountryListLimitedComponent } from './components/country-list-limited/country-list-limited.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { ReviewComponent } from './review/review.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'countries-limited', component: CountryListLimitedComponent },
  { path: 'countries', component: CountryListComponent }, // ✅ No AuthGuard
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'review', component: ReviewComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    CountryListComponent,
    CountryListLimitedComponent,
    LoginComponent,
    SignupComponent,
    ReactiveFormsModule,
    ReviewComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
