import {Routes, RouterModule} from '@angular/router';
import {PlannerPage} from "./planner.page";
import {ProgramRoutes} from "./programs/program.routes";
import {FacultyRoutes} from "./faculties/faculty.routes";
import {CourseRoutes} from "./courses/course.routes";
import {CohortRoutes} from "./cohorts/cohort.routes";
import {AbcPage} from "./abc.page";
import {AcademicSessionRoutes} from "./academic-sessions/academic-session.routes";



export const PlannerModuleRoutes: Routes = [
  {path: 'planner', component: PlannerPage},
  ...AcademicSessionRoutes,
  ...FacultyRoutes,
  ...ProgramRoutes,
  ...CourseRoutes,
  ...CohortRoutes,

];

