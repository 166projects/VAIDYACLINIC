import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './LoginSignup/signup-component/signup-component.component';
import { LoginComponent } from './LoginSignup/login-component/login-component.component';
import { Routes, RouterModule } from '@angular/router';
import { Http, HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import {  ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginSignupServiceService } from './login-signup-service.service';
import { ReporterComponent } from './Reporter/reporter/reporter.component';
import { PatientComponent } from './Patient/patient/patient.component';
import { AdminComponent } from './Admin/admin/admin.component';
import { AddDoctorComponent } from './Admin/add-doctor/add-doctor.component';
import { AddSpecializationComponent } from './Admin/add-specialization/add-specialization.component';
import { GetAppointmentsComponent } from './Admin/get-appointments/get-appointments.component';
import { ApplyLeaveComponent } from './Doctor/apply-leave/apply-leave.component';
import { ViewAppointmentsComponent } from './doctor/view-appointments/view-appointments.component';
import { AddmemberComponent } from './Admin/addmember/addmember.component';
import { PatientServiceService } from 'src/app/patient-service.service';
import { DoctorServiceService } from 'src/app/doctor-service.service';
import { ReporterServiceService } from 'src/app/reporter-service.service';
import { AdminServiceService } from 'src/app/admin-service.service';

const appRoutes: Routes = [
{ path: 'signup', component: SignupComponent },
{ path: 'login', component: LoginComponent },
{ path: 'admin/adddoctor', component: AddDoctorComponent },
{path : 'addDoctor', component : AddDoctorComponent },
{ path: 'admin/addmember', component: AddmemberComponent },
{ path: 'patient', component: PatientComponent },
{ path: 'patient/applyLeave', component: ApplyLeaveComponent },
{ path : 'reporter', component : ReporterComponent},
{ path: 'admin', component: AdminComponent },
{ path : 'doctor', component: ViewAppointmentsComponent},
{ path : 'doctor/applyLeave', component: ApplyLeaveComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    ReporterComponent,
    PatientComponent,
    AdminComponent,
    AddDoctorComponent,
    AddSpecializationComponent,
    GetAppointmentsComponent,
    ApplyLeaveComponent,
    ViewAppointmentsComponent,
    AddmemberComponent,
    ReporterComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
   FormsModule, RouterModule.forRoot(appRoutes), 
    HttpModule,HttpClientModule 
 
  ],
  providers: [LoginSignupServiceService,PatientServiceService,DoctorServiceService
  ,ReporterServiceService,AdminServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
