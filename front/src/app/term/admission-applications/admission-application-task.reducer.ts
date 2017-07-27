import {Action} from '@ngrx/store';
import {AdmissionApplicationTask} from '../../shared/model/term/admission-application-task.interface';
import {AdmissionApplicationActions} from './admission-application.action';

export type AdmissionApplicationTaskState = AdmissionApplicationTask;

const initialState: AdmissionApplicationTaskState = <AdmissionApplicationTaskState>{};

export function admissionApplicationTaskReducer(state = initialState, action: Action): AdmissionApplicationTaskState {
  switch (action.type) {
    case AdmissionApplicationActions.FIND_ADMISSION_APPLICATION_TASK_BY_TASK_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
