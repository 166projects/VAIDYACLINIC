import { Component, OnInit } from '@angular/core';
import { Member } from 'src/app/member';
import { Role } from 'src/app/role';
import { AdminServiceService } from 'src/app/admin-service.service';
import { LoginSignupServiceService } from 'src/app/login-signup-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-signup-component',
  templateUrl: './signup-component.component.html',
  styleUrls: ['./signup-component.component.css']
})
export class SignupComponent implements OnInit {
  memberList: Member[];
  member: Member = new Member();
  roleList: Role[];
  isLoadingResults = true;
  submitted = false;
  memberId: string;
  currentMember: Member;
  constructor(private adminService: AdminServiceService, private loginService: LoginSignupServiceService, private route: ActivatedRoute, private router: Router,
  ) {

    this.currentMember = this.loginService.currentUserValue;
    this.memberId = this.currentMember.mId;
  }

  addMember() {
    console.log(this.member.role);
    this.adminService.addMember(this.member).subscribe((data: any) => {
      const id = data._id;
    }, error => console.log(error));
this.router.navigateByUrl("/addDoctor");
  }

  getRoles(): any {
    this.adminService.getRoles()
      .subscribe((data: any) => {
        this.roleList = data;
        console.log(this.roleList);
        this.isLoadingResults = false;
      });
  }




  ngOnInit() {
    this.getRoles();
  }
  onSubmit() { this.addMember(); }
}
