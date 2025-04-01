import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountryListLimitedComponent } from './country-list-limited.component';

describe('CountryListLimitedComponent', () => {
  let component: CountryListLimitedComponent;
  let fixture: ComponentFixture<CountryListLimitedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CountryListLimitedComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CountryListLimitedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
