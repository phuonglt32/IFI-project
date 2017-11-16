import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectpersonComponent } from './projectperson.component';

describe('ProjectpersonComponent', () => {
  let component: ProjectpersonComponent;
  let fixture: ComponentFixture<ProjectpersonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectpersonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectpersonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
