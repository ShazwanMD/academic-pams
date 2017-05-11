import {Action} from '@ngrx/store';
import {Injectable} from '@angular/core';

@Injectable()
export class SetupActions {

//====================================================================================
// GENDER CODES
//====================================================================================

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

//====================================================================================
// COUNTRY CODES
//====================================================================================

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

//====================================================================================
// MARITAL CODES
//====================================================================================

  static FIND_MARITAL_CODES = '[Setup] Find MaritalCodes';

  findMaritalCodes(): Action {
    console.log("findMaritalCodes");
    return {
      type: SetupActions.FIND_MARITAL_CODES
    };
  }

  static FIND_MARITAL_CODES_SUCCESS = '[Setup] Find MaritalCodes Success';

  findMaritalCodesSuccess(codes): Action {
    console.log("findMaritalCodesSuccess");
    return {
      type: SetupActions.FIND_MARITAL_CODES_SUCCESS,
      payload: codes
    };
  }

//====================================================================================
// RACE CODES
//====================================================================================
  static FIND_RACE_CODES = '[Setup] Find RaceCodes';

  findRaceCodes(): Action {
    console.log("findRaceCodes");
    return {
      type: SetupActions.FIND_RACE_CODES
    };
  }

  static FIND_RACE_CODES_SUCCESS = '[Setup] Find RaceCodes Success';

  findRaceCodesSuccess(codes): Action {
    console.log("findRaceCodesSuccess");
    return {
      type: SetupActions.FIND_RACE_CODES_SUCCESS,
      payload: codes
    };
  }
}
