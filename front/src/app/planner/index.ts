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

export interface PlannerState {
  programs: ProgramListState;
  program: ProgramState;
  faculties: FacultyListState;
  faculty: FacultyState;
}
;

const plannerReducer = combineReducers({
  programs: programListReducer, program: programReducer,
  faculties:facultyListReducer, faculty:facultyReducer,
});


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,

    // our modules
    ProgramModule.forRoot(),
    FacultyModule.forRoot(),

    // ngrx
    StoreModule.provideStore(plannerReducer),
    EffectsModule.run(ProgramEffects),
    EffectsModule.run(FacultyEffects),
    StoreDevtoolsModule.instrumentOnlyWithExtension(),
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

