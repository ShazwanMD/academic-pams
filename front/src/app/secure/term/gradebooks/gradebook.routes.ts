import {Routes, RouterModule} from '@angular/router';
import {GradebookDetailPage} from './gradebook-detail.page';

export const GradebookRoutes: Routes = [
  {path: 'term/gradebooks/:id', component: GradebookDetailPage},
];
