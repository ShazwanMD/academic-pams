import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {AcademicSession} from "./AcademicSession.interface";
import {AcademicSessionActions} from "./AcademicSession.action";

export type AcademicSessionListState = AcademicSession[];

const initialState: AcademicSessionListState = <AcademicSession[]>[];

export function AcademicSessionListReducer(state = initialState, action: Action): AcademicSessionListState {
  console.log("action: " + action.type);
  switch (action.type) {
    case AcademicSessionActions.FIND_ACADEMICSESSIONS_SUCCESS: {
      return action.payload;
    }
    case AcademicSessionActions.CREATE_ACADEMICSESSIONS_SUCCESS: {
      return [...state, action.payload];
    }
    case AcademicSessionActions.SAVE_ACADEMICSESSIONS_SUCCESS: {
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
    case AcademicSessionActions.REMOVE_ACADEMICSESSIONS_SUCCESS: {
      return state.filter(cohort => {
        return AcademicSession.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
