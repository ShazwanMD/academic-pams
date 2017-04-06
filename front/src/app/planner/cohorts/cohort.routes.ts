import {Routes, RouterModule} from '@angular/router';

import {CohortCenterPage} from "./cohort-center.page";

// Route Configuration
export const CohortRoutes: Routes = [
  {path: 'planner/cohorts', component: CohortCenterPage},
  // {path: 'cohorts/:code', component: CohortDetailPage},
  // {path: 'cohorts-create', component: CohortCreatePage},
  // {path: 'cohorts-activate/:code', component: CohortActivatePage},
  // {path: 'cohorts-deactivate/:code', component: CohortDeactivatePage},
  // {path: 'cohorts-edit/:code', component: CohortEditPage},
];
