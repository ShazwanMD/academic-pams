import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService, IdentityService} from '../../../services';
import {GraduationPage} from './graduation.page';
import {GraduationService} from '../../../services/graduation.service';
import {GraduationApplicationSubModule} from './graduation-applications/index';
import {
  graduationApplicationReducer,
  GraduationApplicationState
} from './graduation-applications/graduation-application.reducer';
import {
  assignedGraduationApplicationTaskListReducer,
  GraduationApplicationTaskListState,
  pooledGraduationApplicationTaskListReducer
} from './graduation-applications/graduation-application-task-list.reducer';

import {
  graduationApplicationTaskReducer,
  GraduationApplicationTaskState
} from './graduation-applications/graduation-application-task.reducer';
import {GraduationApplicationTask} from '../../shared/model/graduation/graduation-application-task.interface';

export interface GraduationModuleState {
  assignedGraduationApplicationTasks: GraduationApplicationTaskListState;
  pooledGraduationApplicationTasks: GraduationApplicationTaskListState;
  graduationApplicationTask: GraduationApplicationTaskState;
  graduationApplication: GraduationApplicationState;
}

export const INITIAL_GRADUATION_STATE: GraduationModuleState =
  <GraduationModuleState>{
    assignedGraduationApplicationTasks: [],
    pooledGraduationApplicationTasks: [],
    graduationApplicationTask: <GraduationApplicationTask>{},
    graduationApplication: {},
  };

export const graduationModuleReducers = {
  assignedGraduationApplicationTasks: assignedGraduationApplicationTaskListReducer,
  pooledGraduationApplicationTasks: pooledGraduationApplicationTaskListReducer,
  graduationApplicationTask: graduationApplicationTaskReducer,
  graduationApplication: graduationApplicationReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    GraduationApplicationSubModule.forRoot(),
  ],
  declarations: [
    // page
    GraduationPage,
  ],
  exports: [],
})
export class GraduationModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: GraduationModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        GraduationService,
      ],
    };
  }
}
