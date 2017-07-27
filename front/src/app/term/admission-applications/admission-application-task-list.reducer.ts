import { Action } from '@ngrx/store';
import { AdmissionApplicationActions } from './admission-application.action';
import { AdmissionApplicationTask } from '../../shared/model/term/admission-application-task.interface';

export type AdmissionApplicationTaskListState = AdmissionApplicationTask[];

const initialState: AdmissionApplicationTaskListState = <AdmissionApplicationTask[]>[];

export function assignedAdmissionApplicationTaskListReducer(state = initialState, action: Action): AdmissionApplicationTaskListState {
  switch (action.type) {
    case  AdmissionApplicationActions.FIND_ASSIGNED_ADMISSION_APPLICATION_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function pooledAdmissionApplicationTaskListReducer(state = initialState, action: Action): AdmissionApplicationTaskListState {
  switch (action.type) {
    case AdmissionApplicationActions.FIND_POOLED_ADMISSION_APPLICATION_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
