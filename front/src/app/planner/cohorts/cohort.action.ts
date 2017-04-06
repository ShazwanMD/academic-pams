import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class CohortActions {

  static FIND_COHORTS = '[Cohort] Find Cohorts';
  findCohorts(): Action {
    return {
      type: CohortActions.FIND_COHORTS
    };
  }

  static FIND_COHORTS_SUCCESS = '[Cohort] Find Cohorts Success';
  findCohortsSuccess(cohorts): Action {
    return {
      type: CohortActions.FIND_COHORTS_SUCCESS,
      payload: cohorts
    };
  }

  static FIND_COHORT = '[Cohort] Find Cohort';
  findCohort(code): Action {
    return {
      type: CohortActions.FIND_COHORT,
      payload: code
    };
  }

  static FIND_COHORT_SUCCESS = '[Cohort] Find Cohort Success';
  findCohortsuccess(cohort): Action {
    return {
      type: CohortActions.FIND_COHORT_SUCCESS,
      payload: cohort
    };
  }

  static RESET_COHORT = '[Cohort] Reset Cohort';
  resetCohort(): Action {
    return {
      type: CohortActions.RESET_COHORT
    };
  }

  static SAVE_COHORT = '[Cohort] Save Cohort';
  saveCohort(cohort): Action {
    return {
      type: CohortActions.SAVE_COHORT,
      payload: cohort
    };
  }

  static SAVE_COHORT_SUCCESS = '[Cohort] Save Cohort Success';
  saveCohortSuccess(cohort): Action {
    return {
      type: CohortActions.SAVE_COHORT_SUCCESS,
      payload: cohort
    };
  }

  static CREATE_COHORT = '[Cohort] Create Cohort';
  createCohort(cohort): Action {
    return {
      type: CohortActions.CREATE_COHORT,
      payload: cohort
    };
  }

  static CREATE_COHORT_SUCCESS = '[Cohort] Create Cohort Success';
  createCohortSuccess(cohort): Action {
    return {
      type: CohortActions.CREATE_COHORT_SUCCESS,
      payload: cohort
    };
  }

  static REMOVE_COHORT = '[Cohort] Remove Cohort';
  removeCohort(cohort): Action {
    return {
      type: CohortActions.REMOVE_COHORT,
      payload: cohort
    };
  }

  static REMOVE_COHORT_SUCCESS = '[Cohort] Remove Cohort Success';
  removeCohortSuccess(cohort): Action {
    return {
      type: CohortActions.REMOVE_COHORT_SUCCESS,
      payload: cohort
    };
  }
}
