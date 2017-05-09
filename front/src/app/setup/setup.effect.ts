import { CommonService } from './../../services/common.service';
import { SetupActions } from './setup.action';
import { Effect , Actions} from '@ngrx/effects';
import { Injectable } from '@angular/core';
import {from} from "rxjs/observable/from";

@Injectable()
export class SetupEffects{

    constructor(private actions$: Actions,
                private commonActions: SetupActions,
                private commonService: CommonService){

                }

//=================================================================================
//                  Gender Code
//=================================================================================                
    @Effect() findGenderCodes$ = this.actions$
    .ofType(SetupActions.FIND_GENDER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGenderCodes())
    .map(codes => this.commonActions.findGenderCodesSuccess(codes));

//=================================================================================
//                  Country Code
//=================================================================================
    @Effect() findCountryCodes$ = this.actions$
    .ofType(SetupActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.commonActions.findCountryCodesSuccess(codes));

//=================================================================================
//                  Marital Code
//=================================================================================
    @Effect() findMaritalCodes$ = this.actions$
    .ofType(SetupActions.FIND_MARITAL_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findMaritalCodes())
    .map(codes => this.commonActions.findMaritalCodesSuccess(codes));
    
//=================================================================================
//                  Race Code
//=================================================================================
    @Effect() findRaceCodes$ = this.actions$
    .ofType(SetupActions.FIND_RACE_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findRaceCodes())
    .map(codes => this.commonActions.findRaceCodesSuccess(codes));




}