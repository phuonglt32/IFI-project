import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { personproject } from "../models/personproject";

@Injectable()
export class Personprojectservice {
   constructor(private http: Http) {
   }

  createprojectrole(personproject) {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(personproject);
    console.log(body);

    return this.http.post("http://localhost:8080/api/personproject/", body, options ).map((res: Response) => res.json());
  }

}
