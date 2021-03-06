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

  static FIND_STUDY_CENTERS = '[Setup] Find Study Centers';

  findStudyCenters(): Action {
    console.log("findStudyCenters");
    return {
      type: SetupActions.FIND_STUDY_CENTERS
    };
  }

  static FIND_STUDY_CENTERS_SUCCESS = '[Setup] Find Study Centers Success';

  findStudyCentersSuccess(codes): Action {
    console.log(codes);
    return {
      type: SetupActions.FIND_STUDY_CENTERS_SUCCESS,
      payload: codes
    };
  }

  static SAVE_STUDY_CENTER = '[Setup] Save Study Center';

  saveStudyCenter(code): Action {
    console.log("saveStudyCenter");
    return {
      type: SetupActions.SAVE_STUDY_CENTER,
      payload: code
    };
  }

  static SAVE_STUDY_CENTER_SUCCESS = '[Setup] Save Study Center Success';

  saveStudyCenterSuccess(message): Action {
    console.log("saveStudyCenterSuccess");
    return {
      type: SetupActions.SAVE_STUDY_CENTER_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STUDY_CENTER = '[Setup] Update Study Center';

  updateStudyCenter(code): Action {
    console.log("updateStudyCenter");
    return {
      type: SetupActions.UPDATE_STUDY_CENTER,
      payload: code
    };
  }

  static UPDATE_STUDY_CENTER_SUCCESS = '[Setup] Update Study Center  Success';

  updateStudyCenterSuccess(message): Action {
    console.log("updateStudyCenterSuccess");
    return {
      type: SetupActions.UPDATE_STUDY_CENTER_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STUDY_CENTER = '[Setup] Remove Study Center';

  removeStudyCenter(code): Action {
    console.log("removeStudyCenter");
    return {
      type: SetupActions.REMOVE_STUDY_CENTER,
      payload: code
    };
  }

  static REMOVE_STUDY_CENTER_SUCCESS = '[Setup] Remove Study Center  Success';

  removeStudyCenterSuccess(message): Action {
    console.log("removeStudyCenterSuccess");
    return {
      type: SetupActions.REMOVE_STUDY_CENTER_SUCCESS,
      payload: message
    };
  }


  static FIND_STUDY_MODES = '[Setup] Find Study Modes';

  findStudyModes(): Action {
    console.log("findStudyModes");
    return {
      type: SetupActions.FIND_STUDY_MODES
    };
  }

  static FIND_STUDY_MODES_SUCCESS = '[Setup] Find Study Modes Success';

  findStudyModesSuccess(codes): Action {
    console.log("findStudyModesSuccess");
    return {
      type: SetupActions.FIND_STUDY_MODES_SUCCESS,
      payload: codes
    };
  }

  static SAVE_STUDY_MODE = '[Setup] Save Study Mode';

  saveStudyMode(code): Action {
    console.log("saveStudyMode");
    return {
      type: SetupActions.SAVE_STUDY_MODE,
      payload: code
    };
  }

  static SAVE_STUDY_MODE_SUCCESS = '[Setup] Save Study Mode Success';

  saveStudyModeSuccess(message): Action {
    console.log("saveStudyModeSuccess");
    return {
      type: SetupActions.SAVE_STUDY_MODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STUDY_MODE = '[Setup] Update Study Mode';

  updateStudyMode(code): Action {
    console.log("updateStudyMode");
    return {
      type: SetupActions.UPDATE_STUDY_MODE,
      payload: code
    };
  }

  static UPDATE_STUDY_MODE_SUCCESS = '[Setup] Update Study Mode  Success';

  updateStudyModeSuccess(message): Action {
    console.log("updateStudyModeSuccess");
    return {
      type: SetupActions.UPDATE_STUDY_MODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STUDY_MODE = '[Setup] Remove Study Mode';

  removeStudyMode(code): Action {
    console.log("removeStudyMode");
    return {
      type: SetupActions.REMOVE_STUDY_MODE,
      payload: code
    };
  }

  static REMOVE_STUDY_MODE_SUCCESS = '[Setup] Remove Study Mode  Success';

  removeStudyModeSuccess(message): Action {
    console.log("removeStudyModeSuccess");
    return {
      type: SetupActions.REMOVE_STUDY_MODE_SUCCESS,
      payload: message
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

  static SAVE_GENDER_CODE = '[Setup] Save Gender Code';

  saveGenderCode(code): Action {
    console.log("saveGenderCode");
    return {
      type: SetupActions.SAVE_GENDER_CODE,
      payload: code
    };
  }

  static SAVE_GENDER_CODE_SUCCESS = '[Setup] Save Gender Code Success';

  saveGenderCodeSuccess(message): Action {
    console.log("saveGenderCodeSuccess");
    return {
      type: SetupActions.SAVE_GENDER_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_GENDER_CODE = '[Setup] Update Gender Code';

  updateGenderCode(code): Action {
    console.log("updateGenderCode");
    return {
      type: SetupActions.UPDATE_GENDER_CODE,
      payload: code
    };
  }

  static UPDATE_GENDER_CODE_SUCCESS = '[Setup] Update Gender Code  Success';

  updateGenderCodeSuccess(message): Action {
    console.log("updateGenderCodeSuccess");
    return {
      type: SetupActions.UPDATE_GENDER_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_GENDER_CODE = '[Setup] Remove Gender Code';

  removeGenderCode(code): Action {
    console.log("removeGenderCode");
    return {
      type: SetupActions.REMOVE_GENDER_CODE,
      payload: code
    };
  }

  static REMOVE_GENDER_CODE_SUCCESS = '[Setup] Remove Gender Code  Success';

  removeGenderCodeSuccess(message): Action {
    console.log("removeGenderCodeSuccess");
    return {
      type: SetupActions.REMOVE_GENDER_CODE_SUCCESS,
      payload: message
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

  static SAVE_MARITAL_CODE = '[Setup] Save Marital Code';

  saveMaritalCode(code): Action {
    console.log("saveMaritalCode");
    return {
      type: SetupActions.SAVE_MARITAL_CODE,
      payload: code
    };
  }

  static SAVE_MARITAL_CODE_SUCCESS = '[Setup] Save Marital Code Success';

  saveMaritalCodeSuccess(message): Action {
    console.log("saveMaritalCodeSuccess");
    return {
      type: SetupActions.SAVE_MARITAL_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_MARITAL_CODE = '[Setup] Update Marital Code';

  updateMaritalCode(code): Action {
    console.log("updateMaritalCode");
    return {
      type: SetupActions.UPDATE_MARITAL_CODE,
      payload: code
    };
  }

  static UPDATE_MARITAL_CODE_SUCCESS = '[Setup] Update Marital Code  Success';

  updateMaritalCodeSuccess(message): Action {
    console.log("updateMaritalCodeSuccess");
    return {
      type: SetupActions.UPDATE_MARITAL_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_MARITAL_CODE = '[Setup] Remove Marital Code';

  removeMaritalCode(code): Action {
    console.log("removeMaritalCode");
    return {
      type: SetupActions.REMOVE_MARITAL_CODE,
      payload: code
    };
  }

  static REMOVE_MARITAL_CODE_SUCCESS = '[Setup] Remove Marital Code  Success';

  removeMaritalCodeSuccess(message): Action {
    console.log("removeMaritalCodeSuccess");
    return {
      type: SetupActions.REMOVE_MARITAL_CODE_SUCCESS,
      payload: message
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

  static SAVE_BANK_CODE = '[Setup] Save Bank Code';
  
    saveBankCode(bankCode): Action {
      console.log("saveBankCode");
      return {
        type: SetupActions.SAVE_BANK_CODE,
        payload: bankCode
      };
    }
  
    static SAVE_BANK_CODE_SUCCESS = '[Setup] Save Bank Code Success';
  
    saveBankCodeSuccess(message): Action {
      console.log("saveBankCodeSuccess");
      return {
        type: SetupActions.SAVE_BANK_CODE_SUCCESS,
        payload: message
      };
    }
  
    static UPDATE_BANK_CODE = '[Setup] Update Bank Code';
  
    updateBankCode(bankCode): Action {
      console.log("updateBankCode");
      return {
        type: SetupActions.UPDATE_BANK_CODE,
        payload: bankCode
      };
    }
  
    static UPDATE_BANK_CODE_SUCCESS = '[Setup] Update Bank Code  Success';
  
    updateBankCodeSuccess(message): Action {
      console.log("updateBankCodeSuccess");
      return {
        type: SetupActions.UPDATE_BANK_CODE_SUCCESS,
        payload: message
      };
    }
  
    static REMOVE_BANK_CODE = '[Setup] Remove Bank Code';
  
    removeBankCode(bankCode): Action {
      console.log("removeBankCode");
      return {
        type: SetupActions.REMOVE_BANK_CODE,
        payload: bankCode
      };
    }
  
    static REMOVE_BANK_CODE_SUCCESS = '[Setup] Remove Bank Code  Success';
  
    removeBankCodeSuccess(message): Action {
      console.log("removeBankCodeSuccess");
      return {
        type: SetupActions.REMOVE_BANK_CODE_SUCCESS,
        payload: message
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

  static SAVE_STATE_CODE = '[Setup] Save State Code';

  saveStateCode(code): Action {
    console.log("saveStateCode");
    return {
      type: SetupActions.SAVE_STATE_CODE,
      payload: code
    };
  }

  static SAVE_STATE_CODE_SUCCESS = '[Setup] Save State Code Success';

  saveStateCodeSuccess(message): Action {
    console.log("saveStateCodeSuccess");
    return {
      type: SetupActions.SAVE_STATE_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_STATE_CODE = '[Setup] Remove State Code';

  removeStateCode(code): Action {
    console.log("removeStateCode");
    return {
      type: SetupActions.REMOVE_STATE_CODE,
      payload: code
    };
  }

  static REMOVE_STATE_CODE_SUCCESS = '[Setup] Remove State Code Success';

  removeStateCodeSuccess(message): Action {
    console.log("removeStateCodeSuccess");
    return {
      type: SetupActions.REMOVE_STATE_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_STATE_CODE = '[Setup] Update State Code';

  updateStateCode(code): Action {
    console.log("updateStateCode");
    return {
      type: SetupActions.UPDATE_STATE_CODE,
      payload: code
    };
  }

  static UPDATE_STATE_CODE_SUCCESS = '[Setup] Update State Code  Success';

  updateStateCodeSuccess(message): Action {
    console.log("updateStateCodeSuccess");
    return {
      type: SetupActions.UPDATE_STATE_CODE_SUCCESS,
      payload: message
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

//=================================================================
// Grade Code
//=================================================================

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

  static SAVE_GRADE_CODE = '[Setup] Save Grade Code';

  saveGradeCode(code): Action {
    console.log("saveGradeCode");
    return {
      type: SetupActions.SAVE_GRADE_CODE,
      payload: code
    };
  }

  static SAVE_GRADE_CODE_SUCCESS = '[Setup] Save Grade Code Success';

  saveGradeCodeSuccess(message): Action {
    console.log("saveGradeCodeSuccess");
    return {
      type: SetupActions.SAVE_GRADE_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_GRADE_CODE = '[Setup] Update Grade Code';

  updateGradeCode(code): Action {
    console.log("updateGradeCode");
    return {
      type: SetupActions.UPDATE_GRADE_CODE,
      payload: code
    };
  }

  static UPDATE_GRADE_CODE_SUCCESS = '[Setup] Update Grade Code  Success';

  updateGradeCodeSuccess(message): Action {
    console.log("updateGradeCodeSuccess");
    return {
      type: SetupActions.UPDATE_GRADE_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_GRADE_CODE = '[Setup] Remove Grade Code';

  removeGradeCode(code): Action {
    console.log("removeGradeCode");
    return {
      type: SetupActions.REMOVE_GRADE_CODE,
      payload: code
    };
  }

  static REMOVE_GRADE_CODE_SUCCESS = '[Setup] Remove Grade Code  Success';

  removeGradeCodeSuccess(message): Action {
    console.log("removeGradeCodeSuccess");
    return {
      type: SetupActions.REMOVE_GRADE_CODE_SUCCESS,
      payload: message
    };
  }

//===========================================================================
//
//===========================================================================
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

  static SAVE_RELIGION_CODE = '[Setup] Save Religion Code';

  saveReligionCode(code): Action {
    console.log("saveReligionCode");
    return {
      type: SetupActions.SAVE_RELIGION_CODE,
      payload: code
    };
  }

  static SAVE_RELIGION_CODE_SUCCESS = '[Setup] Save Religion Code Success';

  saveReligionCodeSuccess(message): Action {
    console.log("saveReligionCodeSuccess");
    return {
      type: SetupActions.SAVE_RELIGION_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_RELIGION_CODE = '[Setup] Update Religion Code';

  updateReligionCode(code): Action {
    console.log("updateReligionCode");
    return {
      type: SetupActions.UPDATE_RELIGION_CODE,
      payload: code
    };
  }

  static UPDATE_RELIGION_CODE_SUCCESS = '[Setup] Update Religion Code  Success';

  updateReligionCodeSuccess(message): Action {
    console.log("updateReligionCodeSuccess");
    return {
      type: SetupActions.UPDATE_RELIGION_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_RELIGION_CODE = '[Setup] Remove Religion Code';

  removeReligionCode(code): Action {
    console.log("removeMaritalCode");
    return {
      type: SetupActions.REMOVE_RELIGION_CODE,
      payload: code
    };
  }

  static REMOVE_RELIGION_CODE_SUCCESS = '[Setup] Remove Religion Code  Success';

  removeReligionCodeSuccess(message): Action {
    console.log("removeReligionCodeSuccess");
    return {
      type: SetupActions.REMOVE_RELIGION_CODE_SUCCESS,
      payload: message
    };
  }


//================================================================
//
//================================================================

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

  static SAVE_NATIONALITY_CODE = '[Setup] Save Nationality Code';

  saveNationalityCode(code): Action {
    console.log("saveNationalityCode");
    return {
      type: SetupActions.SAVE_NATIONALITY_CODE,
      payload: code
    };
  }

  static SAVE_NATIONALITY_CODE_SUCCESS = '[Setup] Save Nationality Code Success';

  saveNationalityCodeSuccess(message): Action {
    console.log("saveNationalityCodeSuccess");
    return {
      type: SetupActions.SAVE_NATIONALITY_CODE_SUCCESS,
      payload: message
    };
  }

  static UPDATE_NATIONALITY_CODE = '[Setup] Update Nationality Code';

  updateNationalityCode(code): Action {
    console.log("updateNationalityCode");
    return {
      type: SetupActions.UPDATE_NATIONALITY_CODE,
      payload: code
    };
  }

  static UPDATE_NATIONALITY_CODE_SUCCESS = '[Setup] Update Nationality Code  Success';

  updateNationalityCodeSuccess(message): Action {
    console.log("updateNationalityCodeSuccess");
    return {
      type: SetupActions.UPDATE_NATIONALITY_CODE_SUCCESS,
      payload: message
    };
  }

  static REMOVE_NATIONALITY_CODE = '[Setup] Remove Nationality Code';

  removeNationalityCode(code): Action {
    console.log("removeNationalityCode");
    return {
      type: SetupActions.REMOVE_NATIONALITY_CODE,
      payload: code
    };
  }

  static REMOVE_NATIONALITY_CODE_SUCCESS = '[Setup] Remove Nationality Code  Success';

  removeNationalityCodeSuccess(message): Action {
    console.log("removeNationalityCodeSuccess");
    return {
      type: SetupActions.REMOVE_NATIONALITY_CODE_SUCCESS,
      payload: message
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
