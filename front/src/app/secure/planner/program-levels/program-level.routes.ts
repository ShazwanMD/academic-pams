import {Routes} from '@angular/router';

import {ProgramLevelCenterPage} from './program-level-center.page';
import {ProgramLevelDetailPage} from './program-level-detail.page';

export const ProgramLevelRoutes: Routes = [
  {path: 'planner/program-levels', component: ProgramLevelCenterPage},
  {path: 'planner/program-levels/:code', component: ProgramLevelDetailPage},
];
