import { Injectable } from '@angular/core';
import { JWT } from '../shared/common/constant';
import { API } from '../shared/common/api';
import { User } from '../../models/user';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/finally';
import { RequestService } from '../shared/services/request.sevice';

@Injectable()
export class AuthService {
  constructor(private requestService: RequestService) {
  }

  login(username: string, password: string): Observable<any> {
    return this.requestService.post(API.USER.LOGIN, {
      username: username,
      password: password,
    });
  }

  isExistingUsername(username: string): Observable<any> {
    return this.requestService.post(API.USER.EXIST_USERNAME + `?username=${username}`, {});
  }

  setToken(token: string) {
    localStorage.setItem(JWT.AUTH, JSON.stringify(token));
  }

  logout() {
    localStorage.removeItem(JWT.AUTH);
  }

  currentUser(): User {
    if (!this.isAuthenticated()) return null;
    //const jwtHelper = new JwtHelper();
    //const rawData = jwtHelper.decodeToken(localStorage.getItem(JWT.AUTH));
    const rawData = JSON.parse(localStorage.getItem(JWT.AUTH));
    return new User(rawData);
  }

  isAuthenticated(): boolean {
    //return tokenNotExpired(JWT.AUTH);
    return localStorage.getItem(JWT.AUTH) != null;
  }
}
