import {Action} from '@ngrx/store';

import {Assessment} from "../assessments/assessment.interface";
import {OfferingActions} from "./offering.action";

export type OfferingAssessmentListState = Assessment[];

const initialState: OfferingAssessmentListState = <Assessment[]>[];

export function offeringAssessmentListReducer(state = initialState, action: Action): OfferingAssessmentListState {
  switch (action.type) {
    case OfferingActions.FIND_ASSESSMENTS_BY_OFFERING_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
