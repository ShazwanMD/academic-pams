import { StudentProfileActions } from './student-profile.action';
import { AcademicSession } from './../../shared/model/planner/academic-session.interface';
import {Action} from '@ngrx/store';

import * as _ from 'lodash';

export type AcademicSessionListState = AcademicSession [];

const initialState: AcademicSessionListState = <AcademicSession[]>[];

export function academicSessionListReducer(state = initialState, action: Action): AcademicSessionListState {
  switch (action.type) {
    case StudentProfileActions.FIND_ACADEMIC_SESSIONS_BY_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
