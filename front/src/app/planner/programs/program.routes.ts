import {Routes, RouterModule} from '@angular/router';

import {ProgramCenterPage} from "./program-center.page";

// Route Configuration
export const ProgramRoutes: Routes = [
  {path: 'planner/programs', component: ProgramCenterPage},
  // {path: 'programs/:code', component: ProgramDetailPage},
  // {path: 'programs-create', component: ProgramCreatePage},
  // {path: 'programs-activate/:code', component: ProgramActivatePage},
  // {path: 'programs-deactivate/:code', component: ProgramDeactivatePage},
  // {path: 'programs-edit/:code', component: ProgramEditPage},
];
