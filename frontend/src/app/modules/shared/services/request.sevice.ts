import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { AuthHttp } from 'angular2-jwt';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/delay';

@Injectable()
export class RequestService {

  constructor(private http: Http, private authHttp: AuthHttp) {
  }

  public get(url: string, options?: RequestOptions): Observable<any> {
    return this.http.get(url, this.defaultRequestOptions().merge(options))
      .map(this.extractData);
  }

  public post(url: string, body?: object, options?: RequestOptions): Observable<any> {
    return this.http.post(url, body, this.defaultRequestOptions().merge(options))
      .map(this.extractData);
  }

  public authGet(url: string, options?: RequestOptions): Observable<any> {
    return this.authHttp.get(url, this.defaultRequestOptions().merge(options))
      .map(this.extractData);
  }

  public authPost(url: string, body?: object, options?: RequestOptions): Observable<any> {
    return this.authHttp.post(url, body, this.defaultRequestOptions().merge(options))
      .map(this.extractData);
  }

  private defaultRequestOptions(): RequestOptions {
    return new RequestOptions({
      headers: this.defaultHeaders(),
    });
  }

  private defaultHeaders(): Headers {
    return new Headers({
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    });
  }

  private extractData(resp: Response): any {
    return resp.text() ? resp.json() : {};
  }
}
