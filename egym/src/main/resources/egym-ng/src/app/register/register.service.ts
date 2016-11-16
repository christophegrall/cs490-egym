import { Injectable } from '@angular/core';
import { Http, Response, RequestOptionsArgs, Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RegisterService {
  private authUrl: string = "auth";

  constructor(private http: Http) { }

  requestAuth(username: string, password: string): Observable<Object> {
    let body: Object = {
      "username": username,
      "password": password
    }
    let bodyString = JSON.stringify(body);
    let headers: Headers = new Headers({"Content-Type":"application/json"});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(`${this.authUrl}`, bodyString, options)
                .map((res: Response) => res.json() || {})
                .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    return Observable.throw(errMsg);
  }
}
