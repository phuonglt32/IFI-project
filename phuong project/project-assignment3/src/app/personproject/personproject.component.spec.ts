import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonprojectComponent } from './personproject.component';

describe('PersonprojectComponent', () => {
  let component: PersonprojectComponent;
  let fixture: ComponentFixture<PersonprojectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonprojectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonprojectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
