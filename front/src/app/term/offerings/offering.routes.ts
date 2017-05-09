import {Routes, RouterModule} from '@angular/router';

import {OfferingCenterPage} from "./offering-center.page";
import {OfferingDetailPage} from "./offering-detail.page";

// Route Configuration
export const OfferingRoutes: Routes = [
  {path: 'term/offerings', component: OfferingCenterPage},
  {path: 'term/offerings/:canonicalCode', component: OfferingDetailPage},
  // {path: 'offerings-create', component: OfferingCreatePage},
  // {path: 'offerings-activate/:code', component: OfferingActivatePage},
  // {path: 'offerings-deactivate/:code', component: OfferingDeactivatePage},
  // {path: 'offerings-edit/:code', component: OfferingEditPage},
];
