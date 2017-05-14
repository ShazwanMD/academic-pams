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
  // STATE CODE
  //=================================================================================
@Effect() findParliamentCodes$ = this.actions$
    .ofType(SetupActions.FIND_PARLIAMENT_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findParliamentCodes())
    .map(codes => this.setupActions.findParliamentCodesSuccess(codes));


 
}
