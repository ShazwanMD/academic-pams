import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class CourseActions {

  static FIND_COURSES = '[Course] Find Courses';
  findCourses(): Action {
    return {
      type: CourseActions.FIND_COURSES
    };
  }

  static FIND_COURSES_SUCCESS = '[Course] Find Courses Success';
  findCoursesSuccess(courses): Action {
    return {
      type: CourseActions.FIND_COURSES_SUCCESS,
      payload: courses
    };
  }

  static FIND_COURSE_BY_CODE = '[Course] Find Course';
  findCourseByCode(code): Action {
    return {
      type: CourseActions.FIND_COURSE_BY_CODE,
      payload: code
    };
  }

  static FIND_COURSE_BY_CODE_SUCCESS = '[Course] Find Course Success';
  findCourseByCodeSuccess(course): Action {
    return {
      type: CourseActions.FIND_COURSE_BY_CODE_SUCCESS,
      payload: course
    };
  }

  static SAVE_COURSE = '[Course] Save Course';
  saveCourse(course): Action {
    return {
      type: CourseActions.SAVE_COURSE,
      payload: course
    };
  }

  static SAVE_COURSE_SUCCESS = '[Course] Save Course Success';
  saveCourseSuccess(course): Action {
    return {
      type: CourseActions.SAVE_COURSE_SUCCESS,
      payload: course
    };
  }

  static REMOVE_COURSE = '[Course] Remove Course';
  removeCourse(course): Action {
    return {
      type: CourseActions.REMOVE_COURSE,
      payload: course
    };
  }

  static REMOVE_COURSE_SUCCESS = '[Course] Remove Course Success';
  removeCourseSuccess(course): Action {
    return {
      type: CourseActions.REMOVE_COURSE_SUCCESS,
      payload: course
    };
  }
}
