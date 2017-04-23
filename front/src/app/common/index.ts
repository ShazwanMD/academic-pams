import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';

import {CovalentCoreModule} from '@covalent/core';

import {CommonService} from '../../services';
import {IdentityService} from '../../services';

import {EffectsModule} from "@ngrx/effects";

export interface CommonModuleState {
}
;

export const INITIAL_COMMON_STATE: CommonModuleState = <CommonModuleState>{};
export const commonModuleReducers = {
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
  ],
  declarations: [],
  exports: [],
})
export class CommonModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CommonModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
      ],
    };
  }
}
