import {Action} from '@ngrx/store';
import {EnrollmentActions} from "./enrollment.action";
import {Enrollment} from "./enrollment.interface";

export type EnrollmentState = Enrollment;

const initialState: EnrollmentState = <Enrollment>{};

export function enrollmentReducer(state = initialState, action: Action): EnrollmentState {
  switch (action.type) {
    case EnrollmentActions.FIND_ENROLLMENT_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
