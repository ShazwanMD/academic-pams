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

                
@Effect() findGenderCodes$ = this.actions$
    .ofType(SetupActions.FIND_GENDER_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findGenderCodes())
    .map(codes => this.commonActions.findGenderCodesSuccess(codes));


@Effect() findCountryCodes$ = this.actions$
    .ofType(SetupActions.FIND_COUNTRY_CODES)
    .map(action => action.payload)
    .switchMap(() => this.commonService.findCountryCodes())
    .map(codes => this.commonActions.findCountryCodesSuccess(codes));


}