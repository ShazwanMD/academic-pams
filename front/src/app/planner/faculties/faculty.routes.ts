import {Routes, RouterModule} from '@angular/router';

import {FacultyCenterPage} from "./faculty-center.page";
import {FacultyDetailPage} from "./faculty-detail.page";

// Route Configuration
export const FacultyRoutes: Routes = [
  {path: 'planner/faculties', component: FacultyCenterPage},
   {path: 'faculties/:code', component: FacultyDetailPage},
  // {path: 'faculties-create', component: FacultyCreatePage},
  // {path: 'faculties-activate/:code', component: FacultyActivatePage},
  // {path: 'faculties-deactivate/:code', component: FacultyDeactivatePage},
  // {path: 'faculties-edit/:code', component: FacultyEditPage},
];
