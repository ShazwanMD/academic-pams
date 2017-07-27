import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Cohort} from "../../shared/model/planner/cohort.interface";
import {CohortActions} from "./cohort.action";

export type CohortListState = Cohort[];

const initialState: CohortListState = <Cohort[]>[];

export function cohortListReducer(state = initialState, action: Action): CohortListState {
  switch (action.type) {
    case CohortActions.FIND_COHORTS_SUCCESS: {
      return action.payload;
    }
    case CohortActions.SAVE_COHORT_SUCCESS: {
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
    case CohortActions.REMOVE_COHORT_SUCCESS: {
      return state.filter(cohort => {
        return cohort.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
