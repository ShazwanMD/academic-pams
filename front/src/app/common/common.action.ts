import {Action} from '@ngrx/store';
import {Injectable} from '@angular/core';

@Injectable()
export class CommonActions {
  static FIND_STUDY_MODES = '[Common] Find Study Modes';

  findStudyModes(): Action {
    console.log("findStudyModes");
    return {
      type: CommonActions.FIND_STUDY_MODES
    };
  }

  static FIND_STUDY_MODES_SUCCESS = '[Common] Find Study Modes Success';

  findStudyModesSuccess(codes): Action {
    console.log("findStudyModesSuccess");
    return {
      type: CommonActions.FIND_STUDY_MODES_SUCCESS,
      payload: codes
    };
  }

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

  static FIND_DUN_CODES = '[Common] Find DunCodes';

  findDunCodes(): Action {
    console.log("findDunCodes");
    return {
      type: CommonActions.FIND_DUN_CODES
    };
  }

  static FIND_DUN_CODES_SUCCESS = '[Common] Find DunCodes Success';

  findDunCodesSuccess(codes): Action {
    console.log("findDunCodesSuccess");
    return {
      type: CommonActions.FIND_DUN_CODES_SUCCESS,
      payload: codes
    };
  }


  static FIND_GRADE_CODES = '[Common] Find GradeCodes';

  findGradeCodes(): Action {
    console.log("findGradeCodes");
    return {
      type: CommonActions.FIND_GRADE_CODES
    };
  }

  static FIND_GRADE_CODES_SUCCESS = '[Common] Find GradeCodes Success';

  findGradeCodesSuccess(codes): Action {
    console.log("findGradeCodesSuccess");
    return {
      type: CommonActions.FIND_GRADE_CODES_SUCCESS,
      payload: codes
    };
  }


  static FIND_RELIGION_CODES = '[Common] Find ReligionCodes';

  findReligionCodes(): Action {
    console.log("findReligionCodes");
    return {
      type: CommonActions.FIND_RELIGION_CODES
    };
  }

  static FIND_RELIGION_CODES_SUCCESS = '[Common] Find ReligionCodes Success';

  findReligionCodesSuccess(codes): Action {
    console.log("findReligionCodesSuccess");
    return {
      type: CommonActions.FIND_RELIGION_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_NATIONALITY_CODES = '[Common] Find NationalityCodes';

  findNationalityCodes(): Action {
    console.log("findNationalityCodes");
    return {
      type: CommonActions.FIND_NATIONALITY_CODES
    };
  }

  static FIND_NATIONALITY_CODES_SUCCESS = '[Common] Find NationalityCodes Success';

  findNationalityCodesSuccess(codes): Action {
    console.log("findNationalityCodesSuccess");
    return {
      type: CommonActions.FIND_NATIONALITY_CODES_SUCCESS,
      payload: codes
    };
  }

  static FIND_ETHNICITY_CODES = '[Common] Find EthnicityCodes';

  findEthnicityCodes(): Action {
    console.log("findEthnicityCodes");
    return {
      type: CommonActions.FIND_ETHNICITY_CODES
    };
  }

  static FIND_ETHNICITY_CODES_SUCCESS = '[Common] Find EthnicityCodes Success';

  findEthnicityCodesSuccess(codes): Action {
    console.log("findEthnicityCodesSuccess");
    return {
      type: CommonActions.FIND_ETHNICITY_CODES_SUCCESS,
      payload: codes
    };
  }


}
