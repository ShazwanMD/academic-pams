import {Action} from '@ngrx/store';

import {Enrollment} from '../../../shared/model/term/enrollment.interface';
import {SectionActions} from './section.action';

export type EnrollmentListState = Enrollment[];

const initialState: EnrollmentListState = <Enrollment[]>[];

export function enrollmentListReducer(state = initialState, action: Action): EnrollmentListState {
  switch (action.type) {
    case SectionActions.FIND_ENROLLMENTS_BY_SECTION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
