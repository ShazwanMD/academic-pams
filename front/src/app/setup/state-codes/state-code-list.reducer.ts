import { StateCode } from './../../common/state-codes/state-code.interface';
import {SetupActions} from './../setup.action';
import {Action} from '@ngrx/store';


export type StateCodeListState = StateCode[];

const initialState: StateCodeListState = <StateCode[]>[];

export function stateCodeListReducer(state = initialState, action: Action): StateCodeListState {
  switch (action.type) {
    case SetupActions.FIND_STATE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}