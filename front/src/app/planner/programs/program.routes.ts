import { ProgramUpdateDialog } from './dialog/program-update.dialog';
import {Routes, RouterModule} from '@angular/router';

import {ProgramCenterPage} from "./program-center.page";
import {ProgramDetailPage} from "./program-detail.page";
import {ProgramCreatorDialog} from "./dialog/program-creator.dialog";

export const ProgramRoutes: Routes = [
  {path: 'planner/programs', component: ProgramCenterPage},
  {path: 'planner/programs/program-detail/:code', component: ProgramDetailPage},
  {path: 'planner/programs/dialog/program-creator.dialog', component: ProgramCreatorDialog},
  {path: 'planner/programs/dialog/program-update.dialog', component: ProgramUpdateDialog}
];
