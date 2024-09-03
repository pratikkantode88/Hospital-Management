import { Component } from '@angular/core';
import { Appointment } from '../_class/appointment';
import { AppointmentService } from '../_service/appointment.service';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrl: './appointment.component.css'
})
export class AppointmentComponent {

  appointments:Appointment[]=[]
   constructor(private appointmentService:AppointmentService){}

   ngOnInit():void{
    this.getAppointments()
   }

   getAppointments(){
    this.appointmentService.getAppointmentList().subscribe(data=>{
    this.appointments=data
    })
   }

   deleteAppointment(id:number){
    this.appointmentService.deleteAppointment(id).subscribe(data=>{
      console.log(data);
      this.getAppointments();
    })
   }

}
