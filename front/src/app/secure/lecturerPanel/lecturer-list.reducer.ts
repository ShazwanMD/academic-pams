import { LecturerActions } from './lecturer.action';
import { Staff } from './../../shared/model/identity/staff.interface';

import {Action} from '@ngrx/store';



export type LecturerListState = Staff[];

const initialState: LecturerListState = <Staff[]>[];

export function lecturerListReducer(state = initialState, action: Action): LecturerListState {
  switch (action.type) {
    case LecturerActions.FIND_LECTURER_BY_USER_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
