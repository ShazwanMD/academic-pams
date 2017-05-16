import { StudyModeSelectComponent } from './study-modes/component/study-mode-select.component';
import { RaceCodeSelectComponent } from './race-codes/component/race-code-select.component';
import { StateCodeSelectComponent } from './state-codes/component/state-code-select.component';
import { CountryCodeSelectComponent } from './country-codes/component/country-code-select.component';
import { CommonActions } from './gender-codes/common.action';
import { GenderCodeSelectComponent } from './gender-codes/component/gender-code-select.component';
import { CommonEffects } from './gender-codes/common.effect';
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
    EffectsModule.run(CommonEffects),
  ],
  declarations: [
    
    GenderCodeSelectComponent,
    CountryCodeSelectComponent,
    StateCodeSelectComponent,
    RaceCodeSelectComponent,
    StudyModeSelectComponent,
    ],
  
  exports: [
    
    GenderCodeSelectComponent,
    CountryCodeSelectComponent,
    StateCodeSelectComponent,
    RaceCodeSelectComponent,
    StudyModeSelectComponent,
  ],
})
export class CommonModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: CommonModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        CommonActions
      ],
    };
  }
}
