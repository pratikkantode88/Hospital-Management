import { Component } from '@angular/core';
import { UserAuthService } from '../_service/user-auth.service';
import { UserService } from '../_service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  
  constructor(private userService:UserService,
    private userAuthService:UserAuthService,
    private router:Router){}

    isAdmin=true;

username:string="";
password:string="";

login(){
console.log("username : "+this.username+" , password : "+this.password)
this.userService.login(this.username,this.password).subscribe((data:any)=>{
this.userAuthService.setRoles(data.user.role);
this.userAuthService.setToken(data.jwtToken);

const role=data.user.role[0].roleName;
if(role==="doctor"){
this.router.navigate(["/doctor"]);
}
else if(role==="receptionist"){
this.router.navigate(["/receptionist"]);
}
},
(error)=>{
console.log(error);

this.isAdmin=false;
  setTimeout(()=>{
    this.isAdmin=true;
  },2000)
}
)

}
}
