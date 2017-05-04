import {Routes, RouterModule} from '@angular/router';
import {PlannerPage} from "./planner.page";
import {ProgramRoutes} from "./programs/program.routes";
import {FacultyRoutes} from "./faculties/faculty.routes";
import {CourseRoutes} from "./courses/course.routes";
import {CohortRoutes} from "./cohorts/cohort.routes";
import {AbcPage} from "./abc.page";



export const PlannerModuleRoutes: Routes = [
  {path: 'planner', component: PlannerPage},
  {path: 'AbcPage', component: AbcPage},
  ...FacultyRoutes,
  ...ProgramRoutes,
  ...CourseRoutes,
  ...CohortRoutes,
  
];
 
