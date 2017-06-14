import {IdentityModule} from '../../identity/index';
import {SetupModule} from '../../setup/index';
import {AcademicSessionSubModule} from '../../planner/academic-sessions/index';
import {CohortSubModule} from '../../planner/cohorts/index';
import {AcademicStandingSelectComponent} from './component/academic-standing-select.component';
import {AdmissionStatusSelectComponent} from './component/admission-status-select.component';
import '@ngrx/core/add/operator/select';
import { appRoutes, appRoutingProviders } from '../../app.routes';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { CovalentCoreModule } from '@covalent/core';

import { TermService } from '../../../services';
import { CommonService } from '../../../services';
import { IdentityService } from '../../../services';

import { EffectsModule } from "@ngrx/effects";
import { AdmissionActions } from "./admission.action";
import { AdmissionListComponent } from "./component/admission-list.component";
import { AdmissionComponent } from "./component/admission.component";
import { AdmissionDetailPage } from "./admission-detail.page";
import { AdmissionCenterPage } from "./admission-center.page";
import { AdmissionEffects } from "./admission.effect";
import { AdmissionSelectComponent } from "./component/admission-select.component";
import {AdmissionCreateTaskCreatorDialog} from "./dialog/admission-create-task-creator.dialog";
import {AdmissionUpdateTaskCreatorDialog} from "./dialog/admission-update-task-creator.dialog";
import {AdmissionDeleteTaskCreatorDialog} from "./dialog/admission-delete-task-creator.dialog";
import {AdmissionApplicationActions} from "./admission-application.action";
import {PipeModule} from "../../app.pipe.module";
import { AdmissionEnrollmentListComponent } from "./component/admission-enrollment-list.component";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CohortSubModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    SetupModule.forRoot(),
        IdentityModule.forRoot(),
    PipeModule,
    EffectsModule.run(AdmissionEffects),
  ],
  declarations: [
    // page
    AdmissionCenterPage,
    AdmissionDetailPage,

    // component
    AdmissionListComponent,
    AdmissionComponent,
    AdmissionSelectComponent,
    AdmissionStatusSelectComponent,
    AcademicStandingSelectComponent,
    AdmissionEnrollmentListComponent,
    
    //dialog
    AdmissionCreateTaskCreatorDialog,
    AdmissionUpdateTaskCreatorDialog,
    AdmissionDeleteTaskCreatorDialog,
  ],
  exports: [
    AdmissionSelectComponent,
  ],
})

export class AdmissionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AdmissionSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        AdmissionActions,
        AdmissionApplicationActions,
      ],
    };
  }
}


