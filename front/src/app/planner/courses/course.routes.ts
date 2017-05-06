import {Routes, RouterModule} from '@angular/router';

import {CourseCenterPage} from "./course-center.page";
import {CourseDetailPage} from "./course-detail.page";

// Route Configuration
export const CourseRoutes: Routes = [
  {path: 'planner/courses', component: CourseCenterPage},
  {path: 'courses/:code', component: CourseDetailPage},
  // {path: 'courses-create', component: CourseCreatePage},
  // {path: 'courses-activate/:code', component: CourseActivatePage},
  // {path: 'courses-deactivate/:code', component: CourseDeactivatePage},
  // {path: 'courses-edit/:code', component: CourseEditPage},
];
