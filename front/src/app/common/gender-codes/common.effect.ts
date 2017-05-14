import { CommonActions } from './common.action';
import { CommonService } from './../../../services/common.service';
import { Effect, Actions} from '@ngrx/effects';
import { Injectable } from '@angular/core';


@Injectable()
export class CommonEffects{

    constructor(private actions$:Actions,
                private commonActions:CommonActions,
                private commonService: CommonService){

                }
  @Effect() findGenderCodes$ = this.actions$
    .ofType(CommonActions.FIND_GENDER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGenderCodes())
    .map(codes => this.commonActions.findGenderCodesSuccess(codes));

@Effect() findCountryCodes$ = this.actions$
    .ofType(CommonActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.commonActions.findCountryCodesSuccess(codes));

@Effect() findStateCodes$ = this.actions$
    .ofType(CommonActions.FIND_STATE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findStateCodes())
    .map(codes => this.commonActions.findStateCodesSuccess(codes));

@Effect() findRaceCodes$ = this.actions$
    .ofType(CommonActions.FIND_RACE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findRaceCodes())
    .map(codes => this.commonActions.findRaceCodesSuccess(codes));


@Effect() findParliamentCodes$ = this.actions$
    .ofType(CommonActions.FIND_PARLIAMENT_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findParliamentCodes())
    .map(codes => this.commonActions.findParliamentCodesSuccess(codes));





}