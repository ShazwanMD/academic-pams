import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AcademicSessionActions} from "./academic-session.action";
import {PlannerService} from "../../../services/planner.service";
import {Store} from "@ngrx/store";
import {Observable} from "rxjs";
import {PlannerModuleState} from "../index";
import {AcademicSession} from "./academic-session.interface";

@Injectable()
export class AcademicSessionEffects {

  private ACADEMIC_SESSION: string[] = "plannerModuleState.academicSession".split(".");

  constructor(private actions$: Actions,
              private academicSessionActions: AcademicSessionActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
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
    
  @Effect() activateAcademicSession$ = this.actions$
    .ofType(AcademicSessionActions.ACTIVATE_ACADEMIC_SESSION)
    .map(action => action.payload)
    .switchMap(academicSession => this.plannerService.activateAcademicSession(academicSession))
    .map(message => this.academicSessionActions.activateAcademicSessionSuccess(message))
    .withLatestFrom(this.store$.select(...this.ACADEMIC_SESSION))
    .map(state => state[1])
    .map((academicSession: AcademicSession) => this.academicSessionActions.findAcademicSessionByCode(academicSession.code));


  @Effect() deactivateAcademicSession$ = this.actions$
    .ofType(AcademicSessionActions.DEACTIVATE_ACADEMIC_SESSION)
    .map(action => action.payload)
    .switchMap(academicSession => this.plannerService.deactivateAcademicSession(academicSession))
    .map(message => this.academicSessionActions.deactivateAcademicSessionSuccess(message))
    .withLatestFrom(this.store$.select(...this.ACADEMIC_SESSION))
    .map(state => state[1])
    .map((academicSession: AcademicSession) => this.academicSessionActions.findAcademicSessionByCode(academicSession.code));

  @Effect() saveAcademicSession$ = this.actions$
    .ofType(AcademicSessionActions.SAVE_ACADEMIC_SESSION)
    .map(action => action.payload)
    .switchMap(academicSession => this.plannerService.saveAcademicSession(academicSession))
    .map(academicSession => this.academicSessionActions.saveAcademicSessionSuccess(academicSession))
    .withLatestFrom(this.store$.select(...this.ACADEMIC_SESSION))
    .map(state => state[1])
   .map((academicSession: AcademicSession) => this.academicSessionActions.findAcademicSessionByCode(academicSession.code));

  @Effect() updateAcademicSession$ = this.actions$
    .ofType(AcademicSessionActions.UPDATE_ACADEMIC_SESSION)
    .map(action => action.payload)
    .switchMap(academicSession => this.plannerService.updateAcademicSession(academicSession))
    .map(academicSession => this.academicSessionActions.updateAcademisSessionSuccess(academicSession))
    .withLatestFrom(this.store$.select(...this.ACADEMIC_SESSION))
    .map(state => state[1])
    .map((academicSession: AcademicSession) => this.academicSessionActions.findAcademicSessionByCode(academicSession.code));

}
