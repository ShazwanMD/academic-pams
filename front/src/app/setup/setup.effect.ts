import {SetupActions} from './setup.action';
import {Effect, Actions} from '@ngrx/effects';
import {Injectable} from '@angular/core';
import {from} from "rxjs/observable/from";
import {CommonService} from "../../services/common.service";

@Injectable()
export class SetupEffects {

  constructor(private actions$: Actions,
              private setupActions: SetupActions,
              private commonService: CommonService) {

  }

  @Effect() changeTitle$ = this.actions$
    .ofType(SetupActions.CHANGE_TITLE)
    .map(action => action.payload)
    .map(payload => this.setupActions.changeTitleSuccess(payload));


  //=================================================================================
  // GENDER CODE
  //=================================================================================
  @Effect() findGenderCodes$ = this.actions$
    .ofType(SetupActions.FIND_GENDER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGenderCodes())
    .map(codes => this.setupActions.findGenderCodesSuccess(codes));

  //=================================================================================
  //                  Country Code
  //=================================================================================
  @Effect() findCountryCodes$ = this.actions$
    .ofType(SetupActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.setupActions.findCountryCodesSuccess(codes));

  //=================================================================================
  // MARITAL CODE
  //=================================================================================
  @Effect() findMaritalCodes$ = this.actions$
    .ofType(SetupActions.FIND_MARITAL_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findMaritalCodes())
    .map(codes => this.setupActions.findMaritalCodesSuccess(codes));

    @Effect() saveMaritalCodes$ = this.actions$
    .ofType(SetupActions.SAVE_MARITAL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveMaritalCode(payload))
    .map(message => this.setupActions.saveMaritalCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findMaritalCodes()]));

  @Effect() updateMaritalCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_MARITAL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateMaritalCode(payload))
    .map(message => this.setupActions.updateMaritalCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findMaritalCodes()]));

  @Effect() removeMaritalCode$ = this.actions$
    .ofType(SetupActions.REMOVE_MARITAL_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeMaritalCode(payload))
    .map(message => this.setupActions.removeMaritalCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findMaritalCodes()]));


  //=================================================================================
  // RACE CODE
  //=================================================================================
  @Effect() findRaceCodes$ = this.actions$
    .ofType(SetupActions.FIND_RACE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findRaceCodes())
    .map(codes => this.setupActions.findRaceCodesSuccess(codes));

  //=================================================================================
  // BANK CODE
  //=================================================================================
  @Effect() findBankCodes$ = this.actions$
    .ofType(SetupActions.FIND_BANK_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findBankCodes())
    .map(codes => this.setupActions.findBankCodesSuccess(codes));

  //=================================================================================
  // STATE CODE
  //=================================================================================
  @Effect() findStateCodes$ = this.actions$
    .ofType(SetupActions.FIND_STATE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStateCodes())
    .map(codes => this.setupActions.findStateCodesSuccess(codes));

 //=================================================================================
  // PARLIAMENT CODE
  //=================================================================================
@Effect() findParliamentCodes$ = this.actions$
    .ofType(SetupActions.FIND_PARLIAMENT_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findParliamentCodes())
    .map(codes => this.setupActions.findParliamentCodesSuccess(codes));
 //=================================================================================
  // DUN CODE
  //=================================================================================
@Effect() findDunCodes$ = this.actions$
    .ofType(SetupActions.FIND_DUN_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findDunCodes())
    .map(codes => this.setupActions.findDunCodesSuccess(codes));

//=======================================================================================
//  Grade Code
//=======================================================================================
@Effect() findGradeCodes$ = this.actions$
    .ofType(SetupActions.FIND_GRADE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGradeCodes())
    .map(codes => this.setupActions.findGradeCodesSuccess(codes));

  @Effect() saveGradeCodes$ = this.actions$
    .ofType(SetupActions.SAVE_GRADE_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.saveGradeCode(payload))
    .map(message => this.setupActions.saveGradeCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findGradeCodes()]));

  @Effect() updateGradeCodes$ = this.actions$
    .ofType(SetupActions.UPDATE_GRADE_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.updateGradeCode(payload))
    .map(message => this.setupActions.updateGradeCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findGradeCodes()]));

  @Effect() removeGradeCode$ = this.actions$
    .ofType(SetupActions.REMOVE_GRADE_CODE)
    .map(action => action.payload)
    .switchMap(payload => this.commonService.removeGradeCode(payload))
    .map(message => this.setupActions.removeGradeCodeSuccess(message))
    .mergeMap(action => from([action, this.setupActions.findGradeCodes()]));
//=======================================================================================
//  Religion Code
//=======================================================================================

@Effect() findReligionCodes$ = this.actions$
    .ofType(SetupActions.FIND_RELIGION_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findReligionCodes())
    .map(codes => this.setupActions.findReligionCodesSuccess(codes));

@Effect() findNationalityCodes$ = this.actions$
    .ofType(SetupActions.FIND_NATIONALITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findNationalityCodes())
    .map(codes => this.setupActions.findNationalityCodesSuccess(codes));


@Effect() findEthnicityCodes$ = this.actions$
    .ofType(SetupActions.FIND_ETHNICITY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findEthnicityCodes())
    .map(codes => this.setupActions.findEthnicityCodesSuccess(codes));




 
}
