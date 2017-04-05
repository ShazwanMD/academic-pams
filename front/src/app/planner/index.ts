import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {environment} from '../../environments/environment';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {PlannerPage} from "./planner.page";
import {PlannerService} from "../../services/planner.service";
import {ProgramModule} from "./programs/index";
import {programReducer, ProgramState} from "./programs/program.reducer";
import {programListReducer, ProgramListState} from "./programs/program-list.reducer";
import {combineReducers, StoreModule} from "@ngrx/store";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";
import {ProgramEffects} from "./programs/program.effect";
import {EffectsModule} from "@ngrx/effects";
import {facultyReducer, FacultyState} from "./faculties/faculty.reducer";
import {facultyListReducer, FacultyListState} from "./faculties/faculty-list.reducer";
import {FacultyModule} from "./faculties/index";
import {FacultyEffects} from "./faculties/faculty.effect";
import {CourseListState, courseListReducer} from "./courses/course-list.reducer";
import {CourseState, courseReducer} from "./courses/course.reducer";
import {CourseModule} from "./courses/index";
import {CohortModule} from "./cohorts/index";
import {CohortState, cohortReducer} from "./cohorts/cohort.reducer";
import {CohortListState, cohortListReducer} from "./cohorts/cohort-list.reducer";

export interface PlannerState {
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

export const plannerReducer = combineReducers({
  faculties:facultyListReducer, faculty:facultyReducer,
  programs: programListReducer, program: programReducer,
  courses: courseListReducer, course: courseReducer,
  cohorts: cohortListReducer, cohort: cohortReducer,
});


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,

    // our modules
    FacultyModule.forRoot(),
    ProgramModule.forRoot(),
    CourseModule.forRoot(),
    CohortModule.forRoot(),
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

