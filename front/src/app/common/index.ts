import {StudyModeSelectComponent} from './study-modes/component/study-mode-select.component';
import {RaceCodeSelectComponent} from './race-codes/component/race-code-select.component';
import {StateCodeSelectComponent} from './state-codes/component/state-code-select.component';
import {CountryCodeSelectComponent} from './country-codes/component/country-code-select.component';
import {CommonActions} from './gender-codes/common.action';
import {GenderCodeSelectComponent} from './gender-codes/component/gender-code-select.component';
import {CommonEffects} from './gender-codes/common.effect';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../services';
import {IdentityService} from '../../services';
import {EffectsModule} from "@ngrx/effects";
import {studyModeListReducer, StudyModeListState} from "./study-modes/study-mode-list.reducer";
import {StateCodeListState, stateCodeListReducer} from "./state-codes/state-code-list.reducer";
import {CountryCodeListState, countryCodeListReducer} from "./country-codes/country-code-list.reducer";

export interface CommonModuleState {
  studyModes: StudyModeListState,
  stateCodes: StateCodeListState,
  countryCodes: CountryCodeListState,
}
;

export const INITIAL_COMMON_STATE: CommonModuleState =
  <CommonModuleState>{
    studyModes: [],
    stateCodes: [],
    countryCodes: [],
  };
export const commonModuleReducers = {
  studyModes: studyModeListReducer,
  stateCodes: stateCodeListReducer,
  countryCodes: countryCodeListReducer,
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
