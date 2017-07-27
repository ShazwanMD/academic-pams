import {Action} from '@ngrx/store';
import {GradebookActions} from './gradebook.action';
import {Gradebook} from '../../shared/model/term/gradebook.interface';

export type GradebookState = Gradebook;

const initialState: GradebookState = <Gradebook>{};

export function gradebookReducer(state = initialState, action: Action): GradebookState {
  switch (action.type) {
    case GradebookActions.FIND_GRADEBOOK_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
