import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Resolve, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { AuthService } from '../modules/auth/auth.service';
import { CoreService } from '../modules/core/core.service';

@Injectable()
export class AuthGuard implements CanActivate, Resolve<any> {
  constructor(private authService: AuthService,
              private coreService: CoreService,
              private router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.authService.isAuthenticated()) {
      return true;
    }
    this.router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
    this.coreService.notifyError('Login is required!');
    return false;
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<any> | Promise<any> | any {
    if (this.authService.isAuthenticated()) this.router.navigate(['/']);
  }
}
