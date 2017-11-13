import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';
import { Observable } from 'rxjs/Observable';
import { Class } from '../../models/class';
import { API } from '../shared/common/api';

@Injectable()
export class ClassService {
  constructor(private requestService: RequestService) {
  }

  getAll(): Observable<Class[]> {
    return this.requestService.get(API.CLASS.URL);
  }

  get(id: number): Observable<Class> {
    return this.requestService.get(`${API.CLASS.URL}/${id}`);
  }

  createInvoice(classes: Class[]): Observable<any> {
    let r = [];
    classes.forEach(item => r.push({attendedClass: item, student: {id: 1}}));
    return this.requestService.post(API.REGISTRATION.URL, r);
  }
}
