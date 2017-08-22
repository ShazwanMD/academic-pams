import { StudentProfileActions } from './student-profile.action';
import {Action} from '@ngrx/store';
import { AcademicSession } from "../../shared/model/planner/academic-session.interface";


export type AcademicSessionState = AcademicSession;

const initialState: AcademicSessionState = <AcademicSession> {};

export function academicSessionReducer(state = initialState, action: Action): AcademicSessionState {
  switch (action.type) {
    case StudentProfileActions.FIND_ACADEMIC_SESSION_BY_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
