import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {CohortCenterPage} from "./cohort-center.page";
import {CohortListComponent} from "./component/cohort-list.component";
import {CohortActions} from "./cohort.action";
import {EffectsModule} from "@ngrx/effects";
import {CohortEffects} from "./cohort.effect";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(CohortEffects),
  ],
  declarations: [

    // page
    CohortCenterPage,
    // CohortDetailPage,

    // component
    CohortListComponent,
  ],
  exports: [],
})

export class CohortModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CohortModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        CohortActions,
      ],
    };
  }
}


