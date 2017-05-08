import {Routes, RouterModule} from '@angular/router';

import {CourseCenterPage} from "./course-center.page";
import {CourseDetailPage} from "./course-detail.page";

export const CourseRoutes: Routes = [
  {path: 'planner/courses', component: CourseCenterPage},
  {path: 'planner/courses/:code', component: CourseDetailPage},
];
