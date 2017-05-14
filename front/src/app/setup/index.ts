import { GradeCodeListPage } from './grade-codes/grade-code-list.page';
import { GradeCode } from './../common/grade-codes/grade-code.interface';
import { DunCodeListPage } from './dun-codes/dun-code-list.page';
import { DunCode } from './../common/dun-codes/dun-code.interface';
import { ParliamentCodeListPage } from './parliament-codes/parliament-code-list.page';
import { ParliamentCode } from './../common/parliament-codes/parliament-code.interface';
import {MaritalCodeListPage} from './marital-codes/marital-code-list.page';
import {MaritalCode} from './marital-codes/marital-code.interface';
import {CountryCode} from './../common/country-codes/country-code.interface';
import {CountryCodeListPage} from './country-codes/country-code-list.page';
import {EffectsModule} from '@ngrx/effects';
import {GenderCodeListPage} from './gender-codes/gender-code-list.page';
import {GenderCode} from './../common/gender-codes/gender-code.interface';
import {SetupActions} from './setup.action';
import {SetupEffects} from './setup.effect';
import {CommonModule} from './../common/index';
import {NgModule, ModuleWithProviders} from "@angular/core";
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {SetupPage} from "./setup.page";
import {genderCodeListReducer, GenderCodeListState} from "./gender-codes/gender-code-list.reducer";
import {countryCodeListReducer, CountryCodeListState} from "./country-codes/country-code-list.reducer";
import {maritalCodeListReducer, MaritalCodeListState} from "./marital-codes/marital-code-list.reducer";
import {RaceCode} from './../common/race-codes/race-code.interface';
import {RaceCodeListPage} from './race-codes/race-code-list.page';
import {raceCodeListReducer, RaceCodeListState} from "./race-codes/race-code-list.reducer";
import {titleReducer, TitleState} from "./title.reducer";
import {BankCodeListPage} from "./bank-codes/bank-code-list.page";

import { StateCode } from './../common/state-codes/state-code.interface';
import { StateCodeListPage } from './state-codes/state-code-list.page';
import {stateCodeListReducer, StateCodeListState} from "./state-codes/state-code-list.reducer";

import {parliamentCodeListReducer, ParliamentCodeListState} from "./parliament-codes/parliament-code-list.reducer";
import {dunCodeListReducer, DunCodeListState} from "./dun-codes/dun-code-list.reducer";
import {gradeCodeListReducer, GradeCodeListState} from "./grade-codes/grade-code-list.reducer";

export interface SetupModuleState {
  title:TitleState;
  genderCodes: GenderCodeListState;
  countryCodes: CountryCodeListState;
  maritalCodes: MaritalCodeListState;
  raceCodes: RaceCodeListState;
  stateCodes: StateCodeListState;
  parliamentCodes: ParliamentCodeListState;
  dunCodes: DunCodeListState;
  gradeCodes: GradeCodeListState;
}
;
export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    title:'Setup Codes',
    genderCodes: <GenderCode[]>[],
    countryCodes: <CountryCode[]>[],
    maritalCodes: <MaritalCode[]>[],
    raceCodes: <RaceCode[]>[],
    stateCodes: <StateCode[]>[],
    parliamentCodes: <ParliamentCode[]>[],
    dunCodes: <DunCode[]>[],
    gradeCodes: <GradeCode[]>[],
  };
export const setupModuleReducers = {
  title:titleReducer,
  genderCodes: genderCodeListReducer,
  countryCodes: countryCodeListReducer,
  maritalCodes: maritalCodeListReducer,
  raceCodes: raceCodeListReducer,
  stateCodes: stateCodeListReducer,
  parliamentCodes: parliamentCodeListReducer,
  dunCodes: dunCodeListReducer,
  gradeCodes: gradeCodeListReducer,
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
    BankCodeListPage,
    StateCodeListPage,
    ParliamentCodeListPage,
    DunCodeListPage,
    GradeCodeListPage,
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
