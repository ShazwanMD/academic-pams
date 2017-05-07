import {Routes, RouterModule} from '@angular/router';
import {TermPage} from "./term.page";
import {OfferingRoutes} from "./offerings/offering.routes";


export const TermModuleRoutes: Routes = [
  {path: 'term', component: TermPage},
  ...OfferingRoutes,
];
