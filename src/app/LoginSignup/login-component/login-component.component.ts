import { Component, OnInit } from '@angular/core';
import { LoginSignupServiceService } from 'src/app/login-signup-service.service';
import { Member } from '../../member';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponent implements OnInit {

  // model: any = {};
  email:string;
  password :string;
  returnUrl: string;
  member : Member;
  isLoadingResults = true;

  ngOnInit() {
  }
  constructor(private loginSignupService: LoginSignupServiceService, private route: ActivatedRoute, private router: Router,
  ) {
   }
   
   login():void {
     this.loginSignupService.login(this.email,this.password)
    .subscribe((data: any) => {
      this.member = data;
      console.log(this.member.role);
      this.isLoadingResults = false;
      if(this.member.role.role_name === 'admin'){
        console.log('admin logged in');
        this.router.navigateByUrl("/admin");
      }
      else if(this.member.role.role_name === 'reporter'){
        console.log('reporter  logged in');
        this.router.navigateByUrl("/reporter");
      }
      else if(this.member.role.role_name === 'patient'){
        console.log('reporter  logged in');
        this.router.navigateByUrl("/patient");
      }
      else if(this.member.role.role_name === 'doctor'){
        console.log('reporter  logged in');
        this.router.navigateByUrl("/doctor");
      }
    });

  }
}
