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
import {AdmissionApplicationCenterPage} from "./admission-application-center.page";
import {AdmissionApplicationEffects} from "./admission-application.effect";
import {AdmissionApplicationActions} from "./admission-application.action";
import {AdmissionSubModule} from "../admissions/index";
import {AcademicSessionSubModule} from "../../planner/academic-sessions/index";
import {AdmissionApplicationDraftTaskPanel} from "./panel/admission-application-draft-task.panel";
import {AdmissionApplicationTaskCreatorDialog} from "./dialog/admission-application-task-creator.dialog";
import {AdmissionApplicationItemComponent} from "./component/admission-application-item-list.component";
import {AdmissionApplicationTaskListComponent} from "./component/admission-application-task-list.component";
import {AdmissionApplicationTaskViewPage} from "./admission-application-task-view.page";
import {AdmissionApplicationTaskWorkflowPanel} from "./panel/admission-application-task-workflow.panel";
import {AdmissionApplicationTaskStatusComponent} from "./component/admission-application-task-status.component";
import {AdmissionApplicationItemEditorDialog} from "./dialog/admission-application-item-editor.dialog";
import {SectionSubModule} from "../sections/index";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    AdmissionSubModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    SectionSubModule.forRoot(),
    EffectsModule.run(AdmissionApplicationEffects),
  ],
  declarations: [
    // page
    AdmissionApplicationCenterPage,
    AdmissionApplicationTaskViewPage,

    // component
    AdmissionApplicationTaskWorkflowPanel,
    AdmissionApplicationDraftTaskPanel,
    AdmissionApplicationItemComponent,
    AdmissionApplicationTaskListComponent,
    AdmissionApplicationTaskStatusComponent,

    //dialog
    AdmissionApplicationTaskCreatorDialog,
    AdmissionApplicationItemEditorDialog,
  ],
  exports: [
  ],
  entryComponents: [
    AdmissionApplicationTaskCreatorDialog,
    AdmissionApplicationItemEditorDialog,
    AdmissionApplicationDraftTaskPanel,
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
        AdmissionApplicationActions,
      ],
    };
  }
}


