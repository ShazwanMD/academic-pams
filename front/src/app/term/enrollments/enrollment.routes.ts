import {Routes, RouterModule} from '@angular/router';
import {EnrollmentDetailPage} from "./enrollment-detail.page";

export const EnrollmentRoutes: Routes = [
  {path: 'term/enrollments/:id', component: EnrollmentDetailPage},
];
