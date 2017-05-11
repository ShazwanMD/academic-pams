import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {FacultyActions} from "./faculty.action";
import {PlannerService} from "../../../services/planner.service";


@Injectable()
export class FacultyEffects {
  constructor(private actions$: Actions,
              private facultyActions: FacultyActions,
              private plannerService: PlannerService,) {
  }

  @Effect() findFaculties$ = this.actions$
    .ofType(FacultyActions.FIND_FACULTIES)
    .switchMap(() => this.plannerService.findFaculties())
    .map(faculties => this.facultyActions.findFacultiesSuccess(faculties));

  @Effect() findFacultyByCode$ = this.actions$
    .ofType(FacultyActions.FIND_FACULTY_BY_CODE)
    .map(action => action.payload)
    .switchMap(code => this.plannerService.findFacultyByCode(code))
    .map(faculty => this.facultyActions.findFacultyByCodeSuccess(faculty));

  // @Effect() saveFaculty$ = this.actions$
  //   .ofType(FacultyActions.SAVE_FACULTY)
  //   .map(action => action.payload)
  //   .switchMap(faculty => this.svc.saveFaculty(faculty))
  //   .map(faculty => this.facultyActions.saveFacultiesuccess(faculty));
  //
  // @Effect() deleteFaculty$ = this.actions$
  //   .ofType(FacultyActions.DELETE_FACULTY)
  //   .map(action => action.payload)
  //   .switchMap(faculty => this.svc.deleteFaculty(faculty))
  //   .map(faculty => this.facultyActions.deleteFacultiesuccess(faculty));
}
