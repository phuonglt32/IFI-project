import { Component, OnInit } from '@angular/core';
import { Personprojectservice } from '../services/personproject.service';
import { Projectservice } from '../services/projectrole.service';
import { Personservice } from '../services/person.service';
import { personproject } from '../models/personproject';
import { log } from 'util';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-registerrole',
  templateUrl: './registerrole.component.html',
  styleUrls: ['./registerrole.component.css']
})
export class RegisterroleComponent implements OnInit {

  collection = [];
  persons;
  projects;
  personprojects;
  personproject;
  checkisupdate = false;
  checkisexcist = false;
  constructor(private personproservice: Personprojectservice,private personservice: Personservice, private proservice: Projectservice) {
    this.personprojects = personproservice.getAll();
    this.persons = personservice.getperson();
    this.projects = proservice.getprojectrole();
    for (let i = 1; i <= 100; i++) {
      this.collection.push(`per ${i}`);
    }
   }



  ngOnInit() {
    this.personproject = new personproject({idPersonal:null,idProjectRole:null},"",null,null);
  }

  Checkisexist(){
    this.checkisexcist = false;
      this.personprojects.subscribe(val => {
        val.forEach(item => {
          if(item.id.idPersonal == this.personproject.id.idPersonal && item.id.idProjectRole == this.personproject.id.idProjectRole){
            this.checkisexcist = true;
            alert("Person already have this role");
          }
        })
      });
  }
  update(p){
    this.checkisexcist = false;
    this.personproject = p;
    this.checkisupdate = true;
  }
  add(){
    this.checkisexcist = true;
    this.checkisupdate = false;
    this.personproject = new personproject({idPersonal:null,idProjectRole:null},"",null,null);
  }

  create(){
    this.personproservice.createprojectrole(this.personproject).subscribe(
      data => {
        alert("Save success");
        this.personprojects = this.personproservice.getAll();
        return false;
      },
      error => {
        //console.error("insert Success");
        alert("Fail");
      }
   );
  }

  delete(per){
    this.personproject = per;
    if (confirm("Are you sure you want to delete " + per.name + "?")) {
      this.personproservice.delete(per).subscribe(
         data => {
           // refresh the list
           this.personprojects = this.personproservice.getAll();
           return false;
         },
         error => {
           console.error("Error deleting food!");
         }
      );
    }
  }

}
