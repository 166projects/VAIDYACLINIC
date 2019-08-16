import { Component, OnInit } from '@angular/core';
import { AdminServiceService } from '../../admin-service.service';
import { LoginSignupServiceService } from '../../login-signup-service.service';
import { Member } from '../../member';
import { Router, ActivatedRoute } from '@angular/router';
import { Role } from '../../role';
@Component({
  selector: 'app-addmember',
  templateUrl: './addmember.component.html',
  styleUrls: ['./addmember.component.css']
})
export class AddmemberComponent implements OnInit {
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
  onSubmit() {
    this.submitted = true;
    this.addMember();
  }


}
