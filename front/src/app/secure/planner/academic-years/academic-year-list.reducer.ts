import {Action} from '@ngrx/store';
import * as _ from 'lodash';
import {AcademicYear} from '../../../shared/model/planner/academic-year.interface';
import {AcademicYearActions} from './academic-year.action';

export type AcademicYearListState = AcademicYear [];

const initialState: AcademicYearListState = <AcademicYear[]>[];

export function academicYearListReducer(state = initialState, action: Action): AcademicYearListState {
  switch (action.type) {
    case AcademicYearActions.FIND_ACADEMIC_YEARS_SUCCESS: {
      return action.payload;
    }

    case AcademicYearActions.SAVE_ACADEMIC_YEAR_SUCCESS: {
      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1),
        ];
      }
      return state;
    }

    /*case AcademicYearActions.REMOVE_ACADEMIC_YEAR_SUCCESS: {
      return state.filter((academicYear) => {
        return academicYear.id !== action.payload.id;
      });
    }*/
    default: {
      return state;
    }
  }
}
