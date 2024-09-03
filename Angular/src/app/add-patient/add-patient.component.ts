import { Component } from '@angular/core';
import { PatientService } from '../_service/patient.service';
import { Router } from '@angular/router';
import { Patient } from '../_class/patient';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrl: './add-patient.component.css'
})
export class AddPatientComponent {

  patient:Patient= new Patient();
 constructor(private patientService:PatientService,private router:Router){}

  savePatient(){
    this.patientService.savePatient(this.patient).subscribe(data=>{
      console.log(data);
      this.router.navigate(["/doctor"])
    })
  }


 onSubmit(){
    this.savePatient();
 }
}
