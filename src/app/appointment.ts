import { Doctor } from './doctor';
import { Patient } from './patient';

export class Appointment {
    aId:string;
    disease:string;
    appointment_date:string;
    appintment_status:string;
    remark:string;
    doctor:Doctor;
    patient:Patient;

}
