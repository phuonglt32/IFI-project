import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectroleComponent } from './projectrole.component';

describe('ProjectroleComponent', () => {
  let component: ProjectroleComponent;
  let fixture: ComponentFixture<ProjectroleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectroleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectroleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
