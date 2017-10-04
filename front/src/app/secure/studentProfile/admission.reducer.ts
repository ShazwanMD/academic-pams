import { StudentProfileActions } from './student-profile.action';
import { Admission } from './../../shared/model/term/admission.interface';
import {Action} from '@ngrx/store';

export type AdmissionState = Admission;

const initialState: AdmissionState = <Admission>{};

export function admissionReducer(state = initialState, action: Action): AdmissionState {
  switch (action.type) {
    case StudentProfileActions.FIND_ADMISSIONS_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
