import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';

@Injectable()
export class SubjectService {
  constructor(private requestService: RequestService) {
  }
}
