import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Student} from "../identity/student.interface";
import {ProfileActions} from "./profile.action";

export type ProfileListState = Student[];

const initialState: ProfileListState = <Student[]>[];

export function profileListReducer(state = initialState, action: Action): ProfileListState {
  console.log("action: " + action.type);
  switch (action.type) {
    case ProfileActions.FIND_PROFILES_SUCCESS: {
      return action.payload;
    }
    case ProfileActions.CREATE_PROFILE_SUCCESS: {
      return [...state, action.payload];
    }
    default: {
      return state;
    }
  }
}
