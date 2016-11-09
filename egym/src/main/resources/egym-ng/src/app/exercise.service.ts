import { Injectable } from '@angular/core';
import { Http, Response, RequestOptionsArgs, Headers, RequestOptions } from '@angular/http';

import { Exercise } from './exercise';
import { Observable } from 'rxjs/Rx';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class ExerciseService {
  private exerciseUrl: string = "api/exercise";

  constructor(private http: Http) { }

  getAll(): Observable<Exercise[]> {
    return this.http.get(this.exerciseUrl)
                .map((res: Response) => res.json() || {})
                .catch(this.handleError);
  }

  get(id: number): Observable<Exercise[]> {
    return this.http.get(`${this.exerciseUrl}/${id}`)
                .map((res: Response) => res.json()[0] || {})
                .catch(this.handleError);
  }

  add(body: Object, customHeaders?: Object): Observable<Exercise[]> {
    let bodyString = JSON.stringify(body);
    let defaultHeaders = new Headers({"Content-Type":"application/json"});
    let headers: Headers = customHeaders ? new Headers(customHeaders) : defaultHeaders;
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.post(`${this.exerciseUrl}`, bodyString, options)
                .map((res: Response) => res.json() || {})
                .catch(this.handleError);
  }

  update(body: Object, customHeaders?: Object): Observable<Exercise[]> {
    let bodyString = JSON.stringify(body);
    let defaultHeaders = new Headers({"Content-Type":"application/json"});
    let headers: Headers = customHeaders ? new Headers(customHeaders) : defaultHeaders;
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.put(`${this.exerciseUrl}`, bodyString, options)
                .map((res: Response) => res.json() || {})
                .catch(this.handleError);
  }

  patchUpdate(body: Object, customHeaders?: Object): Observable<Exercise[]> {
    let bodyString = JSON.stringify(body);
    let defaultHeaders = new Headers({"Content-Type":"application/json"});
    let headers: Headers = customHeaders ? new Headers(customHeaders) : defaultHeaders;
    let options: RequestOptions = new RequestOptions({headers: headers});
    return this.http.patch(`${this.exerciseUrl}`, bodyString, options)
                .map((res: Response) => res.json() || {})
                .catch(this.handleError);
  }

  remove(id: number): Observable<Exercise[]> {
    return this.http.delete(`${this.exerciseUrl}/${id}`)
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
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
