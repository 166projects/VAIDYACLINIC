import { Member } from './member';
import { Appointment } from './appointment';

export class Patient {
 pId:string;
 age:number;
 weight:number;
 record:any;
 member:Member;
 appointment:Appointment[];

}
