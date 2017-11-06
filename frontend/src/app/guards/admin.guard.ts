import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { AuthService } from '../modules/auth/auth.service';
import { Role } from '../models/role';

@Injectable()
export class AdminGuard implements CanActivate {
  constructor(private authService: AuthService,
              private router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    const currentUser = this.authService.currentUser();
    if (currentUser.role == Role.Administrator) {
      return true;
    }
    this.router.navigate(['/']);
    return false;
  }
}
