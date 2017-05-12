import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {StaffActions} from "./staff.action";
import {Staff} from "./staff.interface";

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