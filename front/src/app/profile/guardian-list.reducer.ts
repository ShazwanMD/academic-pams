import {Action} from '@ngrx/store';

import {Guardian} from '../shared/model/profile/guardian.interface';
import {ProfileActions} from './profile.action';

export type GuardianListState = Guardian[];

const initialState: GuardianListState = <Guardian[]>[];

export function guardianListReducer(state = initialState, action: Action): GuardianListState {
  switch (action.type) {
    case ProfileActions.FIND_GUARDIANS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
