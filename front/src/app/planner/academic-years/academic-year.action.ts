import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';
import {AcademicYear} from './academic-year.interface';

@Injectable()
export class AcademicYearActions {

  static FIND_ACADEMICYEARS = '[Course] Find AcademicYears';
  findAcademicYears(): Action {
    return {
      type: AcademicYearActions.FIND_ACADEMICYEARS
    };
  }

  static FIND_ACADEMICYEARS_SUCCESS = '[Course] Find AcademicYears Success';
  findAcademicYearsSuccess(academicYears): Action {
    return {
      type: AcademicYearActions.FIND_ACADEMICYEARS_SUCCESS,
      payload: academicYears
    };
  }

  


 
 
 

 
}

