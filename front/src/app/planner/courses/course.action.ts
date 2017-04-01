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

  static FIND_COURSE = '[Course] Find Course';
  findCourse(code): Action {
    return {
      type: CourseActions.FIND_COURSE,
      payload: code
    };
  }

  static FIND_COURSE_SUCCESS = '[Course] Find Course Success';
  findCoursesuccess(course): Action {
    return {
      type: CourseActions.FIND_COURSE_SUCCESS,
      payload: course
    };
  }

  static RESET_COURSE = '[Course] Reset Course';
  resetCourse(): Action {
    return {
      type: CourseActions.RESET_COURSE
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

  static CREATE_COURSE = '[Course] Create Course';
  createCourse(course): Action {
    return {
      type: CourseActions.CREATE_COURSE,
      payload: course
    };
  }

  static CREATE_COURSE_SUCCESS = '[Course] Create Course Success';
  createCourseSuccess(course): Action {
    return {
      type: CourseActions.CREATE_COURSE_SUCCESS,
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
