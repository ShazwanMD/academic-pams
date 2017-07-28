import {Action} from '@ngrx/store';

import {EnrollmentApplication} from '../../../shared/model/term/enrollment-application.interface';
import {AdmissionActions} from './admission.action';

export type AdmissionEnrollmentApplicationListState = EnrollmentApplication[];

const initialState: AdmissionEnrollmentApplicationListState = <EnrollmentApplication[]>[];

export function admissionEnrollmentApplicationListReducer(state = initialState, action: Action): AdmissionEnrollmentApplicationListState {
  switch (action.type) {
    case AdmissionActions.FIND_ENROLLMENTAPPLICATIONS_BY_ADMISSION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
