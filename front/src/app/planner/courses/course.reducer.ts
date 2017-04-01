import {Action} from '@ngrx/store';
import {CourseActions} from "./course.action";
import {Course} from "./course.interface";

export type CourseState = Course;

const initialState: CourseState = {
  id: 0,
  code: '',
  title:'',
  titleMs:'',
  titleEn:'',
  credit:0,
};

export function courseReducer(state = initialState, action: Action): CourseState {
  console.log("action: " + action);
  switch (action.type) {
    case CourseActions.RESET_BLANK_COURSE: {
      return initialState;
    }
    case CourseActions.GET_COURSE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
