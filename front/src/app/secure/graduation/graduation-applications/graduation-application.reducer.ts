import {Action} from '@ngrx/store';
import {GraduationApplication} from '../../../shared/model/graduation/graduation-application.interface';
import {GraduationApplicationActions} from './graduation-application.action';

export type GraduationApplicationState = GraduationApplication;

const initialState: GraduationApplicationState = <GraduationApplicationState>{};

export function graduationApplicationReducer(state = initialState, action: Action): GraduationApplicationState {
  switch (action.type) {
    case GraduationApplicationActions.FIND_GRADUATION_APPLICATION_BY_ID_SUCCESS: {
      return action.payload;
    }
    case GraduationApplicationActions.FIND_GRADUATION_APPLICATION_BY_REFERENCE_NO_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
