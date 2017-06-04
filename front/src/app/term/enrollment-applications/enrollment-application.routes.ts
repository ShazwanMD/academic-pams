import {Routes} from '@angular/router';
import {EnrollmentApplicationCenterPage} from "./enrollment-application-center.page";
import {EnrollmentApplicationTaskDetailPage} from "./enrollment-application-task-detail.page";

export const EnrollmentApplicationRoutes: Routes = [
  {path: 'term/enrollment-applications', component: EnrollmentApplicationCenterPage},
  {path: 'term/enrollment-applications/enrollment-application-task-detail/:taskId', component: EnrollmentApplicationTaskDetailPage},
];
