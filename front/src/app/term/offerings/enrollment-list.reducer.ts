import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Enrollment} from "../enrollments/enrollment.interface";
import {EnrollmentActions} from "../enrollments/enrollment.action";
import {OfferingActions} from "./offering.action";

export type EnrollmentListState = Enrollment[];

const initialState: EnrollmentListState = <Enrollment[]>[];

export function enrollmentListReducer(state = initialState, action: Action): EnrollmentListState {
  switch (action.type) {
    case OfferingActions.FIND_ENROLLMENTS_BY_OFFERING_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
