import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {CohortActions} from "./cohort.action";
import {PlannerService} from "../../../services/planner.service";
import {Cohort} from "./cohort.interface";
//import {PlannerModuleState} from "../index";
import {Store} from "@ngrx/store";
import { PlannerModuleState } from './../index';


@Injectable()
export class CohortEffects {

  private COHORT: string[] = "plannerModuleState.cohort".split(".");

  constructor(private actions$: Actions,
              private cohortActions: CohortActions,
              private plannerService: PlannerService,
              private store$: Store<PlannerModuleState>) {
  }

  @Effect() findCohorts$ = this.actions$
    .ofType(CohortActions.FIND_COHORTS)
    .switchMap(() => this.plannerService.findCohorts())
    .map(cohorts => this.cohortActions.findCohortsSuccess(cohorts));

  @Effect() findCohortByCode$ = this.actions$
    .ofType(CohortActions.FIND_COHORT_BY_CODE)
    .map(action => action.payload)
    .switchMap(code => this.plannerService.findCohortByCode(code))
    .map(cohort => this.cohortActions.findCohortByCodeSuccess(cohort));

  @Effect() saveCohort$ = this.actions$
    .ofType(CohortActions.SAVE_COHORT)
    .map(action => action.payload)
    .switchMap(cohort => this.plannerService.saveCohort(cohort))
    .map(cohort => this.cohortActions.saveCohortSuccess(cohort));

  @Effect() updateCohort$ = this.actions$
    .ofType(CohortActions.UPDATE_COHORT)
    .map(action => action.payload)
    .switchMap(cohort => this.plannerService.updateCohort(cohort))
    .map(message => this.cohortActions.updateCohortSuccess(message))
    .withLatestFrom(this.store$.select(...this.COHORT))
    .map(state => state[1])
    .map((cohort: Cohort) => this.cohortActions.findCohortByCode(cohort.code));
  
  @Effect() activateCohort$ = this.actions$
    .ofType(CohortActions.ACTIVATE_COHORT)
    .map(action => action.payload)
    .switchMap(cohort => this.plannerService.activateCohort(cohort))
    .map(message => this.cohortActions.activateCohortSuccess(message))
    .withLatestFrom(this.store$.select(...this.COHORT))
    .map(state => state[1])
    .map((cohort: Cohort) => this.cohortActions.findCohortByCode(cohort.code));


  @Effect() deactivateCohort$ = this.actions$
    .ofType(CohortActions.DEACTIVATE_COHORT)
    .map(action => action.payload)
    .switchMap(cohort => this.plannerService.deactivateCohort(cohort))
    .map(message => this.cohortActions.deactivateCohortSuccess(message))
    .withLatestFrom(this.store$.select(...this.COHORT))
    .map(state => state[1])
    .map((cohort: Cohort) => this.cohortActions.findCohortByCode(cohort.code));
}
