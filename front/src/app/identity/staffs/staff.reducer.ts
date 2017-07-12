import { Action } from '@ngrx/store';
import { StaffActions } from "./staff.action";
import { Staff } from "./staff.interface";

export type StaffState = Staff;

const initialState: StaffState = <Staff>{};

export function staffReducer(state = initialState, action: Action): StaffState {
  switch (action.type) {
    case StaffActions.FIND_STAFF_BY_IDENTITY_NO_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
