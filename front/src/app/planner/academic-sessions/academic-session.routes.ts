import {Routes, RouterModule} from '@angular/router';
import {AcademicSessionCenterPage} from "./academic-session-center.page";

// Route Configuration
export const AcademicSessionRoutes: Routes = [
  {path: 'planner/academic-sessions', component: AcademicSessionCenterPage},
  // {path: 'academic-sessions/:code', component: AcademicSessionDetailPage},
  // {path: 'academic-sessions-create', component: AcademicSessionCreatePage},
  // {path: 'academic-sessions-activate/:code', component: AcademicSessionActivatePage},
  // {path: 'academic-sessions-deactivate/:code', component: AcademicSessionDeactivatePage},
  // {path: 'academic-sessions-edit/:code', component: AcademicSessionEditPage},
];
