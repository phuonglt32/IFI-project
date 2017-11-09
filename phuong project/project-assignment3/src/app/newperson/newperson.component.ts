import { Component, OnInit } from '@angular/core';
import {person} from '../models/person';
import { Personservice } from '../services/person.service';
import { Observable } from 'rxjs/Rx';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newperson',
  templateUrl: './newperson.component.html',
  styleUrls: ['./newperson.component.css']
})
export class NewpersonComponent implements OnInit {


  newperson: person;
  constructor(private personservice: Personservice,private router: Router) {

   }

  ngOnInit() {
    this.newperson = new person(null,"phuong","0212454335",new Date(),"male",null,null);
  }
  createperson(){
    console.log(this.newperson);

  //   this.personservice.createperson(this.newperson).subscribe(
  //     data => {
  //       alert("Insert success hehe");

  //       return false;
  //     },
  //     error => {
  //       //console.error("insert Success");
  //       alert("Fail");
  //     }
  //  );

  //  setTimeout(() => {
  //   this.router.navigate(['']);
  //  },1000);
  //   console.log(this.newperson);

  }

}
