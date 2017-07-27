import {Action} from '@ngrx/store';

import {Guarantor} from '../shared/model/profile/guarantor.interface';
import {ProfileActions} from './profile.action';

export type GuarantorListState = Guarantor[];

const initialState: GuarantorListState = <Guarantor[]>[];

export function guarantorListReducer(state = initialState, action: Action): GuarantorListState {
  switch (action.type) {
    case ProfileActions.FIND_GUARANTORS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
