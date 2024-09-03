import { Component } from '@angular/core';
import { PatientService } from '../_service/patient.service';
import { ActivatedRoute} from '@angular/router';
import { Patient } from '../_class/patient';

@Component({
  selector: 'app-view-patient',
  templateUrl: './view-patient.component.html',
  styleUrl: './view-patient.component.css'
})
export class ViewPatientComponent {

  id:number=0;
  patient:Patient =new Patient();
  constructor(private patientService:PatientService,private route:ActivatedRoute){}

  ngOnInit(){
    this.id=this.route.snapshot.params["id"];
    this.patientService.findPatientById(this.id).subscribe(data=>{
        this.patient=data;
    })
  }

}
