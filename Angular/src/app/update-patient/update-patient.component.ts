import { Component } from '@angular/core';
import { PatientService } from '../_service/patient.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../_class/patient';

@Component({
  selector: 'app-update-patient',
  templateUrl: './update-patient.component.html',
  styleUrl: './update-patient.component.css'
})
export class UpdatePatientComponent {

  patient:Patient=new Patient();
  id:number=0
constructor(private patientService:PatientService,private route:ActivatedRoute,private router:Router){}

ngOnInit(){
  this.id=this.route.snapshot.params["id"]
  this.patientService.findPatientById(this.id).subscribe(data=>{
    this.patient=data;
  })
}

  onSubmit(){
    this.patientService.updatePatient(this.id,this.patient).subscribe(data=>{
      console.log(data);
      this.router.navigate(["docdash"])
    })
  }
}
