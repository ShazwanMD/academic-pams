import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService, IdentityService, TermService, NotificationService} from '../../../../services';
import {EffectsModule} from '@ngrx/effects';
import {EnrollmentApplicationCenterPage} from './enrollment-application-center.page';
import {StudentEnrollmentCenterPage} from './student-enrollment-center.page';
import {EnrollmentApplicationEffects} from './enrollment-application.effect';
import {EnrollmentApplicationActions} from './enrollment-application.action';
import {AdmissionSubModule} from '../admissions/index';
import {AcademicSessionSubModule} from '../../planner/academic-sessions/index';
import {EnrollmentApplicationDraftTaskPanel} from './panel/enrollment-application-draft-task.panel';
import {EnrollmentApplicationTaskCreatorDialog} from './dialog/enrollment-application-task-creator.dialog';
import {EnrollmentApplicationItemComponent} from './component/enrollment-application-item-list.component';
import {EnrollmentApplicationTaskListComponent} from './component/enrollment-application-task-list.component';
import {EnrollmentApplicationsListComponent} from './component/enrollment-applications-list.component';

import {EnrollmentApplicationTaskWorkflowPanel} from './panel/enrollment-application-task-workflow.panel';
import {EnrollmentApplicationTaskStatusComponent} from './component/enrollment-application-task-status.component';
import {EnrollmentApplicationItemEditorDialog} from './dialog/enrollment-application-item-editor.dialog';
import {SectionSubModule} from '../sections/index';
import {EnrollmentApplicationActionSelectComponent} from './component/enrollment-application-action-select.component';
import {EnrollmentApplicationTypeSelectComponent} from './component/enrollment-application-type-select.component';
import {AssignedEnrollmentApplicationTaskListComponent} from './component/assigned-enrollment-application-task-list.component';
import {StudentEnrollmentListComponent} from './component/student-enrollment-list.component';
import {StudentOfferingListComponent} from './component/student-offering-list.component';
import {PooledEnrollmentApplicationTaskListComponent} from './component/pooled-enrollment-application-task-list.component';
import {ArchivedEnrollmentApplicationListComponent} from './component/archived-enrollment-application-list.component';
import {EnrollmentApplicationTaskDetailPage} from './enrollment-application-task-detail.page';
import {StudentEnrollmentApplicationTaskDetailPage} from './student-enrollment-application-task-detail.page';
import {IdentityModule} from '../../identity/index';
import {StudentEnrollmentApplicationItemComponent} from './component/student-enrollment-application-item.component';
import {StudentEnrollmentApplicationListComponent} from './component/student-enrollment-application-list.component';
import {StudentEnrollmentApplicationTaskDetailActionComponent} from './component/student-enrollment-application-task-detail-action.component';
import {EnrollmentApplicationItemUpdateDialog} from './dialog/enrollment-application-item-update.dialog';
import {EnrollmentApplicationDetailPage} from './enrollment-application-detail.page';
import { EnrollmentApplicationTaskDialog } from "./dialog/enrollment-application-task.dialog";
import { ItemDetailPage } from "./item-detail.page";
import { ItemComponent } from "./component/item.component";
import { ItemActionComponent } from "./component/item-action.component";
import { StudentEnrollmentApplicationDetailPage } from "./student-enrollment-application-detail.page";
import { StudentEnrollmentApplicationDraftTaskPanel } from "./panel/student-enrollment-application-draft-task.panel";
import { StudentEnrollmentApplicationTaskWorkflowPanel } from "./panel/student-enrollment-application-task-workflow.panel";
import { StudentEnrollmentApplicationHistoryPage } from "./student-enrollment-application-history.page";
import { StudentEnrollmentApplicationCenterPage } from "./student-enrollment-application-center.page";

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
    StudentEnrollmentCenterPage,
    StudentEnrollmentApplicationCenterPage,
    EnrollmentApplicationTaskDetailPage,
    EnrollmentApplicationDetailPage,
    ItemDetailPage,
    StudentEnrollmentApplicationTaskDetailPage,
    StudentEnrollmentApplicationHistoryPage,
    StudentEnrollmentApplicationDetailPage,

    // component
    EnrollmentApplicationTaskWorkflowPanel,
    StudentEnrollmentApplicationTaskWorkflowPanel,
    EnrollmentApplicationDraftTaskPanel,
    StudentEnrollmentApplicationDraftTaskPanel,
    EnrollmentApplicationItemComponent,
    EnrollmentApplicationTaskListComponent,
    EnrollmentApplicationsListComponent,

    EnrollmentApplicationTaskStatusComponent,
    EnrollmentApplicationActionSelectComponent,
    EnrollmentApplicationTypeSelectComponent,
    AssignedEnrollmentApplicationTaskListComponent,
    StudentEnrollmentListComponent,
    StudentEnrollmentApplicationListComponent,
    StudentEnrollmentApplicationTaskDetailActionComponent,
    StudentOfferingListComponent,
    PooledEnrollmentApplicationTaskListComponent,
    ArchivedEnrollmentApplicationListComponent,
    StudentEnrollmentApplicationItemComponent,
    ItemComponent,
    ItemActionComponent,

    //dialog
    EnrollmentApplicationTaskCreatorDialog,
    EnrollmentApplicationTaskDialog,
    EnrollmentApplicationItemEditorDialog,
    EnrollmentApplicationItemUpdateDialog,
  ],
  exports: [
    EnrollmentApplicationActionSelectComponent,
    ArchivedEnrollmentApplicationListComponent,
  ],
  entryComponents: [
    EnrollmentApplicationTaskCreatorDialog,
    EnrollmentApplicationTaskDialog,
    EnrollmentApplicationItemEditorDialog,
    EnrollmentApplicationItemUpdateDialog,
    EnrollmentApplicationDraftTaskPanel,
    StudentEnrollmentApplicationDraftTaskPanel,
  ],
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
        NotificationService,
        EnrollmentApplicationActions,
      ],
    };
  }
}
