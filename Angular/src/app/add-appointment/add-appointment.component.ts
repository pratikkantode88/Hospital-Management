import { Component } from '@angular/core';
import { Appointment } from '../_class/appointment';
import { Router } from '@angular/router';
import { AppointmentService } from '../_service/appointment.service';


@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrl: './add-appointment.component.css'
})
export class AddAppointmentComponent {

 appointment:Appointment= new Appointment();
 constructor(private appointmentService:AppointmentService,private router:Router){}

  saveAppointment(){
    this.appointmentService.saveAppointment(this.appointment).subscribe(data=>{
      console.log(data);
      this.router.navigate(["/appointmentlist"])
    })
  }


 onSubmit(){
    this.saveAppointment();
 }
}
