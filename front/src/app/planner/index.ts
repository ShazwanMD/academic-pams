import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {PlannerPage} from "./planner.page";
import {PlannerService} from "../../services/planner.service";
import {ProgramSubModule} from "./programs/index";
import {programReducer, ProgramState} from "./programs/program.reducer";
import {programListReducer, ProgramListState} from "./programs/program-list.reducer";
import {facultyReducer, FacultyState} from "./faculties/faculty.reducer";
import {facultyListReducer, FacultyListState} from "./faculties/faculty-list.reducer";
import {FacultySubModule} from "./faculties/index";
import {CourseListState, courseListReducer} from "./courses/course-list.reducer";
import {CourseState, courseReducer} from "./courses/course.reducer";
import {CourseSubModule} from "./courses/index";
import {CohortSubModule} from "./cohorts/index";
import {CohortState, cohortReducer} from "./cohorts/cohort.reducer";
import {CohortListState, cohortListReducer} from "./cohorts/cohort-list.reducer";
import {Faculty} from "./faculties/faculty.interface";
import {Program} from "./programs/program.interface";
import {Cohort} from "./cohorts/cohort.interface";
import {Course} from "./courses/course.interface";
import {academicSessionReducer, AcademicSessionState} from "./academic-sessions/academic-session.reducer";
import {AcademicSession} from "./academic-sessions/academic-session.interface";
import {academicSessionListReducer, AcademicSessionListState} from "./academic-sessions/academic-session-list.reducer";
import {AcademicSessionSubModule} from "./academic-sessions/index";

export interface PlannerModuleState {
  academicSessions: AcademicSessionListState;
  academicSession: AcademicSessionState;
  faculties: FacultyListState;
  faculty: FacultyState;
  programs: ProgramListState;
  program: ProgramState;
  courses: CourseListState;
  course: CourseState;
  cohorts: CohortListState;
  cohort: CohortState;
}
;

export const INITIAL_PLANNER_STATE: PlannerModuleState =
  <PlannerModuleState>{
    academicSessions: <AcademicSession[]>[],
    academicSession: <AcademicSession>{},
    faculties: <Faculty[]>[],
    faculty: <Faculty>{},
    programs: <Program[]>[],
    program: <Program>{},
    courses: <Course[]>[],
    course: <Course>{},
    cohorts: <Cohort[]>[],
    cohort: <Cohort>{},
  };

export const plannerModuleReducers = {
  academicSessions: academicSessionListReducer,
  academicSession: academicSessionReducer,
  faculties: facultyListReducer,
  faculty: facultyReducer,
  programs: programListReducer,
  program: programReducer,
  courses: courseListReducer,
  course: courseReducer,
  cohorts: cohortListReducer,
  cohort: cohortReducer,
};


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),

    // our modules
    AcademicSessionSubModule.forRoot(),
    FacultySubModule.forRoot(),
    ProgramSubModule.forRoot(),
    CourseSubModule.forRoot(),
    CohortSubModule.forRoot(),
  ],
  declarations: [
    // page
    PlannerPage,
  ],
  exports: [],
})
export class PlannerModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: PlannerModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PlannerService,
      ],
    };
  }
}

