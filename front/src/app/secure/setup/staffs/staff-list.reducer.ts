import {Action} from '@ngrx/store';
import { Staff } from '../../../shared/model/identity/staff.interface';
import { StaffActions } from '../../identity/staffs/staff.action';


export type StaffsState = Staff[];

const initialState: StaffsState = <Staff[]>[];

export function staffsReducer(state = initialState, action: Action): StaffsState {
  switch (action.type) {
    case StaffActions.FIND_ACADEMIC_STAFFS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
