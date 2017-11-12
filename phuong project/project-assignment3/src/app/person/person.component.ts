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

  urlimage = "";
  persons;
  name;
  newperson: person;
  allskill;
  check = false;
  isselectfiles = false;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 }
  constructor(private perservice: Personservice,private uploadService: UploadFileService) {
    this.persons = perservice.getperson();
    this.allskill = ['Java','Angular'];
  }

  ngOnInit() {
    this.newperson = null;
  }

  selectFile(e){
    this.newperson.image = e.target.files[0].name;
    this.selectedFiles = e.target.files;
    if(e.target.files != null){
      this.isselectfiles = true;
    }else{
      this.isselectfiles = false;
    }
    console.log(this.isselectfiles);
  }

  removeimage(){
    this.newperson.image = null;
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

  update(person){
    this.check = true;
    this.newperson = person;
  }

  updateperson(){
    console.log(this.newperson);
    this.perservice.createperson(this.newperson).subscribe(
      data => {
        setTimeout(() => {
          alert("Insert success hehe");
         },2000);

        return false;
      },
      error => {
        //console.error("insert Success");
        alert("Fail");
      }
   );
   this.uploadfile();


  }

  uploadfile(){
    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    })
  }

}
