import {Routes, RouterModule} from '@angular/router';
import {AppointmentCenterPage} from "./appointment-center.page";
import {AppointmentDetailPage} from "./appointment-detail.page";
import {AppointmentEditorDialog} from "./dialog/appointment-editor.dialog";

// Route Configuration
export const AppointmentRoutes: Routes = [
  {path: 'term/appointments', component: AppointmentCenterPage},
  //{path: 'term/offerings/:code', component: OfferingDetailPage},
  {path: 'term/appointments-dialog', component: AppointmentEditorDialog},
  {path: 'term/appointments/:id', component: AppointmentDetailPage},
  // {path: 'offerings-create', component: OfferingCreatePage},
  // {path: 'offerings-activate/:code', component: OfferingActivatePage},
  // {path: 'offerings-deactivate/:code', component: OfferingDeactivatePage},
  // {path: 'offerings-edit/:code', component: OfferingEditPage},
];
