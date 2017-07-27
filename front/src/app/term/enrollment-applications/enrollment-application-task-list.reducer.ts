import {Action} from '@ngrx/store';
import {EnrollmentApplicationTask} from '../../shared/model/term/enrollment-application-task.interface';
import {EnrollmentApplicationActions} from './enrollment-application.action';

export type EnrollmentApplicationTaskListState = EnrollmentApplicationTask[];

const initialState: EnrollmentApplicationTaskListState = <EnrollmentApplicationTask[]>[];

export function assignedEnrollmentApplicationTaskListReducer(state = initialState, action: Action): EnrollmentApplicationTaskListState {
  switch (action.type) {
    case EnrollmentApplicationActions.FIND_ASSIGNED_ENROLLMENT_APPLICATION_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function pooledEnrollmentApplicationTaskListReducer(state = initialState, action: Action): EnrollmentApplicationTaskListState {
  switch (action.type) {
    case EnrollmentApplicationActions.FIND_POOLED_ENROLLMENT_APPLICATION_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
