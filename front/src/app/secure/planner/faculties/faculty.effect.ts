import {Store} from '@ngrx/store';
import {Injectable} from '@angular/core';
import {Actions, Effect} from '@ngrx/effects';
import {FacultyActions} from './faculty.action';
import {PlannerService} from '../../../../services/planner.service';
import {PlannerModuleState} from '../index';
import {Faculty} from '../../../shared/model/planner/faculty.interface';

@Injectable()
export class FacultyEffects {

  private FACULTY: string[] = 'plannerModuleState.faculty'.split('.');

  constructor(private actions$: Actions,
              private facultyActions: FacultyActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findFaculties$ = this.actions$
    .ofType(FacultyActions.FIND_FACULTIES)
    .switchMap(() => this.plannerService.findFaculties())
    .map((faculties) => this.facultyActions.findFacultiesSuccess(faculties));

  @Effect() findFacultyByCode$ = this.actions$
    .ofType(FacultyActions.FIND_FACULTY_BY_CODE)
    .map((action) => action.payload)
    .switchMap((code) => this.plannerService.findFacultyByCode(code))
    .map((faculty) => this.facultyActions.findFacultyByCodeSuccess(faculty));

  @Effect() saveFaculty$ = this.actions$
    .ofType(FacultyActions.SAVE_FACULTY)
    .map((action) => action.payload)
    .switchMap((faculty) => this.plannerService.saveFaculty(faculty))
    .map((faculty) => this.facultyActions.saveFacultySuccess(faculty));

  @Effect() updatefaculty$ = this.actions$
    .ofType(FacultyActions.UPDATE_FACULTY)
    .map((action) => action.payload)
    .switchMap((faculty) => this.plannerService.updateFaculty(faculty))
    .map((faculty) => this.facultyActions.updateFacultySuccess(faculty))
    .withLatestFrom(this.store$.select(...this.FACULTY))
    .map((state) => state[1])
    .map((faculty: Faculty) => this.facultyActions.findFacultyByCode(faculty.code));

  @Effect() activateFaculty$ = this.actions$
    .ofType(FacultyActions.ACTIVATE_FACULTY)
    .map((action) => action.payload)
    .switchMap((faculty) => this.plannerService.activateFaculty(faculty))
    .map((message) => this.facultyActions.activateFacultySuccess(message))
    .withLatestFrom(this.store$.select(...this.FACULTY))
    .map((state) => state[1])
    .map((faculty: Faculty) => this.facultyActions.findFacultyByCode(faculty.code));

  @Effect() deactivateFaculty$ = this.actions$
    .ofType(FacultyActions.DEACTIVATE_FACULTY)
    .map((action) => action.payload)
    .switchMap((faculty) => this.plannerService.deactivateFaculty(faculty))
    .map((message) => this.facultyActions.deactivateFacultySuccess(message))
    .withLatestFrom(this.store$.select(...this.FACULTY))
    .map((state) => state[1])
    .map((faculty: Faculty) => this.facultyActions.findFacultyByCode(faculty.code));

}
