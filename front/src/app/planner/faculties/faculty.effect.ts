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

  @Effect() loadFaculties$ = this.actions$
    .ofType(FacultyActions.LOAD_FACULTIES)
    .switchMap(() => this.plannerService.findFaculties())
    .map(faculties =>
       this.facultyActions.loadFacultiesSuccess(faculties));

  // @Effect() getFaculty$ = this.actions$
  //   .ofType(FacultyActions.GET_FACULTY)
  //   .map<string>(action => action.payload)
  //   .switchMap(code => this.plannerService.findFacultyByCode(code))
  //   .map(faculty => this.facultyActions.getFacultiesuccess(faculty));

  // @Effect() saveFaculty$ = this.actions$
  //   .ofType(FacultyActions.SAVE_FACULTY)
  //   .map(action => action.payload)
  //   .switchMap(faculty => this.svc.saveFaculty(faculty))
  //   .map(faculty => this.facultyActions.saveFacultiesuccess(faculty));
  //
  // @Effect() createFaculty = this.actions$
  //   .ofType(FacultyActions.CREATE_FACULTY)
  //   .map(action => action.payload)
  //   .switchMap(faculty => this.svc.saveFaculty(faculty))
  //   .map(faculty => this.facultyActions.addFacultiesuccess(faculty));
  //
  // @Effect() deleteFaculty$ = this.actions$
  //   .ofType(FacultyActions.DELETE_FACULTY)
  //   .map(action => action.payload)
  //   .switchMap(faculty => this.svc.deleteFaculty(faculty))
  //   .map(faculty => this.facultyActions.deleteFacultiesuccess(faculty));
}
