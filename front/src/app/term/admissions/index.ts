import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {TermService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {EffectsModule} from "@ngrx/effects";
import {AdmissionActions} from "./admission.action";
import {AdmissionListComponent} from "./component/admission-list.component";
import {AdmissionDetailPage} from "./admission-detail.page";
import {AdmissionCenterPage} from "./admission-center.page";
import {AdmissionEffects} from "./admission.effect";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AdmissionEffects),
  ],
  declarations: [
    // page
    AdmissionCenterPage,
    AdmissionDetailPage,

    // component
    AdmissionListComponent,
  ],
  exports: [],
})

export class AdmissionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AdmissionSubModule,
      providers: [
        appRoutingProviders,
        TermService,
        IdentityService,
        CommonService,
        AdmissionActions,
      ],
    };
  }
}


