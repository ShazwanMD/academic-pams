import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {AppointmentListComponent} from "./component/appointment-list.component";
import {AppointmentActions} from "./appointment.action";
import {EffectsModule} from "@ngrx/effects";
//import {AppointmentEffects} from "./appointment.effect";
import {AppointmentDetailPage} from "./appointment-detail.page";
import {StudentAppointmentDetailPage} from "./student-appointment-detail.page";
import {AppointmentComponent} from "./component/appointment.component";
import {AppointmentStatusSelectComponent} from "./component/appointment-status-select.component";
import {AppointmentEditorDialog} from "./dialog/appointment-editor.dialog";
import {SectionSubModule} from "../sections/index";
import {IdentityModule} from "../../identity/index";
import { AppointmentActionComponent } from "./component/appointment-action.component";
import { AppointmentCenterPage } from "./appointment-center.page";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    SectionSubModule.forRoot(),
    IdentityModule.forRoot(),
    //EffectsModule.run(AppointmentEffects)
  ],
  declarations: [
    // page
    AppointmentDetailPage,
    AppointmentCenterPage,
    StudentAppointmentDetailPage,
    

    // component
    AppointmentListComponent,
    AppointmentComponent,
    AppointmentStatusSelectComponent,
    AppointmentActionComponent,

    //dialog
    AppointmentEditorDialog,

  ],
  exports: [
    AppointmentEditorDialog,
  ],
  entryComponents: [
    AppointmentEditorDialog,
  ],
})

export class AppointmentSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AppointmentSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        AppointmentActions,
      ],
    };
  }
}
