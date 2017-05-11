import {Action} from '@ngrx/store';
import {CourseActions} from "./course.action";
import {Course} from "./course.interface";

export type CourseState = Course;

const initialState: CourseState = <Course>{};

export function courseReducer(state = initialState, action: Action): CourseState {
  switch (action.type) {
    case CourseActions.RESET_COURSE: {
      return initialState;
    }
    case CourseActions.FIND_COURSE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
