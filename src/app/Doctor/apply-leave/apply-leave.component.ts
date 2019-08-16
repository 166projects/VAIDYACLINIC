import { Component, OnInit } from '@angular/core';
import { Leave } from '../../leave';
import { Doctor } from '../../doctor';
import { DoctorServiceService } from '../../doctor-service.service';
import { Router, ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {
  leaveList: Leave[];
  leave: Leave = new Leave();
  doctor: Doctor;
  submitted = false;
  dId: string;
  cId: string;
  mId: string;
  locId: string;
  rId: string;
  isLoadingResults = true;
  constructor(private doctorService: DoctorServiceService, private route: ActivatedRoute, private router: Router,
  ) { }


  ngOnInit() {

  }

  addLeave():void {
    this.leave = {
      'lId': this.leave.lId,
      'todate': this.leave.todate,
      'fromdate': this.leave.fromdate,
      'leave_status': '2',
      'reason': this.leave.reason,
      'doctor': {
        'dId': this.dId,
        'doctor_status': '1',
        'clinic': {
          'cId': 'CL03',
          'clinic_name': ' ',
          'clinic_address': ' ',
          'location': {
            'locId': ' ',
            'location_name': ' '
          }
        },
        'member': {
          'mId': 's',
          'firstName': ' ',
          'lastName': ' ',
          'gender': ' ',
          'contact': ' ',
          'password': ' ',
          'email': ' ',
          'member_address': ' ',
          'role': {
            'rId': 'R03',
            'role_name': 'doctor'
          },
          'DateOfBirth': ' '
        }
      }
    };
    console.log(this.leave);
    this.doctorService.addLeave(this.leave)
      .subscribe(data => console.log(data), error => console.log(error));
    
  }

  onSubmit() {
    this.submitted = true;
    this.addLeave();
  }

}
