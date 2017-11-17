import { Timestamp } from './timestamp';
import { Class } from './class';
import { Invoice } from './invoice';

export class Registration extends Timestamp {
  id: number;
  attendedClass: Class;
  invoice: Invoice;

  constructor(obj?) {
    super(obj);
    if (obj) {
      this.id = obj.id;
    }
  }
}
