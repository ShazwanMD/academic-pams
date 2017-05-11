import {Action} from '@ngrx/store';
import {Student} from "../identity/student.interface";
import {ProfileActions} from "./profile.action";

export type ProfileState = Student;

const initialState: ProfileState = <Student>{};

export function profileReducer(state = initialState, action: Action): ProfileState {
  switch (action.type) {
    case ProfileActions.RESET_PROFILE: {
      return initialState;
    }
    case ProfileActions.FIND_PROFILE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
