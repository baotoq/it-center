import { Timestamp } from './timestamp';
import { Class } from './class';
import { User } from './user';

export class Registration extends Timestamp {
  id: number;
  attendedClass: Class;
  student: User;

  constructor(obj?) {
    super(obj);
    if (obj) {
      this.id = obj.id;
    }
  }
}
