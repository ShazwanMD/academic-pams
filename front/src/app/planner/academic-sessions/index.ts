import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {EffectsModule} from "@ngrx/effects";
import {AcademicSessionEffects} from "./academic-sessions.effect";
import {AcademicSessionActions} from "./academic-session.action";
import {AcademicSessionCenterPage} from "./academic-session-center.page";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(AcademicSessionEffects),
  ],
  declarations: [
    // page
    AcademicSessionCenterPage,

    // component
  ],
  exports: [],
})

export class AcademicSessionSubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AcademicSessionSubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        AcademicSessionActions,
      ],
    };
  }
}


