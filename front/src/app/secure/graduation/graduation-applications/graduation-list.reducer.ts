import {Action} from '@ngrx/store';
import {GraduationApplicationActions} from './graduation-application.action';
import {Graduation} from '../../../shared/model/graduation/graduation.interface';

export type GraduationListState = Graduation[];

const initialState: GraduationListState = <Graduation[]>[];

/*export function archivedGraduationListReducer(state = initialState, action: Action): GraduationListState {
  switch (action.type) {
    case GraduationApplicationActions.FIND_ARCHIVED_GRADUATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}*/

export function graduationListReducer(state = initialState, action: Action): GraduationListState {
  switch (action.type) {
    case GraduationApplicationActions.FIND_GRADUATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
