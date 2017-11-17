import { Timestamp } from './timestamp';
import { User } from './user';

export class Invoice extends Timestamp {
  id: number;
  total: number;
  student: User;
  confirmed: boolean;

  constructor(obj?) {
    super(obj);
    if (obj) {
      this.id = obj.id;
    }
  }
}
