import {Action} from '@ngrx/store';
import {EnrollmentActions} from "./enrollment.action";
import {Enrollment} from "./enrollment.interface";

export type EnrollmentState = Enrollment;

const initialState: EnrollmentState = <Enrollment>{};

export function enrollmentReducer(state = initialState, action: Action): EnrollmentState {
  console.log("action: " + action);
  switch (action.type) {
    case EnrollmentActions.FIND_ENROLLMENTS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
