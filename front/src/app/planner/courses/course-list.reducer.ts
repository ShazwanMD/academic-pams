import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Course} from "./course.interface";
import {CourseActions} from "./course.action";

export type CourseListState = Course[];

const initialState: CourseListState = <Course[]>[];

export function courseListReducer(state = initialState, action: Action): CourseListState {
  console.log("action: " + action);
  switch (action.type) {
    case CourseActions.LOAD_COURSES_SUCCESS: {
      console.log("load courses success");
      console.log("length: " + action.payload.length);
      return action.payload;
    }
    case CourseActions.CREATE_COURSE_SUCCESS: {
      return [...state, action.payload];
    }
    case CourseActions.SAVE_COURSE_SUCCESS: {
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
    case CourseActions.DELETE_COURSE_SUCCESS: {
      return state.filter(course => {
        return course.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
