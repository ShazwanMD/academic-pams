import {Routes, RouterModule} from '@angular/router';
import {PlannerPage} from "./planner.page";
import {ProgramRoutes} from "./programs/program.routes";
import {FacultyRoutes} from "./faculties/faculty.routes";


export const PlannerModuleRoutes: Routes = [
  {path: 'planner', component: PlannerPage},
  ...FacultyRoutes,
  ...ProgramRoutes,
  // ...CourseRoutes,
];
