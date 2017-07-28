import {AcademicYear} from '../../../shared/model/planner/academic-year.interface';
import {AcademicYearActions} from './academic-year.action';
import {Action} from '@ngrx/store';

export type AcademicYearListState = AcademicYear[];

const initialState: AcademicYearListState = <AcademicYear[]>[];

export function academicYearListReducer(state = initialState, action: Action): AcademicYearListState {
  switch (action.type) {
    case AcademicYearActions.FIND_ACADEMICYEARS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
