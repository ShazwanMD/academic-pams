import { AdmissionApplicationTaskEditorDialog } from './dialog/admission-application-task-editor.dialog';
import { AdmissionApplicationActionComponent } from './component/admission-application-action.component';
import { AdmissionApplicationDetailPage } from "./admission-application-detail.page";
import { AdmissionApplicationComponent } from "./component/admission-application.component";
import { AdmissionApplicationListComponent } from "./component/admission-application-list.component";
import '@ngrx/core/add/operator/select';
import { appRoutes, appRoutingProviders } from '../../app.routes';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { CovalentCoreModule } from '@covalent/core';
import { TermService } from "../../../services";
import { CommonService } from "../../../services";
import { IdentityService } from "../../../services";
import { EffectsModule } from "@ngrx/effects";
import { AdmissionApplicationEffects } from "./admission-application.effect";
import { AdmissionApplicationActions } from "./admission-application.action";
import { AdmissionSubModule } from "../admissions/index";
import { AcademicSessionSubModule } from "../../planner/academic-sessions/index";
import { SetupModule } from "./../../setup/index";
import { ProgramSubModule } from "../../planner/programs/index";
import { AdmissionApplicationDraftTaskPanel } from "./panel/admission-application-draft-task.panel";
import { AdmissionApplicationTaskCreatorDialog } from "./dialog/admission-application-task-creator.dialog";
import { AdmissionApplicationTaskListComponent } from "./component/admission-application-task-list.component";
import { AdmissionApplicationTaskViewPage } from "./admission-application-task-view.page";
import { AdmissionApplicationTaskWorkflowPanel } from "./panel/admission-application-task-workflow.panel";
import { AdmissionApplicationTaskStatusComponent } from "./component/admission-application-task-status.component";
import { SectionSubModule } from "../sections/index";
import { AdmissionApplicationCenterPage } from "./admission-application-center.page";
import { IdentityModule } from "../../identity/index";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    AdmissionSubModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    ProgramSubModule.forRoot(),
    SectionSubModule.forRoot(),
    SetupModule.forRoot(),
    IdentityModule.forRoot(),
    EffectsModule.run(AdmissionApplicationEffects),
  ],

  declarations: [
    // page
    AdmissionApplicationTaskViewPage,
    AdmissionApplicationCenterPage,
    AdmissionApplicationDetailPage,

    // component
    AdmissionApplicationTaskWorkflowPanel,
    AdmissionApplicationDraftTaskPanel,
    AdmissionApplicationTaskListComponent,
    AdmissionApplicationTaskStatusComponent,
    AdmissionApplicationListComponent,
    AdmissionApplicationComponent,
    AdmissionApplicationActionComponent,

    //dialog
    AdmissionApplicationTaskCreatorDialog,
    AdmissionApplicationTaskEditorDialog,
  ],

  exports: [
    AdmissionApplicationComponent,
    AdmissionApplicationActionComponent,
    AdmissionApplicationListComponent,

  ],

  entryComponents: [
    AdmissionApplicationTaskCreatorDialog,
    AdmissionApplicationTaskEditorDialog,
    AdmissionApplicationDraftTaskPanel,
  ]
})

export class AdmissionApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AdmissionApplicationSubModule,
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


