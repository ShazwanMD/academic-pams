import { Enrollment } from '../shared/model/term/enrollment.interface';
import {Action} from '@ngrx/store';
import {ProfileActions} from './profile.action';

export type EnrollmentListState = Enrollment[];

const initialState: EnrollmentListState = <Enrollment[]>[];

export function enrollmentListReducer(state = initialState, action: Action): EnrollmentListState {
  switch (action.type) {
    case ProfileActions.FIND_ENROLLMENTS_BY_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
