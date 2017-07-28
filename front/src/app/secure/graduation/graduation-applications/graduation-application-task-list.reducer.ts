import {Action} from '@ngrx/store';
import {GraduationApplicationTask} from '../../../shared/model/graduation/graduation-application-task.interface';
import {GraduationApplicationActions} from './graduation-application.action';

export type GraduationApplicationTaskListState = GraduationApplicationTask[];

const initialState: GraduationApplicationTaskListState = <GraduationApplicationTask[]>[];

export function assignedGraduationApplicationTaskListReducer(state = initialState, action: Action): GraduationApplicationTaskListState {
  switch (action.type) {
    case GraduationApplicationActions.FIND_ASSIGNED_GRADUATION_APPLICATION_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}

export function pooledGraduationApplicationTaskListReducer(state = initialState, action: Action): GraduationApplicationTaskListState {
  switch (action.type) {
    case GraduationApplicationActions.FIND_POOLED_GRADUATION_APPLICATION_TASKS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
