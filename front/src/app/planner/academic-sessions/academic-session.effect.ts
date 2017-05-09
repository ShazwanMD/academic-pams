import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {AcademicSessionActions} from "./academic-session.action";
import {PlannerService} from "../../../services/planner.service";


@Injectable()
export class AcademicSessionEffects {
    constructor (private actions$ : Actions,
                    private sessionActions: AcademicSessionActions,
                    private plannerService: PlannerService,) {
                    }

@Effect() findSessions$ = this.actions$
                .ofType(AcademicSessionActions.FIND_SESSIONS)
                .switchMap(() => this.plannerService.findSessions())
                .map(sessions => this.sessionActions.findSessionsSuccess(sessions));



}