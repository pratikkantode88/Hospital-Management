import { Component } from '@angular/core';
import { MedicineService } from '../_service/medicine.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Medicine } from '../_class/medicine';

@Component({
  selector: 'app-update-medicine',
  templateUrl: './update-medicine.component.html',
  styleUrl: './update-medicine.component.css'
})
export class UpdateMedicineComponent {

  medicine:Medicine=new Medicine();
  id:number=0
constructor(private medicineService:MedicineService,private route:ActivatedRoute,private router:Router){}

ngOnInit(){
  this.id=this.route.snapshot.params["id"]
  this.medicineService.findMedicineById(this.id).subscribe(data=>{
    this.medicine=data;
  })
}

  onSubmit(){
    this.medicineService.updateMedicine(this.id,this.medicine).subscribe(data=>{
      console.log(data);
      this.router.navigate(["view-medicine"])
    })
  }
}
