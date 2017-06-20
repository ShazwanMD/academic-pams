import {Action} from '@ngrx/store';
import {EnrollmentApplicationActions} from "./enrollment-application.action";
import {EnrollmentApplication} from "./enrollment-application.interface";

export type EnrollmentApplicationState = EnrollmentApplication;

const initialState: EnrollmentApplicationState = <EnrollmentApplication>{};

export function enrollmentApplicationReducer(state = initialState, action: Action): EnrollmentApplicationState {
  switch (action.type) {
    case EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_BY_ID_SUCCESS: {
      return action.payload;
    }

    case EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
