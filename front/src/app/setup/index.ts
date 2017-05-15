import { ReligionCodeEditorDialog } from './religion-codes/dialog/religion-code-editor.dialog';
import { MaritalCodeEditorDialog } from './marital-codes/dialog/marital-code-editor.dialog';
import { GradeCodeEditorDialog } from './grade-codes/dialog/grade-code-editor.dialog';
import { EthnicityCodeListPage } from './ethnicity-codes/ethnicity-code-list.page';
import { EthnicityCode } from './../common/ethnicity-codes/ethnicity-code.interface';
import { NationalityCodeListPage } from './nationality-codes/nationality-code-list.page';
import { NationalityCode } from './../common/nationality-codes/nationality-code.interface';
import { ReligionCodeListPage } from './religion-codes/religion-code-list.page';
import { ReligionCode } from './../common/religion-codes/religion-code.interface';
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
import {religionCodeListReducer, ReligionCodeListState} from "./religion-codes/religion-code-list.reducer";
import {nationalityCodeListReducer, NationalityCodeListState} from "./nationality-codes/nationality-code-list.reducer";
import {ethnicityCodeListReducer, EthnicityCodeListState} from "./ethnicity-codes/ethnicity-code-list.reducer";

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
  religionCodes: ReligionCodeListState;
  nationalityCodes: NationalityCodeListState;
  ethnicityCodes: EthnicityCodeListState;
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
    religionCodes: <ReligionCode[]>[],
    nationalityCodes: <NationalityCode[]>[],
    ethnicityCodes: <EthnicityCode[]>[],
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
  religionCodes: religionCodeListReducer,
  nationalityCodes: nationalityCodeListReducer,
  ethnicityCodes: ethnicityCodeListReducer,
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
    ReligionCodeListPage,
    NationalityCodeListPage,
    EthnicityCodeListPage,
    //Dialog
    GradeCodeEditorDialog,
    MaritalCodeEditorDialog,
    ReligionCodeEditorDialog,

  ],
  exports: [],
  entryComponents:[
    GradeCodeEditorDialog,
    MaritalCodeEditorDialog,
    ReligionCodeEditorDialog,
  ],

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
