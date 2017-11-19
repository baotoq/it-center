import { Timestamp } from './timestamp';
import { Room } from './room';
import { Subject } from './subject';
import { Period } from './period';
import { User } from './user';

export class Class extends Timestamp {
  id: number;
  name: string;
  numberOfStudents: number;
  lecturer: string;
  tuition: number;
  active: boolean;
  startedAt: Date;
  endedAt: Date;
  room: Room;
  subject: Subject;
  period: Period;
  selected = false;
  student: User[];
  state: State;

  constructor(obj?) {
    super(obj);
    if (obj) {
      this.id = obj.id;
      this.name = obj.name;
      this.lecturer = obj.lecturer;
      this.tuition = obj.tuition;
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
  REGISTERED,
  CONFIRMED
}
