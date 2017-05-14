import {Routes, RouterModule} from '@angular/router';
import {AdmissiontApplicationTaskViewPage} from "./admission-application-task-view.page";
import {AdmissionCenterPage} from "../enrollments/admission-center.page";
import {AdmissionApplicationCenterPage} from "./admission-application-center.page";

export const AdmissionApplicationRoutes: Routes = [
  {path: 'term/admission-applications', component: AdmissionApplicationCenterPage},
  {path: 'term/admission-applications/view-task/:taskId', component: AdmissionApplicationTaskViewPage},
];
