import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { PersonComponent } from './person/person.component';
import { ProjectroleComponent } from './projectrole/projectrole.component';
import { Personservice } from 'app/services/person.service';
import { Projectservice } from 'app/services/projectrole.service';
import { Personprojectservice } from 'app/services/personproject.service';
import { UploadFileService } from './services/upload-file.service';
import { appRoutes } from './app.router';
import { NewpersonComponent } from './newperson/newperson.component';
import { NewprojectComponent } from './newproject/newproject.component';
import { PersonprojectComponent } from './personproject/personproject.component';
import { HeaderComponent } from './header/header.component';
import { RegisterroleComponent } from './registerrole/registerrole.component';
import { ProjectpersonComponent } from './projectperson/projectperson.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    ProjectroleComponent,
    NewpersonComponent,
    NewprojectComponent,
    PersonprojectComponent,
    HeaderComponent,
    RegisterroleComponent,
    ProjectpersonComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    appRoutes,
    HttpModule,
    HttpClientModule,
    NgxPaginationModule

  ],
  providers: [Personservice,Projectservice,Personprojectservice,UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
