import { StudentProfileActions } from './student-profile.action';
import {Action} from '@ngrx/store';

import {Student} from '../../shared/model/identity/student.interface';

export type StudentListState = Student[];

const initialState: StudentListState = <Student[]>[];

export function studentListReducer(state = initialState, action: Action): StudentListState {
  switch (action.type) {
    case StudentProfileActions.FIND_STUDENTS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
