import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from '../_class/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpClient:HttpClient) { }

  private baseUrl="http://localhost:8080/patient";

  getPatientList():Observable<Patient[]>{
   return this.httpClient.get<Patient[]>(`${this.baseUrl}/getAll`);
  }

  savePatient(patient:Patient):Observable<Patient>{
    return this.httpClient.post<Patient>(`${this.baseUrl}/insert`,patient)
   }

  deletePatient(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/delete/${id}`);
   }

   findPatientById(id:number):Observable<Patient>{
    return this.httpClient.get<Patient>(`${this.baseUrl}/find/${id}`);
   }

   updatePatient(id:number,patient:Patient):Observable<object>{
    return this.httpClient.put<object>(`${this.baseUrl}/update/${id}`,patient);
   }
}
