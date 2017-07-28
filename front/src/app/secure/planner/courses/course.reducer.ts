import {Action} from '@ngrx/store';
import {CourseActions} from './course.action';
import {Course} from '../../../shared/model/planner/course.interface';

export type CourseState = Course;

const initialState: CourseState = <Course>{};

export function courseReducer(state = initialState, action: Action): CourseState {
  switch (action.type) {
    case CourseActions.FIND_COURSE_BY_CODE_SUCCESS: {
      return action.payload;
    }
    case CourseActions.CREATE_COURSE_SUCCESS: {
      return action.payload;

    }

    case CourseActions.FIND_COURSE_BY_CODE_SUCCESS: {
      return action.payload;
    }

    case CourseActions.REMOVE_COURSE_SUCCESS: {
      return action.payload;
    }

    default: {
      return state;
    }
  }
}
