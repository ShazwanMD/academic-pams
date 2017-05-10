import { RaceCode } from './../common/race-codes/race-code.interface';
import { RaceCodeListPage } from './race-codes/race-code-list.page';
import { MaritalCodeListPage } from './marital-codes/marital-code-list.page';
import { MaritalCode } from './marital-codes/marital-code.interface';
import { CountryCode } from './../common/country-codes/country-code.interface';
import { CommonEffects } from './../common/gender-codes/common.effect';
import { CommonActions } from './../common/gender-codes/common.action';
import { CountryCodeListPage } from './country-codes/country-code-list.page';
import { EffectsModule } from '@ngrx/effects';
import { GenderCodeListPage } from './gender-codes/gender-code-list.page';
import { GenderCode } from './../common/gender-codes/gender-code.interface';
import { SetupActions } from './setup.action';
import { SetupEffects } from './setup.effect';
import { CommonModule } from './../common/index';
import {NgModule, ModuleWithProviders} from "@angular/core";
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {IdentityService} from '../../services';
import { SetupPage } from "./setup.page";
import {genderCodeListReducer, GenderCodeListState} from "./gender-codes/gender-code-list.reducer";
import {countryCodeListReducer, CountryCodeListState} from "./country-codes/country-code-list.reducer";
import {maritalCodeListReducer, MaritalCodeListState} from "./marital-codes/marital-code-list.reducer";
import {raceCodeListReducer, RaceCodeListState} from "./race-codes/race-code-list.reducer";


export interface SetupModuleState {
genderCodes: GenderCodeListState;
countryCodes: CountryCodeListState;
maritalCodes: MaritalCodeListState;
raceCodes: RaceCodeListState;

};
export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    genderCodes: <GenderCode[]>[],
    countryCodes: <CountryCode[]>[],
    maritalCodes: <MaritalCode[]>[],
    raceCodes: <RaceCode[]>[],
  };
export const setupModuleReducers = { 

  genderCodes: genderCodeListReducer,
  countryCodes: countryCodeListReducer,
  maritalCodes: maritalCodeListReducer,
  racecodes: raceCodeListReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    CommonModule.forRoot(),
    EffectsModule.run(SetupEffects),
  
    
 
  ],
  declarations: [
    // page
    SetupPage,
    GenderCodeListPage,
    CountryCodeListPage,
    MaritalCodeListPage,
    RaceCodeListPage,
    //Dialog
    
  ],
  exports: [],

})
export class SetupModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SetupModule,
       providers: [
        appRoutingProviders,
            SetupActions
              ],
    };
  }
}