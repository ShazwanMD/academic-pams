import {Action} from '@ngrx/store';
import {GraduationApplicationActions} from './graduation-application.action';
import {GraduationApplication} from '../../../shared/model/term/graduation-application.interface';

export type GraduationApplicationListState = GraduationApplication[];

const initialState: GraduationApplicationListState = <GraduationApplication[]>[];

export function archivedGraduationApplicationListReducer(state = initialState, action: Action): GraduationApplicationListState {
  switch (action.type) {
    case GraduationApplicationActions.FIND_ARCHIVED_GRADUATION_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function graduationApplicationListReducer(state = initialState, action: Action): GraduationApplicationListState {
  switch (action.type) {
   /* case GraduationApplicationActions.FIND_GRADUATION_APPLICATIONS_SUCCESS: {
      return action.payload;
    }*/
    default: {
      return state;
    }
  }
}
