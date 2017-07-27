import {Action} from '@ngrx/store';

import {Enrollment} from '../../shared/model/term/enrollment.interface';
import {AdmissionActions} from './admission.action';

export type AdmissionEnrollmentListState = Enrollment[];

const initialState: AdmissionEnrollmentListState = <Enrollment[]>[];

export function admissionEnrollmentListReducer(state = initialState, action: Action): AdmissionEnrollmentListState {
  switch (action.type) {
    case AdmissionActions.FIND_ENROLLMENTS_BY_ADMISSION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
