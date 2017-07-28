import { GpaCalculateDialog } from './dialog/gpa-calculate.dialog';
import { GradebookCalculateDialog } from './dialog/gradebook-calculate.dialog';
import { GradebookComponent } from './component/gradebook.component';
import '@ngrx/core/add/operator/select';
import { appRoutes, appRoutingProviders } from '../../../app.routes';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { CovalentCoreModule } from '@covalent/core';
import { TermService } from '../../../../services';
import { CommonService } from '../../../../services';
import { IdentityService } from '../../../../services';

import { OfferingCenterPage } from "./offering-center.page";
import { OfferingListComponent } from "./component/offering-list.component";
import { OfferingActions } from "./offering.action";
import { EffectsModule } from "@ngrx/effects";
import { OfferingEffects } from "./offering.effect";
import { OfferingDetailPage } from "./offering-detail.page";
import { StudentOfferingDetailPage } from "./student-offering-detail.page";
import { OfferingComponent } from "./component/offering.component";
import { OfferingEditorDialog } from "./dialog/offering-editor.dialog";
import { OfferingUpdateDialog } from "./dialog/offering-update.dialog";
import { CourseSubModule } from "../../planner/courses/index";
import { ProgramSubModule } from "../../planner/programs/index";
import { SectionSubModule } from "../sections/index";
import { AcademicSessionSubModule } from "../../planner/academic-sessions/index";
import { OfferingSectionListComponent } from "./component/offering-section-list.component";
import { StudentOfferingSectionListComponent } from "./component/student-offering-section-list.component";
import { OfferingAssessmentListComponent } from "./component/offering-assessment-list.component";
import { StudentOfferingAssessmentListComponent } from "./component/student-offering-assessment-list.component";
import { OfferingEnrollmentListComponent } from "./component/offering-enrollment-list.component";
import { OfferingAppointmentListComponent } from "./component/offering-appointment-list.component";
import { OfferingActionComponent } from "./component/offering-action.component";
import { GradebookDetailPage } from "./gradebook-detail.page";
import { PipeModule } from "../../../app.pipe.module";
import { StudentOfferingCenterPage } from "./student-offering-center.page";
import { LecturerOfferingCenterPage } from "./lecturer-offering-center.page";
import { LecturerOfferingDetailPage } from "./lecturer-offering-detail.page";
import { LecturerOfferingActionComponent } from "./component/lecturer-offering-action.component";
import { LecturerOfferingSectionListComponent } from "./component/lecturer-offering-section-list.component";
import {NotificationService} from '../../../../services/notification.service';

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CourseSubModule.forRoot(),
    ProgramSubModule.forRoot(),
    SectionSubModule.forRoot(),
    AcademicSessionSubModule.forRoot(),
    CovalentCoreModule.forRoot(),
    EffectsModule.run(OfferingEffects),

    PipeModule
  ],
  declarations: [
    // page
    OfferingCenterPage,
    LecturerOfferingCenterPage,
    StudentOfferingCenterPage,
    OfferingDetailPage,
    StudentOfferingDetailPage,
    LecturerOfferingDetailPage,
    GradebookDetailPage,

    // component
    OfferingListComponent,
    OfferingComponent,
    OfferingSectionListComponent,
    StudentOfferingSectionListComponent,
    LecturerOfferingSectionListComponent,
    OfferingAssessmentListComponent,
    StudentOfferingAssessmentListComponent,
    OfferingEnrollmentListComponent,
    OfferingAppointmentListComponent,
    OfferingActionComponent,
    LecturerOfferingActionComponent,
    GradebookComponent,

    //dialog
    OfferingEditorDialog,
    OfferingUpdateDialog,
    GradebookCalculateDialog,
    GpaCalculateDialog,


  ],
  exports: [
    OfferingUpdateDialog,
    GpaCalculateDialog,
    GradebookCalculateDialog,
  ],
  entryComponents: [
    OfferingEditorDialog,
    OfferingUpdateDialog,
    GradebookCalculateDialog,
    GpaCalculateDialog,
    GradebookComponent,

  ]
})

export class OfferingSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: OfferingSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        NotificationService,
        OfferingActions,
      ],
    };
  }
}


