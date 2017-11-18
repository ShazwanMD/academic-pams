import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService, IdentityService, TermService} from '../../../../services';
import {EnrollmentListComponent} from './component/enrollment-list.component';
import {EnrollmentActions} from './enrollment.action';
import {EffectsModule} from '@ngrx/effects';
import {EnrollmentEffects} from './enrollment.effect';
import {EnrollmentDetailPage} from './enrollment-detail.page';
import {EnrollmentComponent} from './component/enrollment.component';
import {EnrollmentActionComponent} from './component/enrollment-action.component';
import {StudentEnrollmentActionComponent} from './component/student-enrollment-action.component';
import {LecturerEnrollmentActionComponent} from './component/lecturer-enrollment-action.component';
import {EnrollmentEditorDialog} from './dialog/enrollment-editor.dialog';
import {EnrollmentStatusSelectComponent} from './component/enrollment-status-select.component';
import {EnrollmentStandingSelectComponent} from './component/enrollment-standing-select.component';
import {EnrollmentGradebookListComponent} from './component/enrollment-gradebook-list.component';
import {StudentEnrollmentDetailPage} from './student-enrollment-detail.page';
import {LecturerEnrollmentDetailPage} from './lecturer-enrollment-detail.page';
import { AdminLecturerEnrollmentDetailPage } from "./admin-lecturer-enrollment-detail.page";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(EnrollmentEffects),
  ],
  declarations: [
    // page
    EnrollmentDetailPage,
    StudentEnrollmentDetailPage,
    LecturerEnrollmentDetailPage,
    AdminLecturerEnrollmentDetailPage,

    // component
    EnrollmentListComponent,
    EnrollmentGradebookListComponent,
    EnrollmentComponent,
    EnrollmentActionComponent,
    StudentEnrollmentActionComponent,
    LecturerEnrollmentActionComponent,
    EnrollmentStatusSelectComponent,
    EnrollmentStandingSelectComponent,

    //dialog
    EnrollmentEditorDialog,
  ],
  exports: [
    EnrollmentEditorDialog,
  ],
  entryComponents: [
    EnrollmentEditorDialog,
  ],
})

export class EnrollmentSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: EnrollmentSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        EnrollmentActions,
      ],
    };
  }
}

