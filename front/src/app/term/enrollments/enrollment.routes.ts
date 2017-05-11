import {Routes, RouterModule} from '@angular/router';
import {EnrollmentCenterPage} from "./enrollment-center.page";
import {EnrollmentDetailPage} from "./enrollment-detail.page";
import {EnrollmentEditorDialog} from "./dialog/enrollment-editor.dialog";

// Route Configuration
export const EnrollmentRoutes: Routes = [
  {path: 'term/enrollments', component: EnrollmentCenterPage},
  {path: 'term/enrollments/:id', component: EnrollmentDetailPage},
];
