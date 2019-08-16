import { Clinic } from './clinic';
import { Specialization } from './specialization';
import { Appointment } from './appointment';
import { Member } from './member';

export class Doctor {
    dId:string;
    doctor_status:string;
    clinic:Clinic;
    member:Member;

}
