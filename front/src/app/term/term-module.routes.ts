import {Routes, RouterModule} from '@angular/router';
import {TermPage} from "./term.page";
import {OfferingRoutes} from "./offerings/offering.routes";
import {AdmissionDetailPage} from "./admissions/admission-detail.page";


export const TermModuleRoutes: Routes = [
  {path: 'term', component: TermPage},
  {path: 'admissions/:code', component: AdmissionDetailPage},
   ...OfferingRoutes,
];
