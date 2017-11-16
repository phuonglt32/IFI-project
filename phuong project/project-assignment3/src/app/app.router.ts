import { Routes, RouterModule } from '@angular/router';
import { PersonComponent } from '../app/person/person.component';
import { ProjectroleComponent } from '../app/projectrole/projectrole.component';
import { NewpersonComponent } from '../app/newperson/newperson.component';
import { NewprojectComponent } from '../app/newproject/newproject.component';
import { PersonprojectComponent } from '../app/personproject/personproject.component';
import { HeaderComponent } from '../app/header/header.component';
import { RegisterroleComponent } from '../app/registerrole/registerrole.component';
import { ProjectpersonComponent } from '../app/projectperson/projectperson.component';

const routing: Routes = [
  { path: '', component: HeaderComponent },
  { path: 'person', component: PersonComponent },
  { path: 'project', component: ProjectroleComponent },
  { path: 'person/newperson', component: NewpersonComponent },
  { path: 'project/newproject', component: NewprojectComponent },
  { path: 'personproject/:id', component: PersonprojectComponent },
  { path: 'projectperson/:id', component: ProjectpersonComponent},
  { path: 'registerrole', component: RegisterroleComponent }
]
export const appRoutes = RouterModule.forRoot(routing);

