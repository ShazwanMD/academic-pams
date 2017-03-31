import {Action} from '@ngrx/store';
import {ProgramActions} from "./program.action";
import {Program} from "./program.interface";

export type ProgramState = Program;

const initialState: ProgramState = {
  id: 0,
  code: '',
  title:'',
  titleMs:'',
  titleEn:''
};

export function programReducer(state = initialState, action: Action): ProgramState {
  console.log("action: " + action);
  switch (action.type) {
    case ProgramActions.RESET_BLANK_PROGRAM: {
      return initialState;
    }
    case ProgramActions.GET_PROGRAM_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
