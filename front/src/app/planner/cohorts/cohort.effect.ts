import { Injectable } from '@angular/core';
import { Effect, Actions } from '@ngrx/effects';
import { CohortActions } from "./cohort.action";
import { PlannerService } from "../../../services/planner.service";


@Injectable()
export class CohortEffects {
    constructor( private actions$: Actions,
        private cohortActions: CohortActions,
        private plannerService: PlannerService, ) {
    }

    @Effect() findCohorts$ = this.actions$
        .ofType( CohortActions.FIND_COHORTS )
        .switchMap(() => this.plannerService.findCohorts() )
        .map( cohorts => this.cohortActions.findCohortsSuccess( cohorts ) );

    @Effect() findCohortByCode$ = this.actions$
        .ofType( CohortActions.FIND_COHORT_BY_CODE )
        .map( action => action.payload )
        .switchMap( code => this.plannerService.findCohortByCode( code ) )
        .map( cohort => this.cohortActions.findCohortByCodeSuccess( cohort ) );
}
