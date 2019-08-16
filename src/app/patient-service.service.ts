import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Clinic } from 'src/app/clinic';
import { Doctor } from 'src/app/doctor';
import { Appointment } from './appointment';
import { Patient } from 'src/app/patient';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class PatientServiceService {
  
  baseUrl='http://localhost:8089/OnlineClinic/admin/addAppointment';
  
  constructor(private _http:HttpClient) { }

  getLocations(): Observable<Location[]> {
    const lurl = `http://localhost:8089/OnlineClinic/admin/locations`;
    return this._http.get<Location[]>(lurl)
    .pipe(tap(_ => console.log("in location"),
    catchError(this.handleError<Location[]>(`error`))
  ));
}


getClinicByLocation(location_name:string): Observable<Clinic[]> {
  const lurl = `http://localhost:8089/OnlineClinic/admin/clinics/${location_name}`;
  return this._http.get<Clinic[]>(lurl)
    .pipe(tap(_ => console.log(`location selected${location_name}`)),
    catchError(this.handleError<Clinic[]>(`error`))
  );
        
}

getDoctorByClinic(clinic_name:string): Observable<Doctor[]> {
  const lurl = `http://localhost:8089/OnlineClinic/admin/doctors/${clinic_name}`;
  return this._http.get<Doctor[]>(lurl)
    .pipe(tap(_ => console.log(`clinic selected${clinic_name}`)),
    catchError(this.handleError<Doctor[]>(`error`))
  );
}

  getPatientByMemberId(mId:string): Observable<string> {
    const lurl = `http://localhost:8089/OnlineClinic/patient/patients/${mId}`;
   console.log("in service");
    return this._http.get<string>(lurl)
      .pipe(tap(data => console.log(data)),
      catchError(this.handleError<string>(`error`))
    );
  }
    addAppointment(appointment:Appointment):Observable<any> {
      console.log("service called");
      console.log(appointment);
      return this._http.post(`${this.baseUrl}`,appointment);
    }
    
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
  
      return of(result as T);
    };
  }



}
