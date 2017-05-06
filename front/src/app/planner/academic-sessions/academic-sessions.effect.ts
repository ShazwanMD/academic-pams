import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AcademicSessionActions} from "./academic-session.action";
import {PlannerService} from "../../../services/planner.service";


@Injectable()
export class AcademicSessionEffects {
  constructor(private actions$: Actions,
              private actions: AcademicSessionActions,
              private plannerService: PlannerService,) {
  }

  @Effect() findAcademicSessions$ = this.actions$
    .ofType(AcademicSessionActions.FIND_ACADEMIC_SESSIONS)
    .switchMap(() => this.plannerService.findAcademicSessions())
    .map(academicSessions => this.actions.findAcademicSessionsSuccess(academicSessions));
}

