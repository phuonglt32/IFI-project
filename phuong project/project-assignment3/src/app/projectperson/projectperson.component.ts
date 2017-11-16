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
  selector: 'app-projectperson',
  templateUrl: './projectperson.component.html',
  styleUrls: ['./projectperson.component.css']
})
export class ProjectpersonComponent implements OnInit {

  persons;
  id;
  constructor(private route: ActivatedRoute, private projectservice: Projectservice) {
    this.id = route.snapshot.params['id'];
    
  }

  ngOnInit() {
    this.persons = this.projectservice.getpersonbyprojectid(this.id);
  }

}
