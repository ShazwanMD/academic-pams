import {Action} from '@ngrx/store';

import {EnrollmentApplication} from '../../shared/model/term/enrollment-application.interface';
import {EnrollmentApplicationActions} from './enrollment-application.action';

export type EnrollmentApplicationListState = EnrollmentApplication[];

const initialState: EnrollmentApplicationListState = <EnrollmentApplication[]>[];

export function archivedEnrollmentApplicationListReducer(state = initialState, action: Action): EnrollmentApplicationListState {
    switch (action.type) {
      case EnrollmentApplicationActions.FIND_ARCHIVED_ENROLLMENT_APPLICATIONS_SUCCESS: {
        return action.payload;
      }
      default: {
        return state;
      }
    }
  }

export function enrollmentApplicationListReducer(state = initialState, action: Action): EnrollmentApplicationListState {
  switch (action.type) {
    case EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATIONS_SUCCESS: {
      return action.payload;
    }

    case EnrollmentApplicationActions.REMOVE_ENROLLMENT_APPLICATION_SUCCESS: {
      return state.filter((enrollmentApplication) => {
        return enrollmentApplication.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
