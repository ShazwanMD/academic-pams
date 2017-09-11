import {Action} from '@ngrx/store';

import {SectionActions} from './section.action';
import {GradebookMatrix} from '../../../shared/model/term/gradebook-matrix.interface';

export type GradebookMatrixListStateSection = GradebookMatrix[];

const initialState: GradebookMatrixListStateSection = <GradebookMatrix[]>[];

export function gradebookMatrixListReducerSection(state = initialState, action: Action): GradebookMatrixListStateSection {
  switch (action.type) {
    case SectionActions.FIND_GRADEBOOK_MATRICESS_BY_SECTION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
