import { StudentProfileActions } from './student-profile.action';
import {Action} from '@ngrx/store';
import {Student} from '../../shared/model/identity/student.interface';


export type StudentState = Student;

const initialState: StudentState = <Student>{};

export function studentReducer(state = initialState, action: Action): StudentState {
  switch (action.type) {
    case StudentProfileActions.FIND_STUDENT_BY_IDENTITY_NO_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
