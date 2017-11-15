import { Timestamp } from './timestamp';

export class Room extends Timestamp {
  id: number;
  capacity: number;

  constructor(obj?: Room) {
    super(obj);
    if (obj) {
      this.id = obj.id;
    }
  }
}
