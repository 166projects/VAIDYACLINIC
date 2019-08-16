import { Injectable } from '@angular/core';
import {Member } from './Member';
import {Role } from './Role';
import {Clinic } from './Clinic';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Http, Headers } from '@angular/http';
import { catchError, tap } from 'rxjs/operators';
import { Observable, of, throwError } from 'rxjs';
import { Doctor } from './doctor';
import { Appointment } from './appointment';
@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  private  headers  =  new  Headers({ 'Content-Type': 'multipart/form-data' });
  
  baseUrl='http://localhost:8089/OnlineClinic/admin/addMember';
  
  constructor(private _http:HttpClient) { }

    addMember(member:Member) {
      console.log("service called");
      console.log(member);
      return this._http.post(`${this.baseUrl}`,member);
    }
   
    // addDoctor(doctor:Doctor) {
    //   baseUrl='http://localhost:8089/OnlineClinic/admin/addMember';
 
    //   console.log("service called");
    //   console.log(doctor);
    //   return this._http.post(`${this.baseUrl}`,doctor);
    // }
   

  getRoles(): Observable<Role[]> {
    const lurl = `http://localhost:8089/OnlineClinic/admin/roles`;
    return this._http.get<Role[]>(lurl)
    .pipe(tap(_ => console.log("in role"),
    catchError(this.handleError<Role[]>(`error`))
  ));
}


getAppointments(): Observable<Appointment[]> {
  const lurl = `http://localhost:8089/OnlineClinic/admin/appointments`;
  return this._http.get<Appointment[]>(lurl)
  .pipe(tap(_ => console.log("in appointment"),
  catchError(this.handleError<Appointment[]>(`error`))
));
}





getClinics(): Observable<Clinic[]> {
  const lurl = `http://localhost:8089/OnlineClinic/admin/clinics`;
  return this._http.get<Clinic[]>(lurl)
  .pipe(tap(_ => console.log("in clinic"),
  catchError(this.handleError<Clinic[]>(`error`))
));
}

private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    console.error(error);
    return of(result as T);
  };
}


}
