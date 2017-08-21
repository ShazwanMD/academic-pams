import {Action} from '@ngrx/store';

import {AdmissionApplication} from '../../shared/model/term/admission-application.interface';
import {LecturerActions} from './lecturer.action';

export type AdmissionApplicationListState = AdmissionApplication[];

const initialState: AdmissionApplicationListState = <AdmissionApplication[]>[];

export function admissionApplicationListReducer(state = initialState, action: Action): AdmissionApplicationListState {
  switch (action.type) {
    case LecturerActions.FIND_ADMISSION_APPLICATIONS_BY_LECTURER_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
