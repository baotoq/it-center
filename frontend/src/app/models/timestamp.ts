export class Timestamp {
  createdDate: Date;
  updatedDate: Date;

  constructor(obj) {
    if (obj) {
      this.createdDate = obj.createdDate;
      this.updatedDate = obj.updatedDate;
    }
  }
}
