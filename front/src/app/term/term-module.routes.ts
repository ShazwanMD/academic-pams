import {Routes, RouterModule} from '@angular/router';
import {TermPage} from "./term.page";
import {OfferingRoutes} from "./offerings/offering.routes";
import {EnrollmentRoutes} from "./enrollments/enrollment.routes";
import {AdmissionDetailPage} from "./admissions/admission-detail.page";
import {AdmissionRoutes} from "./admissions/admission.routes";
import {AppointmentRoutes} from "./appointments/appointment.routes";

export const TermModuleRoutes: Routes = [
  {path: 'term', component: TermPage},
  {path: 'admissions/:id', component: AdmissionDetailPage},
   ...OfferingRoutes,
   ...EnrollmentRoutes,
   ...AdmissionRoutes,
   ...AppointmentRoutes,
  
];
