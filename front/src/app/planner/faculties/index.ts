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
import {FacultyListComponent} from "./component/faculty-list.component";
import {FacultyActions} from "./faculty.action";

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    appRoutes,
  ],
  declarations: [

    // page
    FacultyCenterPage,
    // FacultyDetailPage,

    // component
    FacultyListComponent,
  ],
  exports: [],
})

export class FacultyModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: FacultyModule,
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


