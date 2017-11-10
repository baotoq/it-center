import { BASE_URL } from './constant';

export module API {
  export class USER {
    public static readonly URL = `${BASE_URL}/users`;

    public static readonly GET_ALL = `${USER.URL}/get-all`;
    public static readonly CREATE = `${USER.URL}/create`;
    public static readonly LOGIN = `${USER.URL}/auth`;
    public static readonly EXIST_USERNAME = `${USER.URL}/exist-username`;
  }
}
