import {Action} from '@ngrx/store';
import {Injectable} from '@angular/core';

@Injectable()
export class SetupActions {

//====================================================================================
// TITLE
//====================================================================================

  static CHANGE_TITLE = '[Setup] Change Title';

  changeTitle(title): Action {
    console.log("changeTitle");
    return {
      type: SetupActions.CHANGE_TITLE,
      payload: title
    };
  }

  static CHANGE_TITLE_SUCCESS = '[Setup] Change Title Success';

  changeTitleSuccess(title): Action {
    console.log("changeTitleSuccess");
    return {
      type: SetupActions.CHANGE_TITLE_SUCCESS,
      payload: title
    };
  }

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

//====================================================================================
// BANK CODES
//====================================================================================
  static FIND_BANK_CODES = '[Setup] Find BankCodes';

  findBankCodes(): Action {
    console.log("findBankCodes");
    return {
      type: SetupActions.FIND_BANK_CODES
    };
  }

  static FIND_BANK_CODES_SUCCESS = '[Setup] Find BankCodes Success';

  findBankCodesSuccess(codes): Action {
    console.log("findBankCodesSuccess");
    return {
      type: SetupActions.FIND_BANK_CODES_SUCCESS,
      payload: codes
    };
  }


//====================================================================================
// STATE CODES
//====================================================================================
  static FIND_STATE_CODES = '[Setup] Find StateCodes';

  findStateCodes(): Action {
    console.log("findStateCodes");
    return {
      type: SetupActions.FIND_STATE_CODES
    };
  }

  static FIND_STATE_CODES_SUCCESS = '[Setup] Find StateCodes Success';

  findStateCodesSuccess(codes): Action {
    console.log("findStateCodesSuccess");
    return {
      type: SetupActions.FIND_STATE_CODES_SUCCESS,
      payload: codes
    };
  }


  static FIND_PARLIAMENT_CODES = '[Setup] Find ParliamentCodes';

findParliamentCodes(): Action {
    console.log("findParliamentCodes");
    return {
        type: SetupActions.FIND_PARLIAMENT_CODES
    };
}

static FIND_PARLIAMENT_CODES_SUCCESS = '[Setup] Find ParliamentCodes Success';

findParliamentCodesSuccess(codes): Action {
    console.log("findParliamentCodesSuccess");
    return {
        type: SetupActions.FIND_PARLIAMENT_CODES_SUCCESS,
        payload: codes
    };
}


static FIND_DUN_CODES = '[Setup] Find DunCodes';

findDunCodes(): Action {
    console.log("findDunCodes");
    return {
        type: SetupActions.FIND_DUN_CODES
    };
}

static FIND_DUN_CODES_SUCCESS = '[Setup] Find DunCodes Success';

findDunCodesSuccess(codes): Action {
    console.log("findDunCodesSuccess");
    return {
        type: SetupActions.FIND_DUN_CODES_SUCCESS,
        payload: codes
    };
}

static FIND_GRADE_CODES = '[Setup] Find GradeCodes';

findGradeCodes(): Action {
    console.log("findGradeCodes");
    return {
        type: SetupActions.FIND_GRADE_CODES
    };
}

static FIND_GRADE_CODES_SUCCESS = '[Setup] Find GradeCodes Success';

findGradeCodesSuccess(codes): Action {
    console.log("findGradeCodesSuccess");
    return {
        type: SetupActions.FIND_GRADE_CODES_SUCCESS,
        payload: codes
    };
}


static FIND_RELIGION_CODES = '[Setup] Find ReligionCodes';

findReligionCodes(): Action {
    console.log("findReligionCodes");
    return {
        type: SetupActions.FIND_RELIGION_CODES
    };
}

static FIND_RELIGION_CODES_SUCCESS = '[Setup] Find ReligionCodes Success';

findReligionCodesSuccess(codes): Action {
    console.log("findReligionCodesSuccess");
    return {
        type: SetupActions.FIND_RELIGION_CODES_SUCCESS,
        payload: codes
    };
}


static FIND_NATIONALITY_CODES = '[Setup] Find NationalityCodes';

findNationalityCodes(): Action {
    console.log("findNationalityCodes");
    return {
        type: SetupActions.FIND_NATIONALITY_CODES
    };
}

static FIND_NATIONALITY_CODES_SUCCESS = '[Setup] Find NationalityCodes Success';

findNationalityCodesSuccess(codes): Action {
    console.log("findNationalityCodesSuccess");
    return {
        type: SetupActions.FIND_NATIONALITY_CODES_SUCCESS,
        payload: codes
    };
}

static FIND_ETHNICITY_CODES = '[Setup] Find EthnicityCodes';

findEthnicityCodes(): Action {
    console.log("findEthnicityCodes");
    return {
        type: SetupActions.FIND_ETHNICITY_CODES
    };
}

static FIND_ETHNICITY_CODES_SUCCESS = '[Setup] Find EthnicityCodes Success';

findEthnicityCodesSuccess(codes): Action {
    console.log("findEthnicityCodesSuccess");
    return {
        type: SetupActions.FIND_ETHNICITY_CODES_SUCCESS,
        payload: codes
    };
}












}
