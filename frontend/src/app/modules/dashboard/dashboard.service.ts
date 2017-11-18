import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';
import { Observable } from 'rxjs/Observable';
import { API } from '../shared/common/api';
import { Subject } from '../../models/subject';
import { Invoice } from '../../models/invoice';

@Injectable()
export class DashboardService {
  constructor(private requestService: RequestService) {
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

  getAllInvoice(): Observable<Invoice[]> {
    return this.requestService.get(API.INVOICE.URL);
  }

  confirmInvoice(invoice: Invoice) {
    invoice.confirmed = true;
    return this.requestService.put(`${API.INVOICE.URL}/${invoice.id}`, invoice);
  }

  cancelInvoice(invoice: Invoice) {
    return this.requestService.delete(`${API.INVOICE.URL}/${invoice.id}`);
  }
}
