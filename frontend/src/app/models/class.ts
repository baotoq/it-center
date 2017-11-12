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

  constructor(obj?: Class) {
    super(obj);
    if (obj) {
      this.id = obj.id;
      this.capacity = obj.capacity;
      this.startedAt = obj.startedAt;
      this.endedAt = obj.endedAt;
    }
  }
}
