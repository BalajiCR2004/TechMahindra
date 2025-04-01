import { TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';
import { AuthGuard } from './auth.guard';

describe('AuthGuard', () => {
  let authGuard: AuthGuard;
  let routerSpy = { navigate: jasmine.createSpy('navigate') };

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuthGuard, { provide: Router, useValue: routerSpy }]
    });
    authGuard = TestBed.inject(AuthGuard);
  });

  it('should be created', () => {
    expect(authGuard).toBeTruthy();
  });

  it('should allow access if user is logged in', () => {
    localStorage.setItem('loggedIn', 'true'); // Simulate user login
    expect(authGuard.canActivate()).toBeTrue();
  });

  it('should block access and redirect to login if user is not logged in', () => {
    localStorage.removeItem('loggedIn'); // Simulate user logout
    expect(authGuard.canActivate()).toBeFalse();
    expect(routerSpy.navigate).toHaveBeenCalledWith(['/login']);
  });
});
