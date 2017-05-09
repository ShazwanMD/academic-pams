import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Enrollment} from "./enrollment.interface";
import {EnrollmentActions} from "./enrollment.action";

export type EnrollmentListState = Enrollment[];

const initialState: EnrollmentListState = <Enrollment[]>[];

export function enrollmentListReducer(state = initialState, action: Action): EnrollmentListState {
  console.log("action: " + action.type);
  switch (action.type) {
    case EnrollmentActions.FIND_ENROLLMENTS_SUCCESS: {
      return action.payload;
    }
    case EnrollmentActions.SAVE_ENROLLMENT_SUCCESS: {
      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1)
        ];
      }
      return state;
    }
    case EnrollmentActions.REMOVE_ENROLLMENT_SUCCESS: {
      return state.filter(enrollment => {
        return enrollment.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
