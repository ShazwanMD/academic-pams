import {Action} from '@ngrx/store';

import {Address} from '../shared/model/profile/address.interface';
import {ProfileActions} from './profile.action';

export type AddressListState = Address[];

const initialState: AddressListState = <Address[]>[];

export function addressListReducer(state = initialState, action: Action): AddressListState {
  switch (action.type) {
    case ProfileActions.FIND_ADDRESSES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
