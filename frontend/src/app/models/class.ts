import { Timestamp } from './timestamp';

export class Class extends Timestamp {
  id: number;
  capacity: number;
  lecturer: string;
  price: number;
  active: boolean;
  startedAt: Date;
  endedAt: Date;

  constructor(obj?: Class) {
    super(obj);
    if (obj) {
      this.id = obj.id;
      this.startedAt = obj.startedAt;
      this.endedAt = obj.endedAt;
    }
  }
}
