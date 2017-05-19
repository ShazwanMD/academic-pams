import {Routes, RouterModule} from '@angular/router';
import {AppointmentDetailPage} from "./appointment-detail.page";


// Route Configuration
export const AppointmentRoutes: Routes = [
  {path: 'term/appointments/:id', component: AppointmentDetailPage},
];
