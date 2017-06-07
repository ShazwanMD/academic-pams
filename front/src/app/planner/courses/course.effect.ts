import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {CourseActions} from "./course.action";
import {PlannerService} from "../../../services/planner.service";
import {Store} from "@ngrx/store";
import {PlannerModuleState} from "../index";
import {Course} from './course.interface';
@Injectable()
export class CourseEffects {

   private COURSE: string[] = "plannerModuleState.course".split(".");

  constructor(private actions$: Actions,
              private courseActions: CourseActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findCourses$ = this.actions$
    .ofType(CourseActions.FIND_COURSES)
    .switchMap(() => this.plannerService.findCourses())
    .map(courses => this.courseActions.findCoursesSuccess(courses));

  @Effect() findCourseByCode$ = this.actions$
    .ofType(CourseActions.FIND_COURSE_BY_CODE)
    .map(action => action.payload)
    .switchMap(code => this.plannerService.findCourseByCode(code))
    .map(course => this.courseActions.findCourseByCodeSuccess(course));

 @Effect() saveCourse$ = this.actions$
    .ofType(CourseActions.SAVE_COURSE)
    .map(action => action.payload)
    .switchMap(course => this.plannerService.saveCourse(course))
    .map(course => this.courseActions.saveCourseSuccess(course))
     .withLatestFrom(this.store$.select(...this.COURSE))
    .map(state => state[1])
   .map((course: Course) => this.courseActions.findCourseByCode(course.code));
    

  @Effect() updateCourse$ = this.actions$
    .ofType(CourseActions.UPDATE_COURSE)
    .map(action => action.payload)
    .switchMap(course => this.plannerService.updateCourse(course))
    .map(course => this.courseActions.updateCourseSuccess(course))
    .withLatestFrom(this.store$.select(...this.COURSE))
    .map(state => state[1])
    .map((course: Course) => this.courseActions.findCourseByCode(course.code));

  @Effect() activateCourse$ = this.actions$
    .ofType(CourseActions.ACTIVATE_COURSE)
    .map(action => action.payload)
    .switchMap(course => this.plannerService.activateCourse(course))
    .map(message => this.courseActions.activateCourseSuccess(message))
    .withLatestFrom(this.store$.select(...this.COURSE))
    .map(state => state[1])
    .map((course: Course) => this.courseActions.findCourseByCode(course.code));


  @Effect() deactivateCourse$ = this.actions$
    .ofType(CourseActions.DEACTIVATE_COURSE)
    .map(action => action.payload)
    .switchMap(course => this.plannerService.deactivateCourse(course))
    .map(message => this.courseActions.deactivateCourseSuccess(message))
    .withLatestFrom(this.store$.select(...this.COURSE))
    .map(state => state[1])
    .map((course: Course) => this.courseActions.findCourseByCode(course.code));
}
