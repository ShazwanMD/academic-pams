import { StudentProfileActions } from './student-profile.action';
import {Enrollment} from '../../shared/model/term/enrollment.interface';
import {Action} from '@ngrx/store';


export type EnrollmentStudentListState = Enrollment[];

const initialState: EnrollmentStudentListState = <Enrollment[]>[];

export function enrollmentStudentListReducer(state = initialState, action: Action): EnrollmentStudentListState {
  switch (action.type) {
    case StudentProfileActions.FIND_ENROLLMENTS_BY_ADMISSIONS_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
