import { Component } from '@angular/core';
import { MedicineService } from '../_service/medicine.service';
import { Router } from '@angular/router';
import { Medicine } from '../_class/medicine';

@Component({
  selector: 'app-add-medicine',
  templateUrl: './add-medicine.component.html',
  styleUrl: './add-medicine.component.css'
})
export class AddMedicineComponent {

  medicine: Medicine = new Medicine();

  constructor(private medicineService:MedicineService,private router:Router){}

  onSubmit(){
    this.saveMadecine()
  }
  saveMadecine(){
    this.medicineService.saveMedicine(this.medicine).subscribe(data=>{
    console.log(data)
  })
  this.router.navigate([("/view-medicine")])
  }
}
