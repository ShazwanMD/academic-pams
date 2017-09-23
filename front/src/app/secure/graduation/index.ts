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
import {
    graduationApplicationListReducer,
    GraduationApplicationListState,
    archivedGraduationApplicationListReducer
  } from './graduation-applications/graduation-application-list.reducer'; 
import {
      graduationListReducer,
      GraduationListState,    
  } from './graduation-applications/graduation-list.reducer';
  
import {GraduationApplicationTask} from '../../shared/model/graduation/graduation-application-task.interface';
import {GraduationApplication} from '../../shared/model/graduation/graduation-application.interface';
import {Graduation} from '../../shared/model/graduation/graduation.interface';
import { GraduationApplicationActions } from "./graduation-applications/graduation-application.action";

export interface GraduationModuleState {
  assignedGraduationApplicationTasks: GraduationApplicationTaskListState;
  pooledGraduationApplicationTasks: GraduationApplicationTaskListState;
  archivedGraduationApplications: GraduationApplicationListState;
  graduationApplications: GraduationApplicationListState;
graduations: GraduationListState;
  graduationApplicationTask: GraduationApplicationTaskState;
  graduationApplication: GraduationApplicationState;
}

export const INITIAL_GRADUATION_STATE: GraduationModuleState =
  <GraduationModuleState>{
    assignedGraduationApplicationTasks: [],
    pooledGraduationApplicationTasks: [],
    archivedGraduationApplications: <GraduationApplication[]>[],
    graduationApplicationTask: <GraduationApplicationTask>{},
    graduationApplication: {},
    graduationApplications: <GraduationApplication[]>[],
    graduations: <Graduation[]>[],
  };

export const graduationModuleReducers = {
  assignedGraduationApplicationTasks: assignedGraduationApplicationTaskListReducer,
  pooledGraduationApplicationTasks: pooledGraduationApplicationTaskListReducer,
  archivedGraduationApplications: archivedGraduationApplicationListReducer,
  graduationApplicationTask: graduationApplicationTaskReducer,
  graduationApplication: graduationApplicationReducer,
  graduationApplications: graduationApplicationListReducer,
  graduations: graduationListReducer,
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
        GraduationApplicationActions,
      ],
    };
  }
}
