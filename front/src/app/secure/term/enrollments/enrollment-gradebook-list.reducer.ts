import { EnrollmentActions} from './enrollment.action';
import {Gradebook} from '../../../shared/model/term/gradebook.interface';
import {Action} from '@ngrx/store';

export type EnrollmentGradebookListState = Gradebook[];

const initialState: EnrollmentGradebookListState = <Gradebook[]>[];

export function enrollmentGradebookListReducer(state = initialState, action: Action): EnrollmentGradebookListState {
  switch (action.type) {
    case EnrollmentActions.FIND_GRADEBOOKS_BY_ENROLLMENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
