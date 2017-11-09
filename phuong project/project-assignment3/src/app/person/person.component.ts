import { Component, OnInit } from '@angular/core';
import { Personservice } from '../services/person.service';
import { person } from "../models/person";
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  persons;
  name;
  constructor(private perservice: Personservice) {
    this.persons = perservice.getperson();
  }

  ngOnInit() {
  }

  delete(person){
    if (confirm("Are you sure you want to delete " + person.name + "?")) {
      this.perservice.deleteperson(person).subscribe(
         data => {
           // refresh the list
           this.persons = this.perservice.getperson();
           return false;
         },
         error => {
           console.error("Error deleting food!");
           return Observable.throw(error);
         }
      );
    }
  }

}
