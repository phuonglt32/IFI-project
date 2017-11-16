import { Component, OnInit } from '@angular/core';
import { Personservice } from '../services/person.service';
import { Projectservice } from '../services/projectrole.service';
import { projectrole } from "../models/projectrole";
import { Observable } from 'rxjs/Rx';
import { ActivatedRoute} from '@angular/router';
import { personproject } from "../models/personproject";
import { Personprojectservice } from '../services/personproject.service';
import { person } from '../models/person';

@Component({
  selector: 'app-personproject',
  templateUrl: './personproject.component.html',
  styleUrls: ['./personproject.component.css']
})
export class PersonprojectComponent implements OnInit {

  projectroles;
  allprojectroles;
  id: number;
  person;
  newpersonproject: personproject;
  nameperson;
  constructor(private perservice: Personservice,private route: ActivatedRoute,private projectservice: Projectservice,private personproject: Personprojectservice) {
    this.id = parseInt(route.snapshot.params['id']);
    this.allprojectroles = projectservice.getprojectrole();
    this.allprojectroles.subscribe(val=>{
      console.log(val[0]);
    })

   }

  ngOnInit() {
    this.projectroles = this.perservice.projectByPersonID(this.id);
    //this.person = this.perservice.getpersonbyId(this.id);
    this.newpersonproject = new personproject({idPersonal:this.id,idProjectRole:null},"",null,null);

  }

  createpersonproject(){
    this.personproject.createprojectrole(this.newpersonproject).subscribe(
      data => {
        alert("Insert success hehe");
        this.projectroles = this.perservice.projectByPersonID(this.id);
        return false;
      },
      error => {
        //console.error("insert Success");
        alert("Fail");
      }
   );
    console.log("adadas");

  }

}
