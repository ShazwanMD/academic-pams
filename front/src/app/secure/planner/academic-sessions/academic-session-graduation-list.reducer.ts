import {Action} from '@ngrx/store';

import {Graduation} from '../../../shared/model/graduation/graduation.interface';
import {AcademicSessionActions} from './academic-session.action';

export type AcademicSessionGraduationListState = Graduation[];

const initialState: AcademicSessionGraduationListState = <Graduation[]>[];

export function academicSessionGraduationListReducer(state = initialState, action: Action): AcademicSessionGraduationListState {
  switch (action.type) {
    case AcademicSessionActions.FIND_GRADUATIONS_BY_ACADEMICSESSION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
