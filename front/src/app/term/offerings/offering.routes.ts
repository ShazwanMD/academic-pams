import {Routes, RouterModule} from '@angular/router';
import {OfferingCenterPage} from "./offering-center.page";
import {OfferingDetailPage} from "./offering-detail.page";

export const OfferingRoutes: Routes = [
  {path: 'term/offerings', component: OfferingCenterPage},
  {path: 'term/offerings/:canonicalCode', component: OfferingDetailPage},
];
