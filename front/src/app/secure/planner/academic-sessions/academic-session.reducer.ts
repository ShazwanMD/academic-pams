import {Action} from '@ngrx/store';
import {AcademicSessionActions} from './academic-session.action';
import {AcademicSession} from '../../../shared/model/planner/academic-session.interface';

export type AcademicSessionState = AcademicSession;

const initialState: AcademicSessionState = <AcademicSession> {};

export function academicSessionReducer(state = initialState, action: Action): AcademicSessionState {
  switch (action.type) {
    case AcademicSessionActions.FIND_ACADEMIC_SESSION_BY_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
