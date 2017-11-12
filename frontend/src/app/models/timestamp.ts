export class Timestamp {
  createdAt: Date;
  updatedAt: Date;
  deletedAt: Date;

  constructor(obj) {
    if (obj) {
      this.createdAt = obj.createdAt;
      this.updatedAt = obj.updatedAt;
      this.deletedAt = obj.deletedAt;
    }
  }
}
