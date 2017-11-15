import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';
import { Observable } from 'rxjs/Observable';
import { Subject } from '../../models/subject';
import { API } from '../shared/common/api';

@Injectable()
export class SubjectService {
  constructor(private requestService: RequestService) {
  }

  getAll(): Observable<Subject[]> {
    return this.requestService.get(API.SUBJECT.URL);
  }
}
