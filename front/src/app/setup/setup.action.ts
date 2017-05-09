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

static FIND_COUNTRY_CODES = '[Setup] Find CountryCodes';

findCountryCodes(): Action {
    console.log("findCountryCodes");
    return {
        type: SetupActions.FIND_COUNTRY_CODES
    };
}

static FIND_COUNTRY_CODES_SUCCESS = '[Setup] Find CountryCodes Success';

findCountryCodesSuccess(codes): Action {
    console.log("findCountryCodesSuccess");
    return {
        type: SetupActions.FIND_COUNTRY_CODES_SUCCESS,
        payload: codes
    };
}




}