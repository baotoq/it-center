import { Role } from './role';
import { Timestamp } from './timestamp';

export class User extends Timestamp {
  id: number;
  name: string;
  phone: string;
  birthday: Date;
  avatar: string;
  email: string;
  password: string;
  role: Role;
  confirmedBy: User;

  constructor(obj?: User) {
    super(obj);
    if (obj) {
      this.id = obj.id;
      this.name = obj.name;
      this.phone = obj.phone;
      this.birthday = obj.birthday;
      this.avatar = obj.avatar;
      this.email = obj.email;
      this.password = obj.password;
      this.role = obj.role;
      this.confirmedBy = obj.confirmedBy;
    }
  }
}
