import { Component, OnInit } from '@angular/core';
import { PatientServiceService } from '../../patient-service.service';
import { LoginSignupServiceService } from '../../login-signup-service.service';
import { AdminServiceService } from '../../admin-service.service';
import { Clinic } from '../../clinic';
import { Doctor } from '../../doctor';
import { Appointment } from '../../appointment';
import { Member } from '../../member';
import { Patient } from '../../patient';
import { Location } from '../../location';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  locationList: Location[];
  clinicList : Clinic[];
  clinicList1 : Clinic[];
  doctorList: Doctor[];
  isLoadingResults = true;
  doctor:Doctor= new Doctor();
  patient:string;
  appointmentList : Appointment[];
  constructor(private loginService: LoginSignupServiceService, private patientService: PatientServiceService , private adminService: AdminServiceService, private route: ActivatedRoute, private router: Router,
) {

  // this.currentMember = this.loginService.currentUserValue;
  // this.memberId = this.currentMember.mId;
}
  ngOnInit() {
    this.getAppointments();
  }

  getLocation(): any {
    this.patientService.getLocations()
      .subscribe((data: any) => {
        this.locationList = data;
        console.log(this.locationList);
        this.isLoadingResults = false;
      });
  }

  getClinics():any{
    this.adminService.getClinics()
    .subscribe((data: any) => {
      this.clinicList1 = data;
      console.log(this.clinicList1);
      this.isLoadingResults = false;
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

  
  getAppointments(): any {
    this.adminService.getAppointments()
      .subscribe((data: any) => {
        this.appointmentList = data;
        console.log(this.appointmentList);
        this.isLoadingResults = false;
      });
  }


}
