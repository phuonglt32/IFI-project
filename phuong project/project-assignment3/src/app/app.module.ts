import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { PersonComponent } from './person/person.component';
import { ProjectroleComponent } from './projectrole/projectrole.component';
import { Personservice } from 'app/services/person.service';
import { Projectservice } from 'app/services/projectrole.service';
import { Personprojectservice } from 'app/services/personproject.service'
import { appRoutes } from './app.router';
import { NewpersonComponent } from './newperson/newperson.component';
import { NewprojectComponent } from './newproject/newproject.component';
import { PersonprojectComponent } from './personproject/personproject.component';

@NgModule({
  declarations: [
    AppComponent,
    PersonComponent,
    ProjectroleComponent,
    NewpersonComponent,
    NewprojectComponent,
    PersonprojectComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    appRoutes,
    HttpModule

  ],
  providers: [Personservice,Projectservice,Personprojectservice],
  bootstrap: [AppComponent]
})
export class AppModule { }
