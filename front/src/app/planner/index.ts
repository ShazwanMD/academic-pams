import { AcademicYearListPage } from './academic-years/academic-year-list.page';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from "../../services";
import {IdentityService} from "../../services";

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

import {AcademicSession} from "./academic-sessions/academic-session.interface";
import {AcademicSessionSubModule} from "./academic-sessions/index";
import {AcademicSessionState, academicSessionReducer} from "./academic-sessions/academic-session.reducer";
import {AcademicSessionListState, academicSessionListReducer} from "./academic-sessions/academic-session-list.reducer";

import {AcademicYearListState, academicYearListReducer} from "./academic-years/academic-year-list.reducer";
import {AcademicYear} from "./academic-years/academic-year.interface";
import {AcademicYearSubModule} from "./academic-years/index";
import {programLevelListReducer, ProgramLevelListState} from "./program-levels/program-level-list.reducer";
import {programLevelReducer, ProgramLevelState} from "./program-levels/program-level.reducer";
import {ProgramLevelSubModule} from "./program-levels/index";
import {ProgramLevel} from "./program-levels/program-level.interface";
import { AcademicYearState, academicYearReducer } from "./academic-years/academic-year.reducer";


export interface PlannerModuleState {
  academicSessions: AcademicSessionListState,
  academicSession: AcademicSessionState;
  academicYears: AcademicYearListState,
  academicYear: AcademicYearState;
  faculties: FacultyListState;
  faculty: FacultyState;
  programs: ProgramListState;
  program: ProgramState;
  programLevels: ProgramLevelListState;
  programLevel: ProgramLevelState;


  courses: CourseListState;
  course: CourseState;
  cohorts: CohortListState;
  cohort: CohortState;
}
;

export const INITIAL_PLANNER_STATE: PlannerModuleState =
  <PlannerModuleState>{
    academicSession: <AcademicSession>{},
    academicSessions: <AcademicSession[]>[],
    academicYears: <AcademicYear[]>[],
    academicYear:<AcademicYear>{},
    faculties: <Faculty[]>[],
    faculty: <Faculty>{},
    programs: <Program[]>[],
    program: <Program>{},
    programLevels: <ProgramLevel[]>[],
    programLevel: <ProgramLevel>{},
    courses: <Course[]>[],
    course: <Course>{},
    cohorts: <Cohort[]>[],
    cohort: <Cohort>{},
  };

export const plannerModuleReducers = {
  academicSession: academicSessionReducer,
  academicSessions: academicSessionListReducer,
  academicYears: academicYearListReducer,
  academicYear: academicYearReducer,
  faculties: facultyListReducer,
  faculty: facultyReducer,
  programs: programListReducer,
  program: programReducer,
  programLevels: programLevelListReducer,
  programLevel: programLevelReducer,
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
    FacultySubModule.forRoot(),
    ProgramSubModule.forRoot(),
    CourseSubModule.forRoot(),
    CohortSubModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    AcademicYearSubModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
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
