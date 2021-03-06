import {Routes} from '@angular/router';
import {AppointmentDetailPage} from './appointment-detail.page';
import {StudentAppointmentDetailPage} from './student-appointment-detail.page';
import {AppointmentCenterPage} from './appointment-center.page';

// Route Configuration
export const AppointmentRoutes: Routes = [
  {path: 'term/appointments', component: AppointmentCenterPage},
  {path: 'term/appointments/:id', component: AppointmentDetailPage},
  {path: 'term/appointments/:id/student-appointment-detail', component: StudentAppointmentDetailPage},
];
