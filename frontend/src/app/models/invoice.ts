import { Timestamp } from './timestamp';
import { User } from './user';

export class Invoice extends Timestamp {
  id: number;
  total: number;
  student: User;
  confirmed: boolean;
  loading = false;
  cancelLoading = false;

  constructor(obj?) {
    super(obj);
    if (obj) {
      this.id = obj.id;
    }
  }
}
