import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  BASE_PATH="http://localhost:8080";

  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  );

  constructor(private httpclient:HttpClient,
              private userauthservice:UserAuthService
             ) { }

  login(username:string,password:string){
     return this.httpclient.post(this.BASE_PATH+"/user/login",{username,password},{headers:this.requestHeader})
  }

  public roleMatch(allowedRoles:any):any{
    let isMatch=false;
    const userRoles:any=this.userauthservice.getRoles();

    if(userRoles != null && userRoles){
      for(let i=0;i<userRoles.length;i++){
        for(let j=0;j<allowedRoles.length;j++){
          if(userRoles[i].roleName === allowedRoles[j]){
            console.log(userRoles[i].roleName +"  "+allowedRoles[j]);
          isMatch=true;
          return isMatch;
        }else{
          return isMatch;
        }
      }
    }
  }
}
}
