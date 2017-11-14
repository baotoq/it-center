import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';

@Injectable()
export class RoomService {
  constructor(private requestService: RequestService) {
  }
}
