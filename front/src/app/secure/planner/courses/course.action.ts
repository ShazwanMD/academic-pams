import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';

@Injectable()
export class CourseActions {

    static FIND_COURSES = '[Course] Find Courses';

    findCourses(): Action {
        return {
            type: CourseActions.FIND_COURSES
        };
    }

    static FIND_COURSES_SUCCESS = '[Course] Find Courses Success';

    findCoursesSuccess( courses ): Action {
        console.log( "findCoursesSuccess" );
        console.log( "courses: " + courses.length );
        return {
            type: CourseActions.FIND_COURSES_SUCCESS,
            payload: courses
        };
    }

    static FIND_COURSE_BY_CODE = '[Course] Find Course';

    findCourseByCode( code ): Action {
        return {
            type: CourseActions.FIND_COURSE_BY_CODE,
            payload: code
        };
    }

    static FIND_COURSE_BY_CODE_SUCCESS = '[Course] Find Course Success';

    findCourseByCodeSuccess( course ): Action {
        return {
            type: CourseActions.FIND_COURSE_BY_CODE_SUCCESS,
            payload: course
        };
    }

    static ADD_COURSE = '[Course] Add Course';

    addCourse( course ): Action {
        return {
            type: CourseActions.ADD_COURSE,
            payload: course
        };
    }

    static ADD_COURSE_SUCCESS = '[Course] Add Course Success';

    addCourseSuccess( course ): Action {
        console.log( "addCourseSuccess" );
        return {
            type: CourseActions.ADD_COURSE_SUCCESS,
            payload: course
        };
    }


   static UPDATE_COURSE = '[Course] Update course';

    updateCourse( course ): Action {
        return {
            type: CourseActions.UPDATE_COURSE,
            payload: course
        };
    }

    static UPDATE_COURSE_SUCCESS = '[Course] Update Course Success';

    updateCourseSuccess( course ): Action {
        return {
            type: CourseActions.UPDATE_COURSE_SUCCESS,
            payload: course
        };
    }

    static CREATE_COURSE = '[Course] Create Course';

    createCourse( course ): Action {
        return {
            type: CourseActions.CREATE_COURSE,
            payload: course
        };
    }

    static CREATE_COURSE_SUCCESS = '[Course] Create Course Success';

    createCourseSuccess( course ): Action {
        return {
            type: CourseActions.CREATE_COURSE_SUCCESS,
            payload: course
        };
    }

    static REMOVE_COURSE = '[Course] Remove Course';

    removeCourse( course ): Action {
        return {
            type: CourseActions.REMOVE_COURSE,
            payload: course
        };
    }

    static REMOVE_COURSE_SUCCESS = '[Course] Remove Course Success';

    removeCourseSuccess( course ): Action {
        return {
            type: CourseActions.REMOVE_COURSE_SUCCESS,
            payload: course
        };
    }

    static ACTIVATE_COURSE = '[Course] Activate Course';

    activateCourse( course ): Action {
        return {
            type: CourseActions.ACTIVATE_COURSE,
            payload: course
        };
    }

    static ACTIVATE_COURSE_SUCCESS = '[Course] Activate Course Success';

    activateCourseSuccess( course ): Action {
        return {
            type: CourseActions.ACTIVATE_COURSE_SUCCESS,
            payload: course
        };
    }

    //deactivate course 19/6/17
    static DEACTIVATE_COURSE = '[Course] Deactivate Course';

    deactivateCourse( course ): Action {
        return {
            type: CourseActions.DEACTIVATE_COURSE,
            payload: course
        };
    }

    static DEACTIVATE_COURSE_SUCCESS = '[Course] Activate Course Success';

    deactivateCourseSuccess( course ): Action {
        return {
            type: CourseActions.DEACTIVATE_COURSE_SUCCESS,
            payload: course
        };
    }
}
