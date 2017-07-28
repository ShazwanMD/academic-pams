import {Action} from '@ngrx/store';
import {CohortActions} from './cohort.action';
import {Cohort} from '../../../shared/model/planner/cohort.interface';

export type CohortState = Cohort;

const initialState: CohortState = <Cohort>{};

export function cohortReducer(state = initialState, action: Action): CohortState {
  switch (action.type) {
    case CohortActions.FIND_COHORT_BY_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
