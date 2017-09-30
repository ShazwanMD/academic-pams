import {Routes} from '@angular/router';

import {AcademicSessionCenterPage} from './academic-session-center.page';
import {AcademicSessionDetailPage} from './academic-session-detail.page';
import {AcademicSessionGraduationDetailPage} from './academic-session-graduation-detail.page';

export const AcademicSessionRoutes: Routes = [
  {path: 'planner/academic-sessions', component: AcademicSessionCenterPage},
  {path: 'planner/academic-sessions/:code', component: AcademicSessionDetailPage},
  {path: 'planner/academic-sessions-graduation/:code', component: AcademicSessionGraduationDetailPage},
];
