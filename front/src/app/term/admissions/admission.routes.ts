import {Routes, RouterModule} from '@angular/router';

import {AdmissionDetailPage} from "./admission-detail.page";
import {AdmissionCenterPage} from "./admission-center.page";

export const AdmissionRoutes: Routes = [
  {path: 'term/admissions', component: AdmissionCenterPage},
  // {path: 'term/admissions/:academicSessionCode', component: AdmissionDetailPage},
  {path: 'term/admissions/current', component: AdmissionDetailPage},
];
