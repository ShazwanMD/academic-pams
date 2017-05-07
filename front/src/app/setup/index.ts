import {NgModule, ModuleWithProviders} from "@angular/core";
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';


import {CovalentCoreModule} from '@covalent/core';
import {IdentityService} from '../../services';
import { SetupPage } from "./setup.page";

export interface SetupModuleState {

};
export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{

  };
export const setupModuleReducers = {

};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
 
  ],
  declarations: [
    // page
    SetupPage,
  ],
  exports: [],

})
export class SetupModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SetupModule,
       providers: [
        appRoutingProviders,
          IdentityService,
              ],
    };
  }
}