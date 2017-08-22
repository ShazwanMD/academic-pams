import {AdmissionApplication} from '../../shared/model/term/admission-application.interface';
import {Action} from '@ngrx/store';
import {ProfileActions} from './profile.action';

export type AdmissionApplicationListState = AdmissionApplication[];

const initialState: AdmissionApplicationListState = <AdmissionApplication[]>[];

export function admissionApplicationListReducer(state = initialState, action: Action): AdmissionApplicationListState {
  switch (action.type) {
    case ProfileActions.FIND_ADMISSION_APPLICATIONS_BY_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
