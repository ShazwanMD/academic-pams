import {Action} from '@ngrx/store';

import {OfferingActions} from './offering.action';
import {GradebookMatrix} from '../../shared/model/term/gradebook-matrix.interface';

export type GradebookMatrixListState = GradebookMatrix[];

const initialState: GradebookMatrixListState = <GradebookMatrix[]>[];

export function gradebookMatrixListReducer(state = initialState, action: Action): GradebookMatrixListState {
  switch (action.type) {
    case OfferingActions.FIND_GRADEBOOK_MATRICESS_BY_OFFERING_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
