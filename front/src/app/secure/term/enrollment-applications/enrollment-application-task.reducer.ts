import {Action} from '@ngrx/store';
import {EnrollmentApplicationTask} from '../../../shared/model/term/enrollment-application-task.interface';
import {EnrollmentApplicationActions} from './enrollment-application.action';

export type EnrollmentApplicationTaskState = EnrollmentApplicationTask;

const initialState: EnrollmentApplicationTaskState = <EnrollmentApplicationTaskState>{};

export function enrollmentApplicationTaskReducer(state = initialState, action: Action): EnrollmentApplicationTaskState {
  switch (action.type) {
    case EnrollmentApplicationActions.FIND_ENROLLMENT_APPLICATION_TASK_BY_TASK_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
