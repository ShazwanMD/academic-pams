import {Routes} from '@angular/router';
import {EnrollmentApplicationCenterPage} from './enrollment-application-center.page';
import {StudentEnrollmentCenterPage} from './student-enrollment-center.page';
import {EnrollmentApplicationTaskDetailPage} from './enrollment-application-task-detail.page';
import {StudentEnrollmentApplicationTaskDetailPage} from './student-enrollment-application-task-detail.page';
import {EnrollmentApplicationDetailPage} from './enrollment-application-detail.page';
import { ItemDetailPage } from "./item-detail.page";
import {StudentEnrollmentApplicationDetailPage } from "./student-enrollment-application-detail.page";
import { StudentEnrollmentApplicationHistoryPage } from "./student-enrollment-application-history.page";

export const EnrollmentApplicationRoutes: Routes = [
  {path: 'term/enrollment-applications', component: EnrollmentApplicationCenterPage},
  {path: 'term/enrollment-applications/student-enrollment-center', component: StudentEnrollmentCenterPage},
  {path: 'term/enrollment-applications/enrollment-application-task-detail/:taskId',component: EnrollmentApplicationTaskDetailPage},
  {path: 'term/items/:id', component: ItemDetailPage},
  {path: 'term/enrollment-applications/student-enrollment-application-task-detail/:taskId', component: StudentEnrollmentApplicationTaskDetailPage},
  {path: 'term/enrollment-applications/:referenceNo', component: StudentEnrollmentApplicationHistoryPage},  
  {path: 'term/enrollment-applications/:referenceNo/student-enrollment-application-detail', component: StudentEnrollmentApplicationDetailPage},
  {path: 'term/enrollment-applications/:referenceNo/enrollment-application-detail',
    component: EnrollmentApplicationDetailPage},
];
