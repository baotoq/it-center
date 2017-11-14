import { Injectable } from '@angular/core';
import { RequestService } from '../shared/services/request.sevice';
import { Observable } from 'rxjs/Observable';
import { Room } from '../../models/room';
import { API } from '../shared/common/api';

@Injectable()
export class RoomService {
  constructor(private requestService: RequestService) {
  }

  getAll(): Observable<Room[]> {
    return this.requestService.get(API.ROOM.URL);
  }
}
