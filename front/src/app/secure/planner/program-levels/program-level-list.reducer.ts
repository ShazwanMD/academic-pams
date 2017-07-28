import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {ProgramLevel} from '../../../shared/model/planner/program-level.interface';
import {ProgramLevelActions} from './program-level.action';

export type ProgramLevelListState = ProgramLevel [];

const initialState: ProgramLevelListState = <ProgramLevel[]>[];

export function programLevelListReducer(state = initialState, action: Action): ProgramLevelListState {
  switch (action.type) {
    case ProgramLevelActions.FIND_PROGRAM_LEVELS_SUCCESS: {
      return action.payload;
    }

    case ProgramLevelActions.SAVE_PROGRAM_LEVEL_SUCCESS: {
      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1),
        ];
      }
      return state;
    }

    case ProgramLevelActions.REMOVE_PROGRAM_LEVEL_SUCCESS: {
      return state.filter((programLevel) => {
        return programLevel.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
