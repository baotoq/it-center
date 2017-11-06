import { BASE_URL } from './constant';

export module API {
  export class USER {
    public static readonly URL = `${BASE_URL}/user`;

    public static readonly GET_ALL = `${USER.URL}/getAll`;
    public static readonly GET_UNCONFIRMED = `${USER.URL}/getUnconfirmed`;
    public static readonly CONFIRM = `${USER.URL}/confirm`;
    public static readonly DENY = `${USER.URL}/deny`;
    public static readonly CREATE = `${USER.URL}/create`;
    public static readonly LOGIN = `${USER.URL}/login`;
    public static readonly HAS_EMAIL = `${USER.URL}/hasEmail`;
  }
}
