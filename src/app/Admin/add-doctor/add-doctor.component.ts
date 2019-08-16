import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../doctor';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {
doctor :Doctor;
  constructor() { }

  ngOnInit() {
  }
//   addMember() {
//     // console.log(this.member.role);
//     this.adminService.addMember(this.member).subscribe((data: any) => {
//       const id = data._id;
//     }, error => console.log(error));
// this.router.navigateByUrl("/addDoctor");
//   }



}
