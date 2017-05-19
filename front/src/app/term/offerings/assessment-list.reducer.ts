import {Action} from '@ngrx/store';

import {Assessment} from "../assessments/assessment.interface";
import {OfferingActions} from "./offering.action";

export type AssessmentListState = Assessment[];

const initialState: AssessmentListState = <Assessment[]>[];

export function assessmentListReducer(state = initialState, action: Action): AssessmentListState {
  switch (action.type) {
    case OfferingActions.FIND_ASSESSMENTS_BY_OFFERING_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
