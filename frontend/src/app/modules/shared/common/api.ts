import { BASE_URL } from './constant';

export module API {
  export class USER {
    public static readonly URL = `${BASE_URL}/users`;
    public static readonly LOGIN = `${USER.URL}/auth`;
    public static readonly EXIST_USERNAME = `${USER.URL}/exist-username`;
  }

  export class CLASS {
    public static readonly URL = `${BASE_URL}/classes`;
  }

  export class INVOICE {
    public static readonly URL = `${BASE_URL}/invoices`;
  }

  export class REGISTRATION {
    public static readonly URL = `${BASE_URL}/registrations`;
  }
}
