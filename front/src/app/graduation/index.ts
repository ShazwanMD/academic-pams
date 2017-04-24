import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {GraduationService} from "../../services/graduation.service";
import {GraduationCenterPage} from "./graduation-center.page";

// export interface GraduationModuleState {
//   // todo
// }
// ;
//
// export const INITIAL_GRADUATION_STATE: GraduationModuleState =
//   <GraduationModuleState>{
//     // todo
//   };
//
// export const graduationModuleReducers = {
// // todo
// };


@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),

    // our modules
    // ngrx
  ],
  declarations: [
    // page
    GraduationCenterPage
  ],
  exports: [],
})
export class GraduationModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: GraduationModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        GraduationService,
      ],
    };
  }
}

