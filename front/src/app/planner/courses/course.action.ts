import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class CourseActions {

  static LOAD_COURSES = '[Course] Load Courses';
  loadCourses(): Action {
    return {
      type: CourseActions.LOAD_COURSES
    };
  }

  static LOAD_COURSES_SUCCESS = '[Course] Load Courses Success';
  loadCoursesSuccess(courses): Action {
    return {
      type: CourseActions.LOAD_COURSES_SUCCESS,
      payload: courses
    };
  }

  static GET_COURSE = '[Course] Get Course';
  getCourse(code): Action {
    return {
      type: CourseActions.GET_COURSE,
      payload: code
    };
  }

  static GET_COURSE_SUCCESS = '[Course] Get Course Success';
  getCoursesuccess(course): Action {
    return {
      type: CourseActions.GET_COURSE_SUCCESS,
      payload: course
    };
  }

  static RESET_BLANK_COURSE = '[Course] Reset Blank Course';
  resetBlankCourse(): Action {
    return {
      type: CourseActions.RESET_BLANK_COURSE
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
  saveCoursesuccess(course): Action {
    return {
      type: CourseActions.SAVE_COURSE_SUCCESS,
      payload: course
    };
  }

  static CREATE_COURSE = '[Course] Create Course';
  addCourse(course): Action {
    return {
      type: CourseActions.CREATE_COURSE,
      payload: course
    };
  }

  static CREATE_COURSE_SUCCESS = '[Course] Create Course Success';
  addCoursesuccess(course): Action {
    return {
      type: CourseActions.CREATE_COURSE_SUCCESS,
      payload: course
    };
  }

  static DELETE_COURSE = '[Course] Delete Course';
  deleteCourse(course): Action {
    return {
      type: CourseActions.DELETE_COURSE,
      payload: course
    };
  }

  static DELETE_COURSE_SUCCESS = '[Course] Delete Course Success';
  deleteCoursesuccess(course): Action {
    return {
      type: CourseActions.DELETE_COURSE_SUCCESS,
      payload: course
    };
  }
}
