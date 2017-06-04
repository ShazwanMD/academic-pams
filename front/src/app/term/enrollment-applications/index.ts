import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {EffectsModule} from "@ngrx/effects";
import {EnrollmentApplicationCenterPage} from "./enrollment-application-center.page";
import {EnrollmentApplicationEffects} from "./enrollment-application.effect";
import {EnrollmentApplicationActions} from "./enrollment-application.action";
import {AdmissionSubModule} from "../admissions/index";
import {AcademicSessionSubModule} from "../../planner/academic-sessions/index";
import {EnrollmentApplicationDraftTaskPanel} from "./panel/enrollment-application-draft-task.panel";
import {EnrollmentApplicationTaskCreatorDialog} from "./dialog/enrollment-application-task-creator.dialog";
import {EnrollmentApplicationItemComponent} from "./component/enrollment-application-item-list.component";
import {EnrollmentApplicationTaskListComponent} from "./component/enrollment-application-task-list.component";
import {EnrollmentApplicationsListComponent} from "./component/enrollment-applications-list.component";


import {EnrollmentApplicationTaskWorkflowPanel} from "./panel/enrollment-application-task-workflow.panel";
import {EnrollmentApplicationTaskStatusComponent} from "./component/enrollment-application-task-status.component";
import {EnrollmentApplicationItemEditorDialog} from "./dialog/enrollment-application-item-editor.dialog";
import {SectionSubModule} from "../sections/index";
import {EnrollmentApplicationActionSelectComponent} from "./component/enrollment-application-action-select.component";
import {EnrollmentApplicationTypeSelectComponent} from "./component/enrollment-application-type-select.component";
import {AssignedEnrollmentApplicationTaskListComponent} from "./component/assigned-enrollment-application-task-list.component";
import {PooledEnrollmentApplicationTaskListComponent} from "./component/pooled-enrollment-application-task-list.component";
import {EnrollmentApplicationTaskDetailPage} from "./enrollment-application-task-detail.page";
import { IdentityModule } from "../../identity/index";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    AdmissionSubModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    SectionSubModule.forRoot(),
    IdentityModule.forRoot(),
    EffectsModule.run(EnrollmentApplicationEffects),
  ],
  declarations: [
    // page
    EnrollmentApplicationCenterPage,
    EnrollmentApplicationTaskDetailPage,

    // component
    EnrollmentApplicationTaskWorkflowPanel,
    EnrollmentApplicationDraftTaskPanel,
    EnrollmentApplicationItemComponent,
    EnrollmentApplicationTaskListComponent,
    EnrollmentApplicationsListComponent,
    EnrollmentApplicationTaskStatusComponent,
    EnrollmentApplicationActionSelectComponent,
    EnrollmentApplicationTypeSelectComponent,
    AssignedEnrollmentApplicationTaskListComponent,
    PooledEnrollmentApplicationTaskListComponent,

    //dialog
    EnrollmentApplicationTaskCreatorDialog,
    EnrollmentApplicationItemEditorDialog,
  ],
  exports: [
    EnrollmentApplicationActionSelectComponent,
  ],
  entryComponents: [
    EnrollmentApplicationTaskCreatorDialog,
    EnrollmentApplicationItemEditorDialog,
    EnrollmentApplicationDraftTaskPanel,
  ]
})

export class EnrollmentApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: EnrollmentApplicationSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        EnrollmentApplicationActions,
      ],
    };
  }
}


