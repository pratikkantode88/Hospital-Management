import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Medicine } from '../_class/medicine';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  constructor(private httpClient:HttpClient) { }
   
  private baseUrl="http://localhost:8080/medicine";

  getMedicineList():Observable<Medicine[]>{
    return this.httpClient.get<Medicine[]>(`${this.baseUrl}/getAll`);
   }

   saveMedicine(medicine:Medicine):Observable<Medicine>{
    return this.httpClient.post<Medicine>(`${this.baseUrl}/insert`,medicine)
   }

   findMedicineById(id:number):Observable<Medicine>{
    return this.httpClient.get<Medicine>(`${this.baseUrl}/find/${id}`);
   }

   updateMedicine(id:number,medicine:Medicine):Observable<object>{
    return this.httpClient.put<object>(`${this.baseUrl}/update/${id}`,medicine);
   }

   deleteMedicine(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/delete/${id}`);
   }
}
