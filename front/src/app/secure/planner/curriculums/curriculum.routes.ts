import {Routes} from '@angular/router';

import {CurriculumCenterPage} from './curriculum-center.page';
import {CurriculumDetailPage} from './curriculum-detail.page';

export const CurriculumRoutes: Routes = [
  {path: 'planner/curriculums', component: CurriculumCenterPage},
  {path: 'planner/curriculums/:code', component: CurriculumDetailPage},
];
