import {Action} from '@ngrx/store';

import {Admission} from '../../shared/model/term/admission.interface';
import {LecturerActions} from './lecturer.action';

export type AdmissionListState = Admission[];

const initialState: AdmissionListState = <Admission[]>[];

export function admissionListReducer(state = initialState, action: Action): AdmissionListState {
  switch (action.type) {
    case LecturerActions.FIND_ADMISSIONS_BY_LECTURER_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
