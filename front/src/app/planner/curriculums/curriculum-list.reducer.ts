import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {Curriculum} from './curriculum.interface';
import {CurriculumActions} from './curriculum.action';

export type CurriculumListState = Curriculum[];

const initialState: CurriculumListState = <Curriculum[]>[];

export function curriculumListReducer(state = initialState, action: Action): CurriculumListState {
  switch (action.type) {
    case CurriculumActions.FIND_CURRICULUMS_SUCCESS: {
      return action.payload;
    }
    case CurriculumActions.SAVE_CURRICULUM_SUCCESS: {
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
    case CurriculumActions.REMOVE_CURRICULUM_SUCCESS: {
      return state.filter((curriculum) => {
        return curriculum.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
