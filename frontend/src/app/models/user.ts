import { Role } from './role';
import { Timestamp } from './timestamp';

export class User extends Timestamp {
  id: number;
  name: string;
  username: string;
  password: string;
  role: Role;

  constructor(obj?) {
    super(obj);
    if (obj) {
      this.id = obj.id;
      this.name = obj.name;
      this.username = obj.username;
      this.password = obj.password;
      this.role = obj.role;
    }
  }
}
