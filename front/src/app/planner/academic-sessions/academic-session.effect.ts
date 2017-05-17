import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AcademicSessionActions} from "./academic-session.action";
import {PlannerService} from "../../../services/planner.service";


@Injectable()
export class AcademicSessionEffects {
  constructor(private actions$: Actions,
              private academicSessionActions: AcademicSessionActions,
              private plannerService: PlannerService,) {
  }

  @Effect() findAcademicSessions$ = this.actions$
    .ofType(AcademicSessionActions.FIND_ACADEMIC_SESSIONS)
    .switchMap(() => this.plannerService.findAcademicSessions())
    .map(academicSessions => this.academicSessionActions.findAcademicSessionsSuccess(academicSessions));


  @Effect() findAcademicSessionByCode$ = this.actions$
    .ofType(AcademicSessionActions.FIND_ACADEMIC_SESSION_BY_CODE)
    .map(action => action.payload)
    .switchMap(code => this.plannerService.findAcademicSessionByCode(code))
    .map(academicSession => this.academicSessionActions.findAcademicSessionByCodeSuccess(academicSession));

 @Effect() deactivateAcademicSession$ = this.actions$
    .ofType(AcademicSessionActions.DEACTIVATE_ACADEMIC_SESSION)
    .map(action => action.payload)
    .switchMap(academicSession => this.plannerService.deactivateAcademicSession(academicSession))
    .map(message => this.academicSessionActions.deactivateAcademicSessionSuccess(message));

 @Effect() activateAcademicSession$ = this.actions$
    .ofType(AcademicSessionActions.ACTIVATE_ACADEMIC_SESSION)
    .map(action => action.payload)
    .switchMap(academicSession => this.plannerService.activateAcademicSession(academicSession))
    .map(message => this.academicSessionActions.activateAcademicSessionSuccess(message));



}
