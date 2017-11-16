import { BASE_URL } from './constant';

export module API {
  export class USER {
    public static readonly URL = `${BASE_URL}/users`;
    public static readonly LOGIN = `${USER.URL}/auth`;
    public static readonly EXIST_USERNAME = `${USER.URL}/exist-username`;
    public static readonly COUNT = `${USER.URL}/count`;
  }

  export class CLASS {
    public static readonly URL = `${BASE_URL}/classes`;
    public static readonly COUNT = `${CLASS.URL}/count`;
  }

  export class INVOICE {
    public static readonly URL = `${BASE_URL}/invoices`;
  }

  export class REGISTRATION {
    public static readonly URL = `${BASE_URL}/registrations`;
  }

  export class ROOM {
    public static readonly URL = `${BASE_URL}/rooms`;
    public static readonly COUNT = `${ROOM.URL}/count`;
  }

  export class SUBJECT {
    public static readonly URL = `${BASE_URL}/subjects`;
    public static readonly COUNT = `${SUBJECT.URL}/count`;
  }
}
