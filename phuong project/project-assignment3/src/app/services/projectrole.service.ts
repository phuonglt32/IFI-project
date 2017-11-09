import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { projectrole } from "../models/projectrole";

@Injectable()
export class Projectservice {
   constructor(private http: Http) {
   }

   getprojectrole(): Observable<projectrole[]> {
    return this.http.get("http://localhost:8080/api/projectrole/")
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));

  }

  createprojectrole(projectrole) {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(projectrole);
    console.log(body);

    return this.http.post("http://localhost:8080/api/projectrole/", body, options ).map((res: Response) => res.json());
  }

  deleteprojectrole(person) {
    return this.http.delete('http://localhost:8080/api/projectrole/' + person.id);
  }

}
