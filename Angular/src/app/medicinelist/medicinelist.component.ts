import { Component } from '@angular/core';
import { MedicineService } from '../_service/medicine.service';
import { Router } from '@angular/router';
import { Medicine } from '../_class/medicine';

@Component({
  selector: 'app-medicinelist',
  templateUrl: './medicinelist.component.html',
  styleUrl: './medicinelist.component.css'
})
export class MedicinelistComponent {
  
  medicines:Medicine[]=[]

  constructor(private medicineService:MedicineService,private router:Router){}
 
  ngOnInit(){
    this.getMedicinesList();
  }
  getMedicinesList(){
    this.medicineService.getMedicineList().subscribe(data=>{
    this.medicines=data
    })
   }

  update(id:number){
    this.router.navigate(["update-medicine",id])
  }

  delete(id:number){
    this.medicineService.deleteMedicine(id).subscribe(data=>{
      console.log(data);
      this.getMedicinesList();
    })
  }

}
