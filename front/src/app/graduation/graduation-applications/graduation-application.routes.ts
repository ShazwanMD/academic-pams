import {Routes, RouterModule} from '@angular/router';
import {GraduationApplicationCenterPage} from "./graduation-application-center.page";
import {GraduationApplicationTaskViewPage} from "./graduation-application-task-view.page";

export const GraduationApplicationRoutes: Routes = [
  {path: 'graduation/graduation-applications', component: GraduationApplicationCenterPage},
  {path: 'graduation/graduation-applications/view-task/:taskId', component: GraduationApplicationTaskViewPage},
];
