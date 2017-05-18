import {Routes, RouterModule} from '@angular/router';
import {AppointmentCenterPage} from "./appointment-center.page";
import {AppointmentDetailPage} from "./appointment-detail.page";
import {AppointmentEditorDialog} from "./dialog/appointment-editor.dialog";
import {AppointmentCreateTaskCreatorDialog} from "./dialog/appointment-create-task-creator.dialog";
import {AppointmentUpdateTaskCreatorDialog} from "./dialog/appointment-update-task-creator.dialog";


// Route Configuration
export const AppointmentRoutes: Routes = [
  {path: 'term/appointments', component: AppointmentCenterPage},
   {path: 'term/appointments-dialog', component: AppointmentEditorDialog},
  {path: 'term/appointments-dialog', component: AppointmentCreateTaskCreatorDialog},
  {path: 'term/appointments-dialog', component: AppointmentUpdateTaskCreatorDialog},
  {path: 'term/appointments/:id', component: AppointmentDetailPage},
  // {path: 'offerings-create', component: OfferingCreatePage},
  // {path: 'offerings-activate/:code', component: OfferingActivatePage},
  // {path: 'offerings-deactivate/:code', component: OfferingDeactivatePage},
  // {path: 'offerings-edit/:code', component: OfferingEditPage},
];
