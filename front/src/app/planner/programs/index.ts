import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {ProgramCenterPage} from "./program-center.page";
import {ProgramListComponent} from "./component/program-list.component";
import {ProgramActions} from "./program.action";

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,
  ],
  declarations: [

    // page
    ProgramCenterPage,
    // ProgramDetailPage,

    // component
    ProgramListComponent,
  ],
  exports: [],
})

export class ProgramModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ProgramModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        ProgramActions,
      ],
    };
  }
}


