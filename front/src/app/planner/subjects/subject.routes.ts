import {Routes} from '@angular/router';

import {SubjectCenterPage} from "./subject-center.page";
import {SubjectDetailPage} from "./subject-detail.page";

export const SubjectRoutes: Routes = [
  {path: 'planner/subjects', component: SubjectCenterPage},
  {path: 'planner/subjects/subject-detail', component: SubjectDetailPage},
];
