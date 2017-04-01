import {Action} from '@ngrx/store';
import {FacultyActions} from "./faculty.action";
import {Faculty} from "./faculty.interface";

export type FacultyState = Faculty;

const initialState: FacultyState = {
  id: 0,
  code: '',
  name:'',
};

export function facultyReducer(state = initialState, action: Action): FacultyState {
  console.log("action: " + action);
  switch (action.type) {
    case FacultyActions.RESET_FACULTY: {
      return initialState;
    }
    case FacultyActions.FIND_FACULTY_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
