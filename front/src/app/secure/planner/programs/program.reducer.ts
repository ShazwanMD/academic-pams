import {Action} from '@ngrx/store';
import {ProgramActions} from './program.action';
import {Program} from '../../../shared/model/planner/program.interface';

export type ProgramState = Program;

const initialState: ProgramState = <Program>{};

export function programReducer(state = initialState, action: Action): ProgramState {
  switch (action.type) {
    case ProgramActions.FIND_PROGRAM_BY_CODE_SUCCESS: {
      return action.payload;
    }
    case ProgramActions.CREATE_PROGRAM_SUCCESS: {
      return action.payload;
    }
    case ProgramActions.FIND_PROGRAM_LEVEL_BY_CODE_SUCCESS: {
      return action.payload;
    }

    case ProgramActions.FIND_PROGRAM_BY_CODE_SUCCESS: {
      return action.payload;
    }

    case ProgramActions.REMOVE_PROGRAM_SUCCESS: {
      return action.payload;
    }

    default: {
      return state;
    }
  }
}
