import { Timestamp } from './timestamp';

export class Subject extends Timestamp {
  id: number;
  name: string;
  level: string;
  numberOfRegistrations: number;

  constructor(obj?: Subject) {
    super(obj);
    if (obj) {
      this.id = obj.id;
    }
  }
}
