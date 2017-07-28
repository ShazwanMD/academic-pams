import {Action} from '@ngrx/store';
import {Admission} from '../../../shared/model/term/admission.interface';
import {AdmissionActions} from './admission.action';

export type AdmissionListState = Admission[];

const initialState: AdmissionListState = <Admission[]>[];

export function admissionListReducer(state = initialState, action: Action): AdmissionListState {
  switch (action.type) {
    case AdmissionActions.FIND_ADMISSIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
