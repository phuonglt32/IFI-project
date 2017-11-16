import { Component, OnInit } from '@angular/core';
import { Personservice } from '../services/person.service';
import { person } from "../models/person";
import { Observable } from 'rxjs/Rx';
import { UploadFileService } from '../services/upload-file.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})

export class PersonComponent implements OnInit {

  collection = [];
  urlimage = "";
  persons;
  name;
  newperson: person;
  allskill;
  check = false;
  isselectfiles = false;
  selectedFiles: FileList;
  currentFileUpload: File;
  personselectedarray = [];
  progress: { percentage: number } = { percentage: 0 }
  constructor(private perservice: Personservice, private uploadService: UploadFileService) {
    this.persons = perservice.getperson();
    this.allskill = ['Java', 'Angular'];
    this.name = "";
    for (let i = 1; i <= 100; i++) {
      this.collection.push(`person ${i}`);
    }
  }


  ngOnInit() {
    this.newperson = null;
  }

  findbyname(){
    console.log(this.name);
    if(this.name != ""){
      this.persons = this.perservice.findpersonbyname(this.name);
    }else{
      this.persons = this.perservice.getperson();
    }
  }

  selectFile(e) {
    this.newperson.image = e.target.files[0].name;
    this.selectedFiles = e.target.files;
    if (e.target.files != null) {
      this.isselectfiles = true;
    } else {
      this.isselectfiles = false;
    }
    console.log(this.isselectfiles);
  }

  removeimage() {
    this.newperson.image = null;
  }


  delete(person) {
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

  update(person) {
    this.check = true;
    this.newperson = person;
  }

  updateperson() {
    console.log(this.newperson);
    this.perservice.createperson(this.newperson).subscribe(
      data => {
        setTimeout(() => {
          alert("Insert success hehe");
        }, 2000);
        this.persons = this.perservice.getperson();

        return false;
      },
      error => {
        //console.error("insert Success");
        alert("Fail");
      }
    );
    this.uploadfile();


  }

  uploadfile() {
    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    })
  }

  checkperson(e, id) {
    if (e.target.checked) {
      this.personselectedarray.push(id);
    } else {
      let indexid = this.personselectedarray.indexOf(id);
      this.personselectedarray.splice((indexid), 1);
    }
  }

  isPersonSelected(id) {
    return (this.personselectedarray.indexOf(id) !== -1);
  }

  deleteselected() {
    if (this.personselectedarray.length != 0) {
      if (confirm("Are you sure you want delete all selected person !")){
        console.log(this.personselectedarray);
        this.perservice.deletepresonbyids(this.personselectedarray).subscribe(
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
        this.personselectedarray = [];
      }else{

      }
    }else{
      alert("Please select persons you want to delete!");
    }
  }



}
