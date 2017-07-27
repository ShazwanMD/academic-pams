import {SectionActions} from './section.action';
import {Gradebook} from '../../shared/model/term/gradebook.interface';
import {Action} from '@ngrx/store';

export type SectionGradebookListState = Gradebook[];

const initialState: SectionGradebookListState = <Gradebook[]>[];

export function sectionGradebookListReducer(state = initialState, action: Action): SectionGradebookListState {
  switch (action.type) {
    case SectionActions.FIND_GRADEBOOKS_BY_SECTION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
