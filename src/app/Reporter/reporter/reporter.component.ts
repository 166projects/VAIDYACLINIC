import { Component, OnInit } from '@angular/core';
import { Leave } from '../../leave';
import { Member } from '../../member';
import { Router, ActivatedRoute } from '@angular/router';
import { ReporterServiceService } from '../../reporter-service.service';
import { LoginSignupServiceService } from '../../login-signup-service.service';
@Component({
  selector: 'app-reporter',
  templateUrl: './reporter.component.html',
  styleUrls: ['./reporter.component.css']
})
export class ReporterComponent implements OnInit {
  leaveList : Leave[];
  isLoadingResults = true;
  currentMember:Member;
  leave : Leave;
  constructor(private reporterService: ReporterServiceService,
    private loginService: LoginSignupServiceService, 
    private route: ActivatedRoute, 
    private router: Router
  ) {
this.currentMember = this.loginService.currentUserValue;

  }
   
   getLeaves():any {
     console.log(this.currentMember);
     this.reporterService.getLeaves()
    .subscribe((data: any) => {
      this.leaveList = data;
      console.log(this.leaveList);
      this.isLoadingResults = false;
      });
    }


    approveLeave(){
      this.reporterService.approveLeave(this.leave)
      .subscribe(data => console.log(data), error => console.log(error));
      this.leave = new Leave();
    }
    // denyLeave(){
    //   this.repoterService.denyLeave(this.leave)
    //   .subscribe(data => console.log(data), error => console.log(error));
    //   this.leave = new Leave();
    // }
ngOnInit() {
this.getLeaves();
}

}
