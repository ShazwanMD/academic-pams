import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {CommonService, IdentityService, TermService} from '../../../../services';
import {SectionActions} from './section.action';
import {SectionDetailPage} from './section-detail.page';
import {StudentSectionDetailPage} from './student-section-detail.page';
import {SectionComponent} from './component/section.component';
import {SectionListComponent} from './component/section-list.component';
import {SectionEnrollmentListComponent} from './component/section-enrollment-list.component';
import {StudentSectionEnrollmentListComponent} from './component/student-section-enrollment-list.component';
import {SectionAppointmentListComponent} from './component/section-appointment-list.component';
import {StudentSectionAppointmentListComponent} from './component/student-section-appointment-list.component';
import {SectionGradebookListComponent} from './component/section-gradebook-list.component';
import {SectionSelectComponent} from './component/section-select.component';
import {SectionEditorDialog} from './dialog/section-editor.dialog';
import {SectionActionComponent} from './component/section-action.component';
import {LecturerSectionDetailPage} from './lecturer-section-detail.page';
import {LecturerSectionEnrollmentListComponent} from './component/lecturer-section-enrollment-list.component';
import {StudentSectionActionComponent} from './component/student-section-action.component';
import { CapitalizePipe } from './capitalize.pipe';
import {NotificationService} from '../../../../services/notification.service';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    // EffectsModule.run(SectionEffects), // lazy load bug, moved to app root. Fix in Angular 4
  ],
  declarations: [
    // page
    SectionDetailPage,
    StudentSectionDetailPage,
    LecturerSectionDetailPage,
    CapitalizePipe,

    // component
    SectionListComponent,
    SectionComponent,
    SectionSelectComponent,
    SectionEnrollmentListComponent,
    StudentSectionEnrollmentListComponent,
    LecturerSectionEnrollmentListComponent,
    SectionAppointmentListComponent,
    StudentSectionAppointmentListComponent,
    SectionGradebookListComponent,
    SectionActionComponent,
    StudentSectionActionComponent,

    //dialog
    SectionEditorDialog,

  ],
  exports: [
    SectionSelectComponent,
    SectionListComponent,
    SectionEnrollmentListComponent,
    StudentSectionEnrollmentListComponent,
    LecturerSectionEnrollmentListComponent,
    SectionAppointmentListComponent,
    StudentSectionAppointmentListComponent,
    SectionGradebookListComponent,
    SectionEditorDialog,
  ],
  entryComponents: [
    SectionEditorDialog,
    SectionSelectComponent,
  ],
})

export class SectionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SectionSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        SectionActions,
        NotificationService,
      ],
    };
  }
}
