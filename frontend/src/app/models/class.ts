import { Timestamp } from './timestamp';
import { Room } from './room';
import { Subject } from './subject';
import { Period } from './period';

export class Class extends Timestamp {
  id: number;
  name: string;
  capacity: number;
  numberOfStudents: number;
  lecturer: string;
  price: number;
  active: boolean;
  startedAt: Date;
  endedAt: Date;
  room: Room;
  subject: Subject;
  period: Period;
  selected = false;
  state: State;

  constructor(obj?) {
    super(obj);
    if (obj) {
      this.id = obj.id;
      this.name = obj.name;
      this.capacity = obj.capacity;
      this.lecturer = obj.lecturer;
      this.price = obj.price;
      this.active = obj.active;
      this.room = obj.room;
      this.subject = obj.subject;
      this.period = obj.period;
      this.startedAt = obj.startedAt;
      this.endedAt = obj.endedAt;
    }
  }
}

export enum State {
  CONFLICTED,
  REGISTERED
}
