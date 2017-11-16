import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { personproject } from "../models/personproject";

@Injectable()
export class Personprojectservice {
   constructor(private http: Http) {
   }

   url = "http://localhost:8080/api/personproject/";
  createprojectrole(personproject) {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(personproject);
    console.log(body);

    return this.http.post(this.url, body, options ).map((res: Response) => res.json());
  }

  getAll(): Observable<personproject[]> {
    return this.http.get(this.url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));

  }

  delete(personproject){
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(personproject);
    return this.http.post(this.url+"del/",body,options).map((res: Response) => res.json());
  }

}
