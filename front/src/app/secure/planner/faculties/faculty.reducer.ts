import {Action} from '@ngrx/store';
import {FacultyActions} from './faculty.action';
import {Faculty} from '../../../shared/model/planner/faculty.interface';

export type FacultyState = Faculty;

const initialState: FacultyState = <Faculty>{};

export function facultyReducer(state = initialState, action: Action): FacultyState {
  switch (action.type) {
    case FacultyActions.FIND_FACULTY_BY_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
