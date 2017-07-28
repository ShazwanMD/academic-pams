import {AssessmentActions} from './assessment.action';
import {Assessment} from '../../../shared/model/term/assessment.interface';
import {Action} from '@ngrx/store';

export type AssessmentState = Assessment[];

const initialState: AssessmentState = <Assessment[]>[];

export function assessmentReducer(state = initialState, action: Action): AssessmentState {
  switch (action.type) {
    case AssessmentActions.FIND_ASSESSMENT_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }

}
