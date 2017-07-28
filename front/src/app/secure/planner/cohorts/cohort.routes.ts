import {Routes} from '@angular/router';

import {CohortCenterPage} from './cohort-center.page';
import {CohortDetailPage} from './cohort-detail.page';

export const CohortRoutes: Routes = [
  {path: 'planner/cohorts', component: CohortCenterPage},
  {path: 'planner/cohorts/:code', component: CohortDetailPage},
];
