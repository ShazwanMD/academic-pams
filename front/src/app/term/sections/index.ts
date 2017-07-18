import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {SectionActions} from "./section.action";
import {EffectsModule} from "@ngrx/effects";
import {SectionEffects} from "./section.effect";
import {SectionDetailPage} from "./section-detail.page";
import {StudentSectionDetailPage} from "./student-section-detail.page";
import {SectionComponent} from "./component/section.component";
import {SectionListComponent} from "./component/section-list.component";
import {SectionEnrollmentListComponent} from "./component/section-enrollment-list.component";
import {StudentSectionEnrollmentListComponent} from "./component/student-section-enrollment-list.component";
import {SectionAppointmentListComponent} from "./component/section-appointment-list.component";
import {StudentSectionAppointmentListComponent} from "./component/student-section-appointment-list.component";
import {SectionSelectComponent} from "./component/section-select.component";
import {SectionEditorDialog} from "./dialog/section-editor.dialog";
import {SectionActionComponent} from "./component/section-action.component";
import { LecturerSectionDetailPage } from "./lecturer-section-detail.page";

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

    // component
    SectionListComponent,
    SectionComponent,
    SectionSelectComponent,
    SectionEnrollmentListComponent,
    StudentSectionEnrollmentListComponent,
    SectionAppointmentListComponent,
    StudentSectionAppointmentListComponent,
    SectionActionComponent,
    


    //dialog
    SectionEditorDialog,

  ],
  exports: [
    SectionSelectComponent,
    SectionListComponent,
    SectionEnrollmentListComponent,
    StudentSectionEnrollmentListComponent,
    SectionAppointmentListComponent,
    StudentSectionAppointmentListComponent,
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
      ],
    };
  }
}