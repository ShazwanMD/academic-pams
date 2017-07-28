import {Action} from '@ngrx/store';
import {AdmissionApplicationActions} from './admission-application.action';
import {AdmissionApplication} from '../../../shared/model/term/admission-application.interface';

export type AdmissionApplicationListState = AdmissionApplication[];

const initialState: AdmissionApplicationListState = <AdmissionApplication[]>[];

export function archivedAdmissionApplicationListReducer(state = initialState, action: Action): AdmissionApplicationListState {
  switch (action.type) {
    case AdmissionApplicationActions.FIND_ARCHIVED_ADMISSION_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function admissionApplicationListReducer(state = initialState, action: Action): AdmissionApplicationListState {
  switch (action.type) {
    case AdmissionApplicationActions.FIND_ADMISSION_APPLICATIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
