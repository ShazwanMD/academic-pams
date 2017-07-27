import {Routes} from '@angular/router';

import {CourseCenterPage} from './course-center.page';
import {CourseDetailPage} from './course-detail.page';

export const CourseRoutes: Routes = [
  {path: 'planner/courses', component: CourseCenterPage},
  {path: 'planner/courses/course-detail/:code', component: CourseDetailPage},
];
