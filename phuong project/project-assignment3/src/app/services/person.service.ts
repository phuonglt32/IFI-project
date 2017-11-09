import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import { person } from "../models/person";

@Injectable()
export class Personservice {
   constructor(private http: Http) {
   }

   getperson(): Observable<person[]> {
    return this.http.get("http://localhost:8080/api/person/")
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));

  }

  getpersonbyId(id): Observable<person[]>{
    let string = "http://localhost:8080/api/personbyid/"+id;
    console.log(string);
    return this.http.get(string)
    .map((res: Response) => res.json())
    .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

   createperson(person) {
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(person);
    console.log(body);

    return this.http.post("http://localhost:8080/api/person/", body, options ).map((res: Response) => res.json());
  }

  // updateHero(hero) {
  //   let headers = new Headers({ 'Content-Type': 'application/json' });
  //   let options = new RequestOptions({ headers: headers });
  //   let body = JSON.stringify(hero);
  //   console.log(hero.id);

  //   return this.http.put("http://59f14ae5a118a000126fbdec.mockapi.io/hero/hero/" + hero.id, body, options ).map((res: Response) => res.json());
  // }
    deleteperson(person) {
      return this.http.delete('http://localhost:8080/api/person/' + person.id);
    }

    projectByPersonID(id){
      return this.http.get("http://localhost:8080/api/person/"+id).map((res: Response) => res.json());
    }
}
