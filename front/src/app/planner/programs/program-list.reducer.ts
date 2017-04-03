import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Program} from "./program.interface";
import {ProgramActions} from "./program.action";

export type ProgramListState = Program[];

const initialState: ProgramListState = <Program[]>[];

export function programListReducer(state = initialState, action: Action): ProgramListState {
  console.log("action: " + action.type);
  switch (action.type) {
    case ProgramActions.FIND_PROGRAMS_SUCCESS: {
      return action.payload;
    }
    case ProgramActions.CREATE_PROGRAM_SUCCESS: {
      return [...state, action.payload];
    }
    case ProgramActions.SAVE_PROGRAM_SUCCESS: {
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
    case ProgramActions.REMOVE_PROGRAM_SUCCESS: {
      return state.filter(program => {
        return program.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
