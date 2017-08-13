import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class AcademicYearActions {

  static FIND_ACADEMIC_YEARS = '[AcademicYear] Find Academic Years';

  findAcademicYears(): Action {
    return {
      type: AcademicYearActions.FIND_ACADEMIC_YEARS,
    };
  }

  static FIND_ACADEMIC_YEARS_SUCCESS = '[AcademicYear] Find Academic Years Success';

  findAcademicYearsSuccess(academicYears): Action {
    return {
      type: AcademicYearActions.FIND_ACADEMIC_YEARS_SUCCESS,
      payload: academicYears
    };
  }
  
  static FIND_ACADEMIC_YEAR_BY_CODE = '[AcademicYear] Find AcademicYear By Code';

  findAcademicYearByCode(code): Action {
       console.log("findAcademicYearByCode1" + code)
    return {
      type: AcademicYearActions.FIND_ACADEMIC_YEAR_BY_CODE,
      payload: code
    };
  }

  static FIND_ACADEMIC_YEAR_BY_CODE_SUCCESS = '[AcademicYear] Find AcademicYear By Code Success';

  findAcademicYearByCodeSuccess(academicYear): Action {
    console.log("findAcademicYearByCode2" + academicYear.code);
   
    return {
      type: AcademicYearActions.FIND_ACADEMIC_YEAR_BY_CODE_SUCCESS,
      payload: academicYear
    };
  }
  
  static SAVE_ACADEMIC_YEAR = '[AcademicYear] Save AcademicYear';

  saveAcademicYear(academicYear): Action {
    console.log("saveAcademicYear");
    return {
      type: AcademicYearActions.SAVE_ACADEMIC_YEAR,
      payload: academicYear
    };
  }

  static SAVE_ACADEMIC_YEAR_SUCCESS = '[AcademicYear] Save AcademicYear Success';

  saveAcademicYearSuccess(message): Action {
    console.log("saveAcademicYearSuccess");
    return {
      type: AcademicYearActions.SAVE_ACADEMIC_YEAR_SUCCESS,
      payload: {status: message}
    };
  }

  static UPDATE_ACADEMIC_YEAR = '[AcademicYear] Update AcademicYear';

  updateAcademicYear(academicYear): Action {
    console.log("updateAcademicYear")
    return {
      type: AcademicYearActions.UPDATE_ACADEMIC_YEAR,
      payload: academicYear
    };
  }

  static UPDATE_ACADEMIC_YEAR_SUCCESS = '[AcademicYear] Update AcademicYear';

  updateAcademicYearSuccess(message): Action {
    console.log("updateAcademicYearSuccess");
    console.log("academicYear: " + message);
    return {
      type: AcademicYearActions.UPDATE_ACADEMIC_YEAR_SUCCESS,
      payload: {status: message}
    };
  }
  
  
}

