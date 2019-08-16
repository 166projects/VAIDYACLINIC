import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Leave } from './leave';
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})


export class ReporterServiceService {
  
  constructor(private _http:HttpClient) { }
  baseUrl='http://localhost:8089/OnlineClinic/reporter/approveLeave';
  //baseUrl1='http://localhost:8089/OnlineClinic/reporter/denyLeave';
  getLeaves(): Observable<Leave[]> {
    const lurl = `http://localhost:8089/OnlineClinic/reporter/leaves`;
    return this._http.get<Leave[]>(lurl)
    .pipe(tap(_ => console.log("leaveslist"),
    catchError(this.handleError<Location[]>(`error`))
  ));
}

approveLeave(leave:Leave) {
  console.log("service called");
  console.log(leave);
  return this._http.put(`${this.baseUrl}`,leave);
}

// denyLeave(leave:Leave) {
//   console.log("service called");
//   console.log(leave);
//   return this._http.put(`${this.baseUrl1}`,leave);
// }

private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}


}
