import {GraduationApplicationTaskStatusComponent} from './component/graduation-application-task-status.component';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {EffectsModule} from '@ngrx/effects';
import {CovalentCoreModule} from '@covalent/core';
import {GraduationApplicationCenterPage} from './graduation-application-center.page';
import {StudentGraduationApplicationCenterPage} from './student-graduation-application-center.page';
import {CommonService, IdentityService} from '../../../../services';
import {GraduationService} from '../../../../services/graduation.service';
import {GraduationApplicationEffects} from './graduation-application.effect';
import {GraduationApplicationActions} from './graduation-application.action';
import {IdentityModule} from '../../identity/index';
import {CommonModule} from '../../../common/index';
import {GraduationApplicationCreatorDialog} from './dialog/graduation-application-creator.dialog';
import {AssignedGraduationApplicationTaskListComponent} from './component/assigned-graduation-application-task-list.component';
import {PooledGraduationApplicationTaskListComponent} from './component/pooled-graduation-application-task-list.component';
import {ArchivedGraduationApplicationListComponent} from './component/archived-graduation-application-list.component';
import {GraduationApplicationListComponent} from './component/graduation-application-list.component';
import {GraduationApplicationComponent} from './component/graduation-application.component';
import {GraduationApplicationDraftTaskPanel} from './panel/graduation-application-draft-task.panel';
import {GraduationApplicationTaskWorkflowPanel} from './panel/graduation-application-task-workflow.panel';
import {GraduationApplicationCheckTaskPanel} from './panel/graduation-application-check-task.panel';
import {GraduationApplicationVerifyTaskPanel} from './panel/graduation-application-verify-task.panel';
import {GraduationApplicationRegisterTaskPanel} from './panel/graduation-application-register-task.panel';
import {GraduationApplicationEditorDialog} from './dialog/graduation-application-editor.dialog';
import {AcademicSessionSubModule} from '../../planner/academic-sessions/index';
import {ProfileModule} from '../../profile/index';
import {GraduationApplicationTaskDetailPage} from './graduation-application-task-detail.page';
import { GraduationListCenterPage } from "./graduation-list-center.page";
import { GraduationApplicationDetailPage } from "./graduation-application-detail.page";
import { GraduationApplicationActionComponent } from "./component/graduation-application-action.component";
import { StudentGraduationApplicationDraftTaskPanel } from "./panel/student-graduation-application-draft-task.panel";
import { StudentGraduationApplicationTaskDetailPage } from "./student-graduation-application-task-detail.page";
import { StudentGraduationApplicationTaskWorkflowPanel } from "./panel/student-graduation-application-task-workflow.panel";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    ProfileModule.forRoot(),
    IdentityModule.forRoot(),
    CommonModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    EffectsModule.run(GraduationApplicationEffects),
  ],
  declarations: [
    // page
    GraduationApplicationCenterPage,
    GraduationApplicationDetailPage,
    GraduationListCenterPage,
    StudentGraduationApplicationCenterPage,
    GraduationApplicationTaskDetailPage,
    StudentGraduationApplicationTaskDetailPage,

    //component
    AssignedGraduationApplicationTaskListComponent,
    PooledGraduationApplicationTaskListComponent,
    ArchivedGraduationApplicationListComponent,
    GraduationApplicationListComponent,
    GraduationApplicationComponent,
    GraduationApplicationTaskWorkflowPanel,
    StudentGraduationApplicationTaskWorkflowPanel,
    GraduationApplicationDraftTaskPanel,
    StudentGraduationApplicationDraftTaskPanel,
    GraduationApplicationRegisterTaskPanel,
    GraduationApplicationVerifyTaskPanel,
    GraduationApplicationCheckTaskPanel,
    GraduationApplicationTaskStatusComponent,
    GraduationApplicationActionComponent,

    // dialog
    GraduationApplicationCreatorDialog,
    GraduationApplicationEditorDialog,
  ],
  exports: [],
  entryComponents: [
    GraduationApplicationCreatorDialog,
    GraduationApplicationEditorDialog,
    GraduationApplicationDraftTaskPanel,
    StudentGraduationApplicationDraftTaskPanel,
    GraduationApplicationRegisterTaskPanel,
    GraduationApplicationVerifyTaskPanel,
    GraduationApplicationCheckTaskPanel,
  ],

})
export class GraduationApplicationSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: GraduationApplicationSubModule,
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
