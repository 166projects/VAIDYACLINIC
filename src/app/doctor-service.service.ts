import { Injectable } from '@angular/core';
import { Leave } from './leave';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Http, Headers } from '@angular/http';
import { catchError, tap , map } from 'rxjs/operators';
import { Observable, of, throwError } from 'rxjs';
import { Appointment } from './appointment';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class DoctorServiceService {
private  headers  =  new  Headers({ 'Content-Type': 'multipart/form-data' });
baseUrl='http://localhost:8089/OnlineClinic/doctor/addLeave';

constructor(private _http:HttpClient) { }

  addLeave(leave: Leave) {
    console.log("service called");
    console.log(leave);
    return this._http.post(`${this.baseUrl}`,leave);
  }

  
  getAppointmentByDoctorAndDate(dId: string, date: string): Observable<Appointment[]> {
    const lurl = `http://localhost:8089/OnlineClinic/doctor/appointments/${dId}/${date}`;
    return this._http.get<Appointment[]>(lurl)
    .pipe(tap(_ => console.log("appointments for this doctor"),
    catchError(this.handleError<Appointment[]>(`error`))
  ));
}

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}
