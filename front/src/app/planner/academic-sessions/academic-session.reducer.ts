import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {AcademicSession} from "./academic-session.interface";
import {AcademicSessionActions} from "./academic-session.action";

export type AcademicSessionState = AcademicSession;

const initialState: AcademicSessionState = <AcademicSession>{};

export function academicSessionReducer(state = initialState, action: Action): AcademicSessionState {
  console.log("action: " + action.type);
  switch (action.type) {
    case AcademicSessionActions.FIND_ACADEMIC_SESSION_BY_CODE_SUCCESS: {
      return action.payload;
    }

    case AcademicSessionActions.SAVE_ACADEMIC_SESSION_SUCCESS: {
      return state;
    }
    default: {
      return state;
    }
  }
}
