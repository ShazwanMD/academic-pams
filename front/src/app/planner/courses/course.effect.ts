import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {CourseActions} from "./course.action";
import {PlannerService} from "../../../services/planner.service";


@Injectable()
export class CourseEffects {
  constructor(private actions$: Actions,
              private courseActions: CourseActions,
              private plannerService: PlannerService,) {
  }

  @Effect() loadCourses$ = this.actions$
    .ofType(CourseActions.LOAD_COURSES)
    .switchMap(() => this.plannerService.findCourses())
    .map(courses =>
       this.courseActions.loadCoursesSuccess(courses));

  // @Effect() getCourse$ = this.actions$
  //   .ofType(CourseActions.GET_COURSE)
  //   .map<string>(action => action.payload)
  //   .switchMap(code => this.plannerService.findCourseByCode(code))
  //   .map(course => this.courseActions.getCoursesuccess(course));

  // @Effect() saveCourse$ = this.actions$
  //   .ofType(CourseActions.SAVE_COURSE)
  //   .map(action => action.payload)
  //   .switchMap(course => this.svc.saveCourse(course))
  //   .map(course => this.courseActions.saveCoursesuccess(course));
  //
  // @Effect() createCourse = this.actions$
  //   .ofType(CourseActions.CREATE_COURSE)
  //   .map(action => action.payload)
  //   .switchMap(course => this.svc.saveCourse(course))
  //   .map(course => this.courseActions.addCoursesuccess(course));
  //
  // @Effect() deleteCourse$ = this.actions$
  //   .ofType(CourseActions.DELETE_COURSE)
  //   .map(action => action.payload)
  //   .switchMap(course => this.svc.deleteCourse(course))
  //   .map(course => this.courseActions.deleteCoursesuccess(course));
}
