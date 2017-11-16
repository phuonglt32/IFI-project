import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { person } from "../models/person";

@Injectable()
export class Personservice {
  constructor(private http: Http) {
  }

  url = "http://localhost:8080/api/person/";
  getperson(): Observable<person[]> {
    return this.http.get(this.url)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));

  }

  getpersonbyId(id): Observable<person[]> {
    return this.http.get(this.url+"personbyid/"+id)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  createperson(person) {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(person);
    console.log(body);

    return this.http.post(this.url, body, options).map((res: Response) => res.json());
  }

  // updateHero(hero) {
  //   let headers = new Headers({ 'Content-Type': 'application/json' });
  //   let options = new RequestOptions({ headers: headers });
  //   let body = JSON.stringify(hero);
  //   console.log(hero.id);

  //   return this.http.put("http://59f14ae5a118a000126fbdec.mockapi.io/hero/hero/" + hero.id, body, options ).map((res: Response) => res.json());
  // }
  deleteperson(person) {
    return this.http.delete(this.url + person.id);
  }

  projectByPersonID(id) {
    return this.http.get(this.url + id).map((res: Response) => res.json());
  }

  deletepresonbyids(id) {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(id);
    console.log(body);

    return this.http.post(this.url+"del/", body, options).map((res: Response) => res.json());
  }

  findpersonbyname(name){
    let urls = this.url+"personbyname/"+name;
    console.log(urls);
    return this.http.get(this.url+"personbyname/"+name)
    .map((res: Response) => res.json())
    .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }
}
