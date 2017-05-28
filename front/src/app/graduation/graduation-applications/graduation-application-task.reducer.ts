import {Action} from '@ngrx/store';
import {GraduationApplicationTask} from "./graduation-application-task.interface";
import {GraduationApplicationActions} from "./graduation-application.action";

export type GraduationApplicationTaskState = GraduationApplicationTask;

const initialState: GraduationApplicationTaskState = <GraduationApplicationTaskState>{};

export function graduationApplicationTaskReducer(state = initialState, action: Action): GraduationApplicationTaskState {
  switch (action.type) {
    case GraduationApplicationActions.FIND_GRADUATION_APPLICATION_TASK_BY_TASK_ID_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
