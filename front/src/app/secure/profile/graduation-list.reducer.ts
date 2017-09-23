import {Graduation} from '../../shared/model/graduation/graduation.interface';
import {Action} from '@ngrx/store';
import {ProfileActions} from './profile.action';

export type GraduationListState = Graduation[];

const initialState: GraduationListState = <Graduation[]>[];

export function graduationListReducer(state = initialState, action: Action): GraduationListState {
  switch (action.type) {
    case ProfileActions.FIND_GRADUATIONS_BY_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
