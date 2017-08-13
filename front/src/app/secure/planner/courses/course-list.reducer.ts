import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {Course} from '../../../shared/model/planner/course.interface';
import {CourseActions} from './course.action';

export type CourseListState = Course[];

const initialState: CourseListState = <Course[]>[];

export function courseListReducer(state = initialState, action: Action): CourseListState {
  switch (action.type) {
    case CourseActions.FIND_COURSES_SUCCESS: {
      return action.payload;
    }
    /*case CourseActions.ADD_COURSE_SUCCESS: {
      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1)
        ];
      }
      return state;
    }*/
    case CourseActions.REMOVE_COURSE_SUCCESS: {
      return state.filter(course => {
        return course.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
