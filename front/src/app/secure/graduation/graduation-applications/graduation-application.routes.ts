import {Routes} from '@angular/router';
import {GraduationApplicationCenterPage} from './graduation-application-center.page';
import {StudentGraduationApplicationCenterPage} from './student-graduation-application-center.page';
import {GraduationApplicationTaskDetailPage} from './graduation-application-task-detail.page';

export const GraduationApplicationRoutes: Routes = [
  {path: 'graduation/graduation-applications', component: GraduationApplicationCenterPage},
  {path: 'graduation/graduation-applications/student', component: StudentGraduationApplicationCenterPage},
  {
    path: 'graduation/graduation-applications/graduation-application-task-detail/:taskId',
    component: GraduationApplicationTaskDetailPage
  },
];
