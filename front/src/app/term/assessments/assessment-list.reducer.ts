import { AssessmentActions } from './assessment.action';
import { Assessment } from './assessment.interface';
import { Action } from '@ngrx/store';
import { Observable } from 'rxjs/Observable';

import * as _ from 'lodash';

export type AssessmentListState = Assessment[];

const initialState: AssessmentListState = <Assessment[]>[];

export function assessmentListReducer(state = initialState, action: Action): AssessmentListState {
  switch (action.type) {
    case AssessmentActions.FIND_ASSESSMENTS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
