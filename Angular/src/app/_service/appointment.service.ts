import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Appointment } from '../_class/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  
  constructor(private httpClient:HttpClient) { }
  
  private baseUrl="http://localhost:8080/apointment";

  getAppointmentList():Observable<Appointment[]>{
    return this.httpClient.get<Appointment[]>(`${this.baseUrl}/getAll`)
   }

   saveAppointment(appointment:Appointment):Observable<Appointment>{
    return this.httpClient.post<Appointment>(`${this.baseUrl}/insert`,appointment)
   }

   deleteAppointment(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseUrl}/delete/${id}`);
   }
}
