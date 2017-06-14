import {Routes} from '@angular/router';
import {AdmissionApplicationCenterPage} from './admission-application-center.page';
import {StudentAdmissionApplicationCenterPage} from './student-admission-application-center.page';
import {AdmissionApplicationTaskDetailPage} from './admission-application-task-detail.page';

export const AdmissionApplicationRoutes: Routes = [
  {path: 'term/admission-applications', component: AdmissionApplicationCenterPage},
  {
    path: 'term/admission-applications/admission-application-task-detail/:taskId',
    component: AdmissionApplicationTaskDetailPage,
  },
  {
    path: 'term/admission-applications/student-admission-application-center',
    component: StudentAdmissionApplicationCenterPage,
  },
];
