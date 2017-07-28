import {Action} from '@ngrx/store';
import {Student} from '../../shared/model/identity/student.interface';
import {ProfileActions} from './profile.action';

export type StudentState = Student;

const initialState: StudentState = <Student>{};

export function studentReducer(state = initialState, action: Action): StudentState {
  switch (action.type) {
    case ProfileActions.FIND_STUDENT_BY_IDENTITY_NO_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
