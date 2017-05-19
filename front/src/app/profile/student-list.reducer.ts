import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Student} from "../identity/student.interface";
import {ProfileActions} from "./profile.action";

export type StudentListState = Student[];

const initialState: StudentListState = <Student[]>[];

export function studentListReducer(state = initialState, action: Action): StudentListState {
  switch (action.type) {
    case ProfileActions.FIND_STUDENTS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
