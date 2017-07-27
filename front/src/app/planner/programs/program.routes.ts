import {Routes} from '@angular/router';

import {ProgramCenterPage} from './program-center.page';
import {ProgramDetailPage} from './program-detail.page';

export const ProgramRoutes: Routes = [
  {path: 'planner/programs', component: ProgramCenterPage},
  {path: 'planner/programs/program-detail/:code', component: ProgramDetailPage},
];
