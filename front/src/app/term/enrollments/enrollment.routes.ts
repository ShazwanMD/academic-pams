import {Routes, RouterModule} from '@angular/router';
import {EnrollmentCenterPage} from "./enrollment-center.page";
import {EnrollmentDetailPage} from "./enrollment-detail.page";
import {EnrollmentEditorDialog} from "./dialog/enrollment-editor.dialog";

// Route Configuration
export const EnrollmentRoutes: Routes = [
  {path: 'term/enrollments', component: EnrollmentCenterPage},
  {path: 'term/enrollments/:id', component: EnrollmentDetailPage},
  {path: 'term/enrollments-dialog', component: EnrollmentEditorDialog},
  
  // {path: 'offerings-create', component: OfferingCreatePage},
  // {path: 'offerings-activate/:code', component: OfferingActivatePage},
  // {path: 'offerings-deactivate/:code', component: OfferingDeactivatePage},
  // {path: 'offerings-edit/:code', component: OfferingEditPage},
];
