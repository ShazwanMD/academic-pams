import '@ngrx/core/add/operator/select';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {CovalentCoreModule} from '@covalent/core';

import {PlannerService} from '../../../services';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';

import {FacultyCenterPage} from "./faculty-center.page";
import {FacultyDetailPage} from "./faculty-detail.page";
import {FacultyListComponent} from "./component/faculty-list.component";
import {FacultyActions} from "./faculty.action";
import {EffectsModule} from "@ngrx/effects";
import {FacultyEffects} from "./faculty.effect";
import {FacultyComponent} from "./component/faculty.component";

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    EffectsModule.run(FacultyEffects),
  ],
  declarations: [
    // page
    FacultyCenterPage,
    FacultyDetailPage,

    // component
    FacultyListComponent,
    FacultyComponent,
  ],
  exports: [],
})

export class FacultySubModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: FacultySubModule,
      providers: [
        appRoutingProviders,
        PlannerService,
        IdentityService,
        CommonService,
        FacultyActions,
      ],
    };
  }
}


