import {GraduationApplication} from '../../shared/model/graduation/graduation-application.interface';
import {Action} from '@ngrx/store';
import {ProfileActions} from './profile.action';

export type GraduationApplicationListState = GraduationApplication[];

const initialState: GraduationApplicationListState = <GraduationApplication[]>[];

export function graduationApplicationListReducer(state = initialState, action: Action): GraduationApplicationListState {
  switch (action.type) {
    case ProfileActions.FIND_GRADUATION_APPLICATIONS_BY_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
