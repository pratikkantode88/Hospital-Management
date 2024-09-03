import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdmindashComponent } from './admindash/admindash.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';
import { HomeComponent } from './home/home.component';
import { DocdashComponent } from './docdash/docdash.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { MedicinelistComponent } from './medicinelist/medicinelist.component';
import { AddMedicineComponent } from './add-medicine/add-medicine.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { ViewPatientComponent } from './view-patient/view-patient.component';
import { UpdateMedicineComponent } from './update-medicine/update-medicine.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { authGuard } from './_auth/auth.guard';


const routes: Routes = [
  {path:"receptionist",component:AdmindashComponent},
  {path:"appointmentlist",component:AppointmentComponent,canActivate:[authGuard],data:{roles:["receptionist"]}},
  {path:"add-appointment",component:AddAppointmentComponent,canActivate:[authGuard],data:{roles:["receptionist"]}},
  {path:"home",component:HomeComponent},
  {path:"",redirectTo:"home",pathMatch:'full'},
  {path:"doctor",component:DocdashComponent},
  {path:"add-patient",component:AddPatientComponent,canActivate:[authGuard],data:{roles:["doctor","receptionist"]}},
  {path:"view-medicine",component:MedicinelistComponent,canActivate:[authGuard],data:{roles:["doctor"]}},
  {path:"add-medicine",component:AddMedicineComponent,canActivate:[authGuard],data:{roles:["doctor"]}},
  {path:"update-patient/:id",component:UpdatePatientComponent,canActivate:[authGuard],data:{roles:["doctor"]}},
  {path:"view-patient/:id",component:ViewPatientComponent,canActivate:[authGuard],data:{roles:["doctor"]}},
  {path:"update-medicine/:id",component:UpdateMedicineComponent,canActivate:[authGuard],data:{roles:["doctor"]}},
  {path:"login",component:LoginComponent},
  {path:"forbidden",component:ForbiddenComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
