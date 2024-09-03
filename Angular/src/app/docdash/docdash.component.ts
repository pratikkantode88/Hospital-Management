import { Component } from '@angular/core';
import { PatientService } from '../_service/patient.service';
import { Router } from '@angular/router';
import { Patient } from '../_class/patient';

@Component({
  selector: 'app-docdash',
  templateUrl: './docdash.component.html',
  styleUrl: './docdash.component.css'
})
export class DocdashComponent {

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

  updatePatient(id:number){
     this.router.navigate(["update-patient",id])
  }

  deletePatient(id:number){
    this.patientService.deletePatient(id).subscribe(data=>{
      console.log(data);
      this.getPatient();
    })
  }

  viewPatient(id:number){
    this.router.navigate(["view-patient",id])
  }

}
