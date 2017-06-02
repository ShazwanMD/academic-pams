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
import {SectionComponent} from "./component/section.component";
import {SectionListComponent} from "./component/section-list.component";
import {SectionEnrollmentListComponent} from "./component/section-enrollment-list.component";
import {SectionAppointmentListComponent} from "./component/section-appointment-list.component";
import {SectionSelectComponent} from "./component/section-select.component";
import {SectionEditorDialog} from "./dialog/section-editor.dialog";
import {SectionActionComponent} from "./component/section-action.component";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    //SectionModule.forRoot(),
    CovalentCoreModule.forRoot(),
    // EffectsModule.run(SectionEffects), // lazy load bug, moved to app root. Fix in Angular 4
  ],
  declarations: [
    // page
    SectionDetailPage,

    // component
    SectionListComponent,
    SectionComponent,
    SectionSelectComponent,
    SectionEnrollmentListComponent,
    SectionAppointmentListComponent,
    SectionActionComponent,
    

    //dialog
    SectionEditorDialog, 

  ],
  exports: [
    SectionSelectComponent,
    SectionListComponent,
    SectionEnrollmentListComponent,
    SectionAppointmentListComponent,
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
