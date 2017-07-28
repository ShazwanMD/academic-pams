import {Action} from '@ngrx/store';
import {StaffActions} from './staff.action';
import {Staff} from '../../shared/model/identity/staff.interface';

export type StaffListState = Staff[];

const initialState: StaffListState = <Staff[]>[];

export function staffListReducer(state = initialState, action: Action): StaffListState {
  switch (action.type) {
    case StaffActions.FIND_STAFFS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
