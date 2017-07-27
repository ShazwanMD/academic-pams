import {Routes, RouterModule} from '@angular/router';
import {AssessmentDetailPage} from './assessment-detail.page';

export const AssessmentRoutes: Routes = [
  {path: 'term/assessments/:id', component: AssessmentDetailPage},
  {path: 'term/assessments/:canonicalCode/:id', component: AssessmentDetailPage},
];
