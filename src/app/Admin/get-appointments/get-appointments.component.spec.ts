import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAppointmentsComponent } from './get-appointments.component';

describe('GetAppointmentsComponent', () => {
  let component: GetAppointmentsComponent;
  let fixture: ComponentFixture<GetAppointmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetAppointmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
