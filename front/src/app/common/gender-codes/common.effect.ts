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


}