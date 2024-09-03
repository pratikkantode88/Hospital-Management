import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { UserAuthService } from '../_service/user-auth.service';
import { UserService } from '../_service/user.service';


@Injectable({
  providedIn: 'root'
})
export class authGuard implements CanActivate{
  
  constructor(private userauthservice:UserAuthService,
              private router:Router,
              private userservice:UserService){}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    if(this.userauthservice.getToken()!=null){
       const role=route.data["roles"] as Array<string>;
       if(role){
          const match=this.userservice.roleMatch(role);

          if(match){
            return true;
          }else{
            this.router.navigate(["/forbidden"]);
            return false;
          }
       }
    }
    this.router.navigate(["/login"]);
    return false;
  }
  
}

