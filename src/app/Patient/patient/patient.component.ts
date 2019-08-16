import { Component, OnInit } from '@angular/core';
import { Location } from '../../location';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { PatientServiceService } from '../../patient-service.service';
import { LoginSignupServiceService } from '../../login-signup-service.service';
import { Clinic } from '../../clinic';
import { Doctor } from '../../doctor';
import { Appointment } from '../../appointment';
import { Member } from '../../member';
import { Patient } from '../../patient';
@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {
  locationList: Location[];
  clinicList: Clinic[];
  doctorList: Doctor[];
  isLoadingResults = true;
  appointmentList: Appointment[];
  currentMember: Member;
  appointment: Appointment = new Appointment();
  doctor: Doctor = new Doctor();
  patient: string;
  memberId: string;

  constructor(private loginService: LoginSignupServiceService, private patientService: PatientServiceService, private route: ActivatedRoute, private router: Router,
  ) {

    this.currentMember = this.loginService.currentUserValue;
    this.memberId = this.currentMember.mId;
  }


  getLocation(): any {
    this.patientService.getLocations()
      .subscribe((data: any) => {
        this.locationList = data;
        console.log(this.locationList);
        this.isLoadingResults = false;
        this.getPatientByMemberId(this.memberId);

      });
  }

  getClinicByLocation(location_name: string): any {
    console.log(location_name);
    this.patientService.getClinicByLocation(location_name)
      .subscribe((data: any) => {
        this.clinicList = data;
        console.log(this.clinicList);
        this.isLoadingResults = false;
      });
  }
  getDoctorByClinic(clinic_name: string): any {
    this.patientService.getDoctorByClinic(clinic_name)
      .subscribe((data: any) => {
        this.doctorList = data;
        console.log(this.doctorList);
        this.isLoadingResults = false;
      });
  }

  getPatientByMemberId(mId: string): string {
   this.patientService.getPatientByMemberId(mId)
      .subscribe((data: any) => {
        this.patient = data;
        console.log(this.patient);
        this.isLoadingResults = false;
      });
      return this.patient;
  }


  addAppointment() {
    this.patientService.addAppointment(this.appointment).subscribe((data: any) => {
      const id = data._id;
    }, (error) => { console.log(error); });

  }


  onSubmit() {

    this.addAppointment();
  }

  ngOnInit() {
    this.getLocation();
  }


}
