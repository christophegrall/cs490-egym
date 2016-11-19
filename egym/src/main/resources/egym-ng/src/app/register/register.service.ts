import { Injectable } from '@angular/core';
import { Http, Response, RequestOptionsArgs, Headers, RequestOptions } from '@angular/http';

import { Observable } from 'rxjs/Rx';
import { User, UserResponse } from './user';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RegisterService {
  private authUrl: string = "api/user";
  private response: UserResponse;

  constructor(private http: Http) { }

  createUser(user: User): Observable<UserResponse> {
    let bodyString = JSON.stringify(user);
    let headers: Headers = new Headers({"Content-Type":"application/json"});
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(`${this.authUrl}`, bodyString, options)
                    .map((res: Response) => {
                      this.response = new UserResponse(res.status, res.text());
                      return this.response;
                    })
                    .catch(this.handleError);
  }

  private handleError(error: Response | any) {
    let err: UserResponse;
    if (error instanceof Response) {
      err = new UserResponse(error.status, error.text());
    } else {
      err = error.message ? error.message : error.toString();
    }
    return Observable.throw(err);
  }
}
