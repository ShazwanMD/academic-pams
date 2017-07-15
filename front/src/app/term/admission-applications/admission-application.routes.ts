import {Routes} from '@angular/router';
import {AdmissionApplicationCenterPage} from './admission-application-center.page';
import {AdmissionApplicationTaskDetailPage} from './admission-application-task-detail.page';
import { StudentAdmissionApplicationTaskDetailPage } from "./student-admission-application-task-detail.page";
import { AdmissionApplicationDetailPage } from "./admission-application-detail.page";
import { StudentAdmissionApplicationCenterPage } from "./admission-application-center2.page";

export const AdmissionApplicationRoutes: Routes = [
  {path: 'term/admission-applications/admission-application-center2', component: StudentAdmissionApplicationCenterPage},
  {path: 'term/admission-applications', component: AdmissionApplicationCenterPage},
  {path: 'term/admission-applications/:referenceNo', component: AdmissionApplicationDetailPage},
  //{path: 'term/admission-applications/:referenceNo/student-admission-application-detail', component: StudentAdmissionApplicationDetailPage},
  {
    path: 'term/admission-applications/admission-application-task-detail/:taskId',
    component: AdmissionApplicationTaskDetailPage,
  },
  
  /*{
      path: 'term/admission-applications/student-admission-application-task-detail/:taskId',
      component: StudentAdmissionApplicationTaskDetailPage,
    },
*/    
  {
      path: 'term/admission-applications/student-admission-application-task-detail/:taskId',
      component: StudentAdmissionApplicationTaskDetailPage,
    },
    
 
];
