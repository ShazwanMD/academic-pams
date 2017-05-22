import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Program} from "./program.interface";
import {ProgramActions} from "./program.action";

export type ProgramListState = Program[];

const initialState: ProgramListState = <Program[]>[];

export function programListReducer(state = initialState, action: Action): ProgramListState {
  switch (action.type) {
    case ProgramActions.FIND_PROGRAMS_SUCCESS: {
      return action.payload;
    }
    case ProgramActions.CREATE_PROGRAM_SUCCESS: {
      return [...state, action.payload];
    }
    default: {
      return state;
    }
  }
}
