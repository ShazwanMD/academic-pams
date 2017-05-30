import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {AcademicYear} from './academic-year.interface';

@Injectable()
export class AcademicYearActions {

  static FIND_ACADEMICYEARS = '[AcademicYear] Find AcademicYears';
  findAcademicYears(): Action {
    return {
      type: AcademicYearActions.FIND_ACADEMICYEARS,
    };
  }

  static FIND_ACADEMICYEARS_SUCCESS = '[AcademicYear] Find AcademicYears Success';
  findAcademicYearsSuccess(academicYears): Action {

    console.log("findAcademicYearsSuccess");
    return {
      type: AcademicYearActions.FIND_ACADEMICYEARS_SUCCESS,
      payload: academicYears
    };
  }

  


 
 
 

 
}

