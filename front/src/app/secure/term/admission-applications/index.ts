import {PooledAdmissionApplicationTaskListComponent} from './component/pooled-admission-application-task-list.component';
import {ArchivedAdmissionApplicationListComponent} from './component/archived-admission-application-list.component';
import {AssignedAdmissionApplicationTaskListComponent} from './component/assigned-admission-application-task-list.component';
import {AdmissionApplicationTaskEditorDialog} from './dialog/admission-application-task-editor.dialog';
import {AdmissionApplicationActionComponent} from './component/admission-application-action.component';
import {AdmissionApplicationComponent} from './component/admission-application.component';
import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService, IdentityService, TermService} from '../../../../services';
import {EffectsModule} from '@ngrx/effects';
import {AdmissionApplicationEffects} from './admission-application.effect';
import {AdmissionApplicationActions} from './admission-application.action';
import {AdmissionSubModule} from '../admissions/index';
import {AcademicSessionSubModule} from '../../planner/academic-sessions/index';
import {SetupModule} from '../../setup/index';
import {ProgramSubModule} from '../../planner/programs/index';
import {AdmissionApplicationDraftTaskPanel} from './panel/admission-application-draft-task.panel';
import {StudentAdmissionApplicationDraftTaskPanel} from './panel/student-admission-application-draft-task.panel';
import {AdmissionApplicationTaskCreatorDialog} from './dialog/admission-application-task-creator.dialog';
import {AdmissionApplicationTaskWorkflowPanel} from './panel/admission-application-task-workflow.panel';
import {StudentAdmissionApplicationTaskWorkflowPanel} from './panel/student-admission-application-task-workflow.panel';
import {AdmissionApplicationTaskStatusComponent} from './component/admission-application-task-status.component';
import {SectionSubModule} from '../sections/index';
import {AdmissionApplicationCenterPage} from './admission-application-center.page';
import {IdentityModule} from '../../identity/index';
import {PipeModule} from '../../../app.pipe.module';
import {AdmissionApplicationTaskDetailPage} from './admission-application-task-detail.page';
import {AdmissionApplicationTaskListComponent} from './component/admission-application-task-list.component';
import {AdmissionApplicationRegisterTaskPanel} from './panel/admission-application-register-task.panel';
import {StudentAdmissionApplicationTaskDetailPage} from './student-admission-application-task-detail.page';
import {AdmissionApplicationDetailPage} from './admission-application-detail.page';
import {StudentAdmissionApplicationDetailPage} from './student-admission-application-detail.page';
import {StudentAdmissionApplicationCenterPage} from './admission-application-center2.page';
import {StudentAdmissionApplicationActionComponent} from './component/student-admission-application-action.component';

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
    PipeModule,
    IdentityModule.forRoot(),
    EffectsModule.run(AdmissionApplicationEffects),
  ],

  declarations: [
    // page
    AdmissionApplicationTaskDetailPage,
    StudentAdmissionApplicationTaskDetailPage,
    AdmissionApplicationCenterPage,
    AdmissionApplicationDetailPage,
    StudentAdmissionApplicationDetailPage,
    StudentAdmissionApplicationCenterPage,

    // component
    AdmissionApplicationTaskWorkflowPanel,
    StudentAdmissionApplicationTaskWorkflowPanel,
    AdmissionApplicationDraftTaskPanel,
    StudentAdmissionApplicationDraftTaskPanel,
    AdmissionApplicationRegisterTaskPanel,
    AdmissionApplicationTaskListComponent,
    AdmissionApplicationTaskStatusComponent,
    // AdmissionApplicationListComponent,
    AdmissionApplicationComponent,
    AdmissionApplicationActionComponent,
    StudentAdmissionApplicationActionComponent,
    AssignedAdmissionApplicationTaskListComponent,
    PooledAdmissionApplicationTaskListComponent,
    ArchivedAdmissionApplicationListComponent,

    // dialog
    AdmissionApplicationTaskCreatorDialog,
    AdmissionApplicationTaskEditorDialog,
  ],

  exports: [
    AdmissionApplicationComponent,
    AdmissionApplicationActionComponent,
    StudentAdmissionApplicationActionComponent,
    // AdmissionApplicationListComponent,
    AssignedAdmissionApplicationTaskListComponent,
    PooledAdmissionApplicationTaskListComponent,
    ArchivedAdmissionApplicationListComponent,
    StudentAdmissionApplicationCenterPage,
    StudentAdmissionApplicationTaskWorkflowPanel,

  ],

  entryComponents: [
    AdmissionApplicationTaskCreatorDialog,
    AdmissionApplicationTaskEditorDialog,
    AdmissionApplicationDraftTaskPanel,
    StudentAdmissionApplicationDraftTaskPanel,
    AdmissionApplicationRegisterTaskPanel,
  ],
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
