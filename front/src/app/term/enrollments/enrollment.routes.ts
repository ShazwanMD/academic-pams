import {Routes, RouterModule} from '@angular/router';
import {EnrollmentDetailPage} from "./enrollment-detail.page";
import { StudentEnrollmentDetailPage } from "./student-enrollment-detail.page";
import { LecturerEnrollmentDetailPage } from "./lecturer-enrollment-detail.page";

export const EnrollmentRoutes: Routes = [
  {path: 'term/enrollments/:id', component: EnrollmentDetailPage},
  {path: 'term/enrollments/:id/student-enrollment-detail', component: StudentEnrollmentDetailPage},
  {path: 'term/enrollments/:id/lecturer-enrollment-detail', component: LecturerEnrollmentDetailPage},
];
