import { Injectable } from '@angular/core';
import { Member } from 'src/app/member';
import {  of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import {BehaviorSubject,Observable } from 'rxjs';
const httpOptions = { 
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})

export class LoginSignupServiceService {
 private currentUserSubject : BehaviorSubject<Member>;
 public currentUser : Observable<Member>;

  constructor(private _http:HttpClient) {
    this.currentUserSubject=new BehaviorSubject<Member>(JSON.parse(localStorage.getItem('currentUser')));
this.currentUser=this.currentUserSubject.asObservable();
  }
  public get currentUserValue():Member{
    return this.currentUserSubject.value;
  }
  
  // register(member: Member):Promise<Member>{
  
  // console.log(member);
  
  // return this._http.post('http://localhost:8089/OnlineClinic/signup',
  
  
  // JSON.stringify(member),
  
  // {headers : this.headers})
  
  // .toPromise().then(res =>res.json() as Member)
  
  // .catch(this.handleError);
  
  // }
  
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  
  login(email: string, password: string):Observable<Member>{
    console.log('service called');  
    const url1= 'http://localhost:8089/OnlineClinic/LoginSignup/login';
    // const lurl = `http://localhost:8089/OnlineClinic/LoginSignup/login/priya@gmail.com/1234`;
   const lurl=`${url1}/${email}/${password}`;
    return this._http.get<Member>(lurl)
    .pipe(tap(member => {
      localStorage.setItem('currentUser',JSON.stringify(member));
      this.currentUserSubject.next(member);
    return member;}),
    catchError(this.handleError<Member>(`getProduct id=${email}`))
  );
      
}

logout(){
  localStorage.removeItem('currentUser');
  this.currentUserSubject.next(null);
}

}
