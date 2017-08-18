import {Admission} from '../../shared/model/term/admission.interface';
import {Action} from '@ngrx/store';
import {ProfileActions} from './profile.action';

export type AdmissionListState = Admission[];

const initialState: AdmissionListState = <Admission[]>[];

export function admissionListReducer(state = initialState, action: Action): AdmissionListState {
  switch (action.type) {
    case ProfileActions.FIND_ADMISSIONS_BY_STUDENT_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
