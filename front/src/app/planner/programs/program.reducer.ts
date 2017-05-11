import {Action} from '@ngrx/store';
import {ProgramActions} from "./program.action";
import {Program} from "./program.interface";

export type ProgramState = Program;

const initialState: ProgramState = <Program>{};

export function programReducer(state = initialState, action: Action): ProgramState {
  switch (action.type) {
    case ProgramActions.RESET_PROGRAM: {
      return initialState;
    }
    case ProgramActions.FIND_PROGRAM_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
