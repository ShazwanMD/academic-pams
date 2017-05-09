import { Action } from '@ngrx/store';
import { Injectable } from '@angular/core';

@Injectable()
export class CommonActions{

static FIND_GENDER_CODES = '[Common] Find Gender Codes';

  findGenderCodes(): Action {
    console.log("findGenderCodes");
    return {
      type: CommonActions.FIND_GENDER_CODES,
    };
  }

  static FIND_GENDER_CODES_SUCCESS = '[Common] Find Gender Codes Success';

  findGenderCodesSuccess(codes): Action {
    console.log("findGenderCodesSuccess");
    return {
      type: CommonActions.FIND_GENDER_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_COUNTRY_CODES = '[Common] Find CountryCodes';

findCountryCodes(): Action {
    console.log("findCountryCodes");
    return {
        type: CommonActions.FIND_COUNTRY_CODES
    };
}

static FIND_COUNTRY_CODES_SUCCESS = '[Common] Find CountryCodes Success';

findCountryCodesSuccess(codes): Action {
    console.log("findCountryCodesSuccess");
    return {
        type: CommonActions.FIND_COUNTRY_CODES_SUCCESS,
        payload: codes
    };
}



}