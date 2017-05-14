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


  static FIND_STATE_CODES = '[Common] Find StateCodes';

findStateCodes(): Action {
    console.log("findStateCodes");
    return {
        type: CommonActions.FIND_STATE_CODES
    };
}

static FIND_STATE_CODES_SUCCESS = '[Common] Find StateCodes Success';

findStateCodesSuccess(codes): Action {
    console.log("findStateCodesSuccess");
    return {
        type: CommonActions.FIND_STATE_CODES_SUCCESS,
        payload: codes
    };
}




  static FIND_RACE_CODES = '[Common] Find RaceCodes';

findRaceCodes(): Action {
    console.log("findRaceCodes");
    return {
        type: CommonActions.FIND_RACE_CODES
    };
}

static FIND_RACE_CODES_SUCCESS = '[Common] Find RaceCodes Success';

findRaceCodesSuccess(codes): Action {
    console.log("findRaceCodesSuccess");
    return {
        type: CommonActions.FIND_RACE_CODES_SUCCESS,
        payload: codes
    };
}

static FIND_PARLIAMENT_CODES = '[Common] Find ParliamentCodes';

findParliamentCodes(): Action {
    console.log("findParliamentCodes");
    return {
        type: CommonActions.FIND_PARLIAMENT_CODES
    };
}

static FIND_PARLIAMENT_CODES_SUCCESS = '[Common] Find ParliamentCodes Success';

findParliamentCodesSuccess(codes): Action {
    console.log("findParliamentCodesSuccess");
    return {
        type: CommonActions.FIND_PARLIAMENT_CODES_SUCCESS,
        payload: codes
    };
}







}