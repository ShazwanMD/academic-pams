import {Injectable} from '@angular/core';
import {Effect, Actions} from '@ngrx/effects';
import {CohortActions} from "./cohort.action";
import {PlannerService} from "../../../services/planner.service";


@Injectable()
export class CohortEffects {
  constructor(private actions$: Actions,
              private cohortActions: CohortActions,
              private plannerService: PlannerService,) {
  }

  @Effect() findCohorts$ = this.actions$
    .ofType(CohortActions.FIND_COHORTS)
    .switchMap(() => this.plannerService.findCohorts())
    .map(cohorts => this.cohortActions.findCohortsSuccess(cohorts));

  // @Effect() getCohort$ = this.actions$
  //   .ofType(CohortActions.GET_COHORT)
  //   .map<string>(action => action.payload)
  //   .switchMap(code => this.plannerService.findCohortByCode(code))
  //   .map(cohort => this.cohortActions.getCohortsuccess(cohort));

  // @Effect() saveCohort$ = this.actions$
  //   .ofType(CohortActions.SAVE_COHORT)
  //   .map(action => action.payload)
  //   .switchMap(cohort => this.svc.saveCohort(cohort))
  //   .map(cohort => this.cohortActions.saveCohortsuccess(cohort));
  //
  // @Effect() createCohort = this.actions$
  //   .ofType(CohortActions.CREATE_COHORT)
  //   .map(action => action.payload)
  //   .switchMap(cohort => this.svc.saveCohort(cohort))
  //   .map(cohort => this.cohortActions.addCohortsuccess(cohort));
  //
  // @Effect() deleteCohort$ = this.actions$
  //   .ofType(CohortActions.DELETE_COHORT)
  //   .map(action => action.payload)
  //   .switchMap(cohort => this.svc.deleteCohort(cohort))
  //   .map(cohort => this.cohortActions.deleteCohortsuccess(cohort));
}
