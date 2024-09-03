import { Component } from '@angular/core';
import { PatientService } from '../_service/patient.service';
import { Router } from '@angular/router';
import { Patient } from '../_class/patient';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styleUrl: './admindash.component.css'
})
export class AdmindashComponent {

  patients:Patient[]=[]
  constructor(private patientService:PatientService,private router:Router){}

  ngOnInit():void{
    this.getPatient();
  }

  getPatient(){
    this.patientService.getPatientList().subscribe(data=>{
        this.patients=data;
    })
  }

  deletePatient(id:number){
    this.patientService.deletePatient(id).subscribe(data=>{
      console.log(data);
      this.getPatient();
    })
   }

}
