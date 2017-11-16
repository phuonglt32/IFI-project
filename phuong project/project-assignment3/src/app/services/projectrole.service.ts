import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { projectrole } from "../models/projectrole";
import { person } from '../models/person';

@Injectable()
export class Projectservice {
   constructor(private http: Http) {
   }

   url = "http://localhost:8080/api/projectrole/";

   getprojectrole(): Observable<projectrole[]> {
    return this.http.get(this.url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));

  }

  createprojectrole(projectrole) {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(projectrole);
    console.log(body);

    return this.http.post(this.url, body, options ).map((res: Response) => res.json());
  }

  getpersonbyprojectid(id): Observable<person[]>{
    console.log(this.url+id);
    return this.http.get(this.url+id)
    .map((res: Response) => res.json())
    .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }


  deleteprojectrole(person) {
    return this.http.delete(this.url + person.id);
  }

}
