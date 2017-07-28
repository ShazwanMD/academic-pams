import {Routes} from '@angular/router';
import {GraduationPage} from './graduation.page';
import {GraduationApplicationRoutes} from './graduation-applications/graduation-application.routes';

export const GraduationModuleRoutes: Routes = [
  {path: 'graduation', component: GraduationPage},
  ...GraduationApplicationRoutes,
];
