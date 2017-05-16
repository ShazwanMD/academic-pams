import {Routes, RouterModule} from '@angular/router';
import {TermPage} from "./term.page";
import {OfferingRoutes} from "./offerings/offering.routes";
//import {OfferingApplicationRoutes} from "./offering-applications/offering-application.routes";
import {EnrollmentRoutes} from "./enrollments/enrollment.routes";
import {AdmissionDetailPage} from "./admissions/admission-detail.page";
import {AdmissionRoutes} from "./admissions/admission.routes";
import {AppointmentRoutes} from "./appointments/appointment.routes";
import {EnrollmentApplicationRoutes} from "./enrollment-applications/enrollment-application.routes";
import {AdmissionApplicationRoutes} from "./admission-applications/admission-application.routes";
import {SectionRoutes} from "./sections/section.routes";

export const TermModuleRoutes: Routes = [
  {path: 'term', component: TermPage},
  {path: 'admissions/:id', component: AdmissionDetailPage},
  ...OfferingRoutes,
 // ...OfferingApplicationRoutes,
  ...EnrollmentApplicationRoutes,
  ...EnrollmentRoutes,
  ...AdmissionRoutes,
  ...AdmissionApplicationRoutes,
  ...AppointmentRoutes,
  ...SectionRoutes,

];
