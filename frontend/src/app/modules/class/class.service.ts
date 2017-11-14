import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';
import { AuthService } from '../auth/auth.service';
import { Observable } from 'rxjs/Observable';
import { Class } from '../../models/class';
import { API } from '../shared/common/api';
import { Registration } from '../../models/registration';

@Injectable()
export class ClassService {
  constructor(private requestService: RequestService, private authService: AuthService) {
  }

  getAll(): Observable<Class[]> {
    return this.requestService.get(API.CLASS.URL);
  }

  get(id: number): Observable<Class> {
    return this.requestService.get(`${API.CLASS.URL}/${id}`);
  }

  create(c: Class): Observable<any> {
    return this.requestService.post(API.CLASS.URL, c);
  }

  update(id: number, c: Class): Observable<any> {
    return this.requestService.put(`${API.CLASS.URL}/${id}`, c);
  }

  createInvoice(classes: Class[]): Observable<any> {
    let r = [];
    classes.forEach(item => r.push({attendedClass: item, student: this.authService.currentUser()}));
    return this.requestService.post(API.REGISTRATION.URL, r);
  }

  getUserRegistration(id: number): Observable<Registration[]> {
    return this.requestService.get(`${API.REGISTRATION.URL}/${id}`);
  }
}
