import {Routes, RouterModule} from '@angular/router';

import {FacultyCenterPage} from "./faculty-center.page";
import {FacultyDetailPage} from "./faculty-detail.page";

export const FacultyRoutes: Routes = [
  {path: 'planner/faculties', component: FacultyCenterPage},
  {path: 'planner/faculties/:code', component: FacultyDetailPage},
];
