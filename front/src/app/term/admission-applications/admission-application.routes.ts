import {Routes, RouterModule} from '@angular/router';
import {AdmissionApplicationTaskViewPage} from "./admission-application-task-view.page";
import {AdmissionCenterPage} from "../admissions/admission-center.page";
import {AdmissionApplicationCenterPage} from "./admission-application-center.page";
import { StudentAdmissionApplicationCenterPage } from "./student-admission-application-center.page";

export const AdmissionApplicationRoutes: Routes = [
  {path: 'term/admission-applications', component: AdmissionApplicationCenterPage},
  {path: 'term/admission-applications/view-task/:taskId', component: AdmissionApplicationTaskViewPage},
  {path: 'term/admission-applications/student-admission-application-center', component: StudentAdmissionApplicationCenterPage},
];
