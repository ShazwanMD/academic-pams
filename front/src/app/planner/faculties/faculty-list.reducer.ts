import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Faculty} from "./faculty.interface";
import {FacultyActions} from "./faculty.action";

export type FacultyListState = Faculty[];

const initialState: FacultyListState = <Faculty[]>[];

export function facultyListReducer(state = initialState, action: Action): FacultyListState {
  console.log("action: " + action);
  switch (action.type) {
    case FacultyActions.FIND_FACULTIES_SUCCESS: {
      console.log("find faculties success");
      return action.payload;
    }
    case FacultyActions.CREATE_FACULTY_SUCCESS: {
      return [...state, action.payload];
    }
    case FacultyActions.SAVE_FACULTY_SUCCESS: {
      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1)
        ];
      }
      return state;
    }
    case FacultyActions.REMOVE_FACULTY_SUCCESS: {
      return state.filter(faculty => {
        return faculty.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
