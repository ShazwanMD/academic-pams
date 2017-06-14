import {Routes} from '@angular/router';
import {PlannerPage} from './planner.page';
import {ProgramRoutes} from './programs/program.routes';
import {FacultyRoutes} from './faculties/faculty.routes';
import {CourseRoutes} from './courses/course.routes';
import {CohortRoutes} from './cohorts/cohort.routes';
import {AcademicSessionRoutes} from './academic-sessions/academic-session.routes';
import {CurriculumRoutes} from './curriculums/curriculum.routes';

export const PlannerModuleRoutes: Routes = [
  {path: 'planner', component: PlannerPage},
  ...AcademicSessionRoutes,
  ...FacultyRoutes,
  ...ProgramRoutes,
  ...CourseRoutes,
  ...CohortRoutes,
  ...CurriculumRoutes,
];
