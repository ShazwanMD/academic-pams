import {Routes} from '@angular/router';
import {EnrollmentApplicationCenterPage} from "./enrollment-application-center.page";
import {StudentEnrollmentCenterPage} from "./student-enrollment-center.page";
import {EnrollmentApplicationTaskDetailPage} from "./enrollment-application-task-detail.page";
import {StudentEnrollmentApplicationTaskDetailPage} from "./student-enrollment-application-task-detail.page";
import { EnrollmentApplicationDetailPage } from "./enrollment-application-detail.page";

export const EnrollmentApplicationRoutes: Routes = [
  {path: 'term/enrollment-applications', component: EnrollmentApplicationCenterPage},
  {path: 'term/enrollment-applications/student-enrollment-center', component: StudentEnrollmentCenterPage},
  {path: 'term/enrollment-applications/enrollment-application-task-detail/:taskId', component: EnrollmentApplicationTaskDetailPage},
  {path: 'term/enrollment-applications/:referenceNo', component: StudentEnrollmentApplicationTaskDetailPage},
  {path: 'term/enrollment-applications/:referenceNo/enrollment-application-detail', component: EnrollmentApplicationDetailPage},
];
