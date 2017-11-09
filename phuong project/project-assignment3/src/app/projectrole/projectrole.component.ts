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

  projectroles;
  constructor(private projectservice: Projectservice) {
    this.projectroles = projectservice.getprojectrole();
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

}
