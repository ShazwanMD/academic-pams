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

   //  @Effect() findCohort$ = this.action$
   // .ofType(CohortActions.FIND_COHORTS)
    //.map(action => action.payload)
   // .switchMap(code => this.plannerService.findCohortByCode(code))
  //  .map(cohort => this.CohortActions.getCohortSuccess(cohort));

  //@Effect() saveCohorts$ = this.actions$
    //.ofType(CohortActions.SAVE_COHORTS)
    //.map(action => action.payload)
    //.switchMap(cohort => this.plannerService.saveCohort(cohort))
   // .map(() => this.cohortActions.findCohorts())
    //.map(cohort => this.CohortsActions.saveCohortsSuccess(cohort));
   // .map(() => this.CohortActions.findCohorts())

 // @Effect() updateCohort$ = this.actions$
   // .ofType(CohortActions.UPDATE_COHORTS)
    //.map(action => action.payload)
   // .switchMap(cohort => this.plannerService.updateCohort(cohort))
  //  .map(cohort => this.cohortActions.updatecohortSuccess(cohort));


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
