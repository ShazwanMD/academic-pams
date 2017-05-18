import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';
import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {EnrollmentCenterPage} from "./enrollment-center.page";
import {EnrollmentListComponent} from "./component/enrollment-list.component";
import {EnrollmentActions} from "./enrollment.action";
import {EffectsModule} from "@ngrx/effects";
import {EnrollmentEffects} from "./enrollment.effect";
import {EnrollmentDetailPage} from "./enrollment-detail.page";
import {EnrollmentComponent} from "./component/enrollment.component";
import {EnrollmentEditorDialog} from "./dialog/enrollment-editor.dialog";

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
    EnrollmentCenterPage,
    EnrollmentDetailPage,
    

    // component
    EnrollmentListComponent,
    EnrollmentComponent,
    
  //dialog
    EnrollmentEditorDialog,
  ],
  exports: [],
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


