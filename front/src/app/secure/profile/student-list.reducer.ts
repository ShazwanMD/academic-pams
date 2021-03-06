import {Action} from '@ngrx/store';

import {Student} from '../../shared/model/identity/student.interface';
import {ProfileActions} from './profile.action';

export type StudentListState = Student[];

const initialState: StudentListState = <Student[]>[];

export function studentListReducer(state = initialState, action: Action): StudentListState {
  switch (action.type) {
    case ProfileActions.FIND_STUDENTS_SUCCESS: {
      return action.payload;
    }
    case ProfileActions.FIND_GRADUATED_STUDENTS_SUCCESS: {
        return action.payload;
      }
    default: {
      return state;
    }
  }
}
