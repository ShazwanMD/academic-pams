import {Action} from '@ngrx/store';
import {AdmissionActions} from './admission.action';
import {Admission} from '../../../shared/model/term/admission.interface';

export type AdmissionState = Admission;

const initialState: AdmissionState = <Admission>{};

export function admissionReducer(state = initialState, action: Action): AdmissionState {
  switch (action.type) {
    case AdmissionActions.FIND_ADMISSION_BY_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
