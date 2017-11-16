import { Component, OnInit } from '@angular/core';
import { person } from '../models/person';
import { Personservice } from '../services/person.service';
import { Observable } from 'rxjs/Rx';
import { Router } from '@angular/router';
import { UploadFileService } from '../services/upload-file.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';

@Component({
  selector: 'app-newperson',
  templateUrl: './newperson.component.html',
  styleUrls: ['./newperson.component.css']
})
export class NewpersonComponent implements OnInit {


  newperson: person;
  allskill;
  selectedFiles: FileList;
  currentFileUpload: File;
  url;
  progress: { percentage: number } = { percentage: 0 }
  constructor(private personservice: Personservice, private router: Router, private uploadService: UploadFileService) {
    this.allskill = ['Java', 'Angular'];
  }

  ngOnInit() {
    this.newperson = new person(null, null, null, new Date(), null, "Java", null, null, null);

  }


  createperson() {
    console.log(this.newperson);

    this.personservice.createperson(this.newperson).subscribe(
      data => {
        setTimeout(() => {
          alert("Insert success hehe");
        }, 1000);

        return false;
      },
      error => {
        //console.error("insert Success");
        alert("Fail");
      }
    );
    this.uploadfile();

    setTimeout(() => {
      this.router.navigate(['/person']);
    }, 1500);
  }

  selectFile(e) {
    console.log(e.target.files[0].name);
    this.newperson.image = e.target.files[0].name;
    this.selectedFiles = e.target.files;
    var reader = new FileReader();
    reader.onload = (event: any) => {
      this.url = event.target.result;
    }

    reader.readAsDataURL(e.target.files[0]);
  }

  uploadfile() {
    this.currentFileUpload = this.selectedFiles.item(0)
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
      }
    })
  }

  removeimage() {
    this.newperson.image = null;
  }

}
