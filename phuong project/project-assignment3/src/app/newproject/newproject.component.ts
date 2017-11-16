import { Component, OnInit } from '@angular/core';
import {projectrole} from '../models/projectrole';
import { Projectservice } from '../services/projectrole.service';
import { Observable } from 'rxjs/Rx';
import { Router } from '@angular/router';

@Component({
  selector: 'app-newproject',
  templateUrl: './newproject.component.html',
  styleUrls: ['./newproject.component.css']
})
export class NewprojectComponent implements OnInit {

  projects;
  newproject;
  constructor(private projectser: Projectservice,private router: Router) {

  }

  ngOnInit() {
    this.newproject = new projectrole(null,null,null);
  }
  createproject(){
    console.log(this.newproject);

    this.projectser.createprojectrole(this.newproject).subscribe(
      data => {
        alert("Insert success");

        return false;
      },
      error => {
        //console.error("insert Success");
        alert("Insert success");
      }
   );

   setTimeout(() => {
    this.router.navigate(['project']);
   },1000);

  }

}
