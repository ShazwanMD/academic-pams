import {Action} from '@ngrx/store';

import {Address} from '../../shared/model/profile/address.interface';
import {StudentProfileActions} from './Student-Profile.action';

export type AddressListState = Address[];

const initialState: AddressListState = <Address[]>[];

export function addressListReducer(state = initialState, action: Action): AddressListState {
  switch (action.type) {
    case StudentProfileActions.FIND_ADDRESSES_BY_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
