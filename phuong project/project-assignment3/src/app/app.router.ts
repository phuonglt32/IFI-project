import { Routes, RouterModule } from '@angular/router';
import { PersonComponent } from 'app/person/person.component';
import { ProjectroleComponent } from 'app/projectrole/projectrole.component';
import { NewpersonComponent } from 'app/newperson/newperson.component';
import { NewprojectComponent } from 'app/newproject/newproject.component';
import { PersonprojectComponent } from '../app/personproject/personproject.component';

const routing: Routes = [
  { path: '', component: PersonComponent },
  { path: 'project', component: ProjectroleComponent },
  { path: 'newperson', component: NewpersonComponent },
  { path: 'project/newproject', component: NewprojectComponent },
  { path: 'personproject/:id', component: PersonprojectComponent }
]
export const appRoutes = RouterModule.forRoot(routing);

