import { Injectable } from '@angular/core';
import { Http, Response, RequestOptionsArgs, Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { AuthResponse, Auth } from './auth';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class LoginService {
  private authUrl: string = "api/auth";
  private response: AuthResponse;

  constructor(private http: Http) { }

  requestAuth(auth: Auth): Observable<AuthResponse> {
    let bodyString = JSON.stringify(auth);
    let headers: Headers = new Headers({"Content-Type":"application/json"});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(`${this.authUrl}`, bodyString, options)
                    .map((res: Response) => {
                      this.response = new AuthResponse(res.status, res.text(), res.json()['token']);
                      return this.response;
                    })
                    .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    let err: AuthResponse;
    if (error instanceof Response) {
      err = new AuthResponse(error.status, error.text());
    } else {
      err = error.message ? error.message : error.toString();
    }
    return Observable.throw(err);
  }
}
