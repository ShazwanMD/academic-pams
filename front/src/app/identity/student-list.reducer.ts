import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {StudentActions} from "./student.action";
import {Student} from "./student.interface";

export type StudentListState = Student[];

const initialState: StudentListState = <Student[]>[];

export function studentListReducer(state = initialState, action: Action): StudentListState {
  switch (action.type) {
    case StudentActions.FIND_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
