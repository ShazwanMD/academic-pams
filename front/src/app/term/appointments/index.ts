import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {AppointmentCenterPage} from "./appointment-center.page";
import {AppointmentListComponent} from "./component/appointment-list.component";
import {AppointmentActions} from "./appointment.action";
import {EffectsModule} from "@ngrx/effects";
import {AppointmentEffects} from "./appointment.effect";
import {AppointmentDetailPage} from "./appointment-detail.page";
import {AppointmentComponent} from "./component/appointment.component";
import {AppointmentEditorDialog} from "./dialog/appointment-editor.dialog";
import {AppointmentCreateTaskCreatorDialog} from "./dialog/appointment-create-task-creator.dialog";
import {AppointmentUpdateTaskCreatorDialog} from "./dialog/appointment-update-task-creator.dialog";


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AppointmentEffects),
  ],
  declarations: [
    // page
    AppointmentCenterPage,
    AppointmentDetailPage,

    // component
    AppointmentListComponent,
    AppointmentComponent,
    
  //dialog
    AppointmentEditorDialog,
    AppointmentCreateTaskCreatorDialog,
    AppointmentUpdateTaskCreatorDialog,
    
  ],
  exports: [],
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


