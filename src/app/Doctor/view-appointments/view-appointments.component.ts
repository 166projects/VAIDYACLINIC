import { Component, OnInit } from '@angular/core';
import { Appointment } from '../../appointment';
import { DoctorServiceService } from '../../doctor-service.service';

@Component({
  selector: 'app-view-appointments',
  templateUrl: './view-appointments.component.html',
  styleUrls: ['./view-appointments.component.css']
})
export class ViewAppointmentsComponent implements OnInit {
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }
appointments : Appointment[];
  constructor(private doctorService : DoctorServiceService) { }

  getAppointmentByDoctor(date : string ,dId: string): any {
  
    this.doctorService.getAppointmentByDoctorAndDate(date,dId)
      .subscribe((data: any) => {
        this.appointments = data;
        console.log(this.appointments);

      });
  }


}
