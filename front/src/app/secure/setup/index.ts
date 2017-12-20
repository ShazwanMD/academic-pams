import { BankCodeSelectComponent } from './bank-codes/component/bank-code-select.component';
import { BankCodeEditorDialog } from './bank-codes/dialog/bank-code-editor.dialog';
import { BankCode } from './../../shared/model/common/bank-code.interface';
import { BankCodeListState, bankCodeListReducer } from './bank-codes/bank-code-list.reducer';
import {StudyCentreSelectComponent} from './study-centers/component/study-center-select.component';
import {StudyCenterEditorDialog} from './study-centers/dialog/study-center-editor.dialog';
import {StudyCenterListPage} from './study-centers/study-center-list.page';
import {StudyCenter} from './study-centers/study-center.interface';
import {StudyModeEditorDialog} from './study-modes/dialog/study-mode-editor.dialog';
import {StudyModeListPage} from './study-modes/study-mode-list.page';
import {StudyMode} from '../../shared/model/common/study-mode.interface';
import {StateCodeEditorDialog} from './state-codes/dialog/state-code-editor.dialog';
import {GenderCodeEditorDialog} from './gender-codes/dialog/gender-code-editor.dialog';
import {NationalityCodeEditorDialog} from './nationality-codes/dialog/nationality-code-editor.dialog';
import {ReligionCodeEditorDialog} from './religion-codes/dialog/religion-code-editor.dialog';
import {MaritalCodeEditorDialog} from './marital-codes/dialog/marital-code-editor.dialog';
import {GradeCodeEditorDialog} from './grade-codes/dialog/grade-code-editor.dialog';
import {EthnicityCodeListPage} from './ethnicity-codes/ethnicity-code-list.page';
import {EthnicityCode} from '../../shared/model/common/ethnicity-code.interface';
import {NationalityCodeListPage} from './nationality-codes/nationality-code-list.page';
import {NationalityCode} from '../../shared/model/common/nationality-code.interface';
import {ReligionCodeListPage} from './religion-codes/religion-code-list.page';
import {ReligionCode} from '../../shared/model/common/religion-code.interface';
import {GradeCodeListPage} from './grade-codes/grade-code-list.page';
import {GradeCode} from '../../shared/model/common/grade-code.interface';
import {DunCodeListPage} from './dun-codes/dun-code-list.page';
import {DunCode} from '../../shared/model/common/dun-code.interface';
import {ParliamentCodeListPage} from './parliament-codes/parliament-code-list.page';
import {ParliamentCode} from '../../shared/model/common/parliament-code.interface';
import {MaritalCodeListPage} from './marital-codes/marital-code-list.page';
import {MaritalCode} from './marital-codes/marital-code.interface';
import {CountryCode} from '../../shared/model/common/country-code.interface';
import {CountryCodeListPage} from './country-codes/country-code-list.page';
import {EffectsModule} from '@ngrx/effects';
import {GenderCodeListPage} from './gender-codes/gender-code-list.page';
import {GenderCode} from '../../shared/model/common/gender-code.interface';
import {SetupActions} from './setup.action';
import {SetupEffects} from './setup.effect';
import {CommonModule} from '../../common/index';
import {ModuleWithProviders, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {SetupPage} from './setup.page';
import {genderCodeListReducer, GenderCodeListState} from './gender-codes/gender-code-list.reducer';
import {countryCodeListReducer, CountryCodeListState} from './country-codes/country-code-list.reducer';
import {maritalCodeListReducer, MaritalCodeListState} from './marital-codes/marital-code-list.reducer';
import {RaceCode} from '../../shared/model/common/race-code.interface';
import {RaceCodeListPage} from './race-codes/race-code-list.page';
import {raceCodeListReducer, RaceCodeListState} from './race-codes/race-code-list.reducer';
import {titleReducer, TitleState} from './title.reducer';
import {BankCodeListPage} from './bank-codes/bank-code-list.page';

import {StateCode} from '../../shared/model/common/state-code.interface';
import {StateCodeListPage} from './state-codes/state-code-list.page';
import {stateCodeListReducer, StateCodeListState} from './state-codes/state-code-list.reducer';

import {parliamentCodeListReducer, ParliamentCodeListState} from './parliament-codes/parliament-code-list.reducer';
import {dunCodeListReducer, DunCodeListState} from './dun-codes/dun-code-list.reducer';
import {gradeCodeListReducer, GradeCodeListState} from './grade-codes/grade-code-list.reducer';
import {religionCodeListReducer, ReligionCodeListState} from './religion-codes/religion-code-list.reducer';
import {nationalityCodeListReducer, NationalityCodeListState} from './nationality-codes/nationality-code-list.reducer';
import {ethnicityCodeListReducer, EthnicityCodeListState} from './ethnicity-codes/ethnicity-code-list.reducer';
import {studyModeListReducer, StudyModeListState} from './study-modes/study-mode-list.reducer';
import {studyCenterListReducer, StudyCenterListState} from './study-centers/study-center-list.reducer';

export interface SetupModuleState {
  title: TitleState;
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
  studyModes: StudyModeListState;
  studyCenters: StudyCenterListState;
  bankCodes: BankCodeListState;
}
;
export const INITIAL_SETUP_STATE: SetupModuleState =
  <SetupModuleState>{
    title: 'Setup Codes',
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
    studyModes: <StudyMode[]>[],
    studyCenters: <StudyCenter[]>[],
    bankCodes: <BankCode[]>[],
  };
export const setupModuleReducers = {
  title: titleReducer,
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
  studyModes: studyModeListReducer,
  studyCenters: studyCenterListReducer,
  bankCodes: bankCodeListReducer,
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
    StudyModeListPage,
    StudyCenterListPage,

    //Dialog
    GradeCodeEditorDialog,
    MaritalCodeEditorDialog,
    ReligionCodeEditorDialog,
    NationalityCodeEditorDialog,
    GenderCodeEditorDialog,
    StateCodeEditorDialog,
    StudyModeEditorDialog,
    StudyCenterEditorDialog,
    BankCodeEditorDialog,

    //Component
    StudyCentreSelectComponent,
    BankCodeSelectComponent,
  ],

  exports: [
    StudyCentreSelectComponent,
    BankCodeSelectComponent,
   
  ],

  entryComponents: [
    GradeCodeEditorDialog,
    MaritalCodeEditorDialog,
    ReligionCodeEditorDialog,
    NationalityCodeEditorDialog,
    GenderCodeEditorDialog,
    StudyModeEditorDialog,
    StateCodeEditorDialog,
    StudyCenterEditorDialog,
    BankCodeEditorDialog,
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
