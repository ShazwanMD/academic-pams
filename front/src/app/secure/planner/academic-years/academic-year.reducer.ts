import {AcademicYear} from '../../../shared/model/planner/academic-year.interface';
import {AcademicYearActions} from './academic-year.action';
import {Action} from '@ngrx/store';

export type AcademicYearState = AcademicYear;

const initialState: AcademicYearState = <AcademicYear>{};

export function academicYearReducer(state = initialState, action: Action): AcademicYearState {
  switch (action.type) {
 case AcademicYearActions.FIND_ACADEMIC_YEAR_BY_CODE_SUCCESS: {
      return action.payload;
    }
      
           case AcademicYearActions.SAVE_ACADEMIC_YEAR_SUCCESS: {
        return action.payload;
      }
          
    case AcademicYearActions.UPDATE_ACADEMIC_YEAR_SUCCESS: {
        return action.payload;
      }
      
    default: {
      return state;
    }
  }
}
