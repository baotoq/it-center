import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';
import { AuthService } from '../auth/auth.service';
import { Observable } from 'rxjs/Observable';
import { API } from '../shared/common/api';
import { Subject } from '../../models/subject';

@Injectable()
export class DashboardService {
  constructor(private requestService: RequestService, private authService: AuthService) {
  }

  countStudents(): Observable<number> {
    return this.requestService.get(API.USER.COUNT);
  }

  countClasses(): Observable<number> {
    return this.requestService.get(API.CLASS.COUNT);
  }

  countSubjects(): Observable<number> {
    return this.requestService.get(API.SUBJECT.COUNT);
  }

  countRooms(): Observable<number> {
    return this.requestService.get(API.ROOM.COUNT);
  }

  getChartData(): Observable<Subject> {
    return this.requestService.get(API.SUBJECT.CHART);
  }
}
