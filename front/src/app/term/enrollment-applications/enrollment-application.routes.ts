import {Routes, RouterModule} from '@angular/router';
import {EnrollmentApplicationTaskViewPage} from "./enrollment-application-task-view.page";
import {EnrollmentApplicationCenterPage} from "./enrollment-application-center.page";

export const EnrollmentApplicationRoutes: Routes = [
  {path: 'term/enrollment-applications', component: EnrollmentApplicationCenterPage},
  {path: 'term/enrollment-applications/view-task/:taskId', component: EnrollmentApplicationTaskViewPage},
];
