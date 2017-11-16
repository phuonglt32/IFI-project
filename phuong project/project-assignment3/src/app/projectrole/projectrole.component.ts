import { Component, OnInit } from '@angular/core';
import { Projectservice } from '../services/projectrole.service';
import { projectrole } from "../models/projectrole";
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-projectrole',
  templateUrl: './projectrole.component.html',
  styleUrls: ['./projectrole.component.css']
})
export class ProjectroleComponent implements OnInit {

  collection = [];
  projectroles;
  newproject;
  check = false;
  constructor(private projectservice: Projectservice) {
    this.projectroles = projectservice.getprojectrole();
    for (let i = 1; i <= 100; i++) {
      this.collection.push(`project ${i}`);
    }
   }

  ngOnInit() {
  }

  delete(project){
    if (confirm("Are you sure you want to delete " + project.name + "?")) {
      this.projectservice.deleteprojectrole(project).subscribe(
         data => {
           // refresh the list
           this.projectroles = this.projectservice.getprojectrole();
           return false;
         },
         error => {
           console.error("Error deleting food!");
           return Observable.throw(error);
         }
      );
    }
  }

  update(project){
    this.newproject = project;
    this.check = true;
  }

  updateproject(){
    this.projectservice.createprojectrole(this.newproject).subscribe(
      data => {
        alert("Insert success");

        return false;
      },
      error => {
        //console.error("insert Success");
        alert("Fail");
      }
    )}
}
