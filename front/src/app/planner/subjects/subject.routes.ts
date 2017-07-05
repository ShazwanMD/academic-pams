import {Routes} from '@angular/router';

import {SubjectCenterPage} from "./subject-center.page";
import {SubjectDetailPage} from "./subject-detail.page";

export const subjectRoutes: Routes = [
  {path: 'planner/subjects', component: SubjectCenterPage},
  {path: 'planner/subjects/subject-detail/:code', component: SubjectDetailPage},
];
