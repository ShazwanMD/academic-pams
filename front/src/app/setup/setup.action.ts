import { Action } from '@ngrx/store';
import { Injectable } from '@angular/core';

@Injectable()
export class SetupActions{

static FIND_GENDER_CODES = '[Setup] Find Gender Codes';

findGenderCodes(): Action {
    console.log("findGenderCodes");
    return {
        type: SetupActions.FIND_GENDER_CODES
    };
}

static FIND_GENDER_CODES_SUCCESS = '[Setup] Find Gender Codes Success';

findGenderCodesSuccess(codes): Action {
    console.log("findGenderCodesSuccess");
    return {
        type: SetupActions.FIND_GENDER_CODES_SUCCESS,
        payload: codes
    };
}


}