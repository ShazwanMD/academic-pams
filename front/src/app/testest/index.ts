import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {ProfileService} from "../../services/profile.service";

import {TestPage} from "./test.page";
import {AbcPage} from "./abc.page";

export interface TestModuleState {
  // todo
}
;

export const INITIAL_TEST_STATE: TestModuleState =
  <TestModuleState>{
    // todo
  };

  export const testModuleReducers = {
// todo
};


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
    TestPage,
    AbcPage,
  ],
  exports: [],
})
export class TestestModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: TestestModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        ProfileService,
      ],
    };
  }
}

