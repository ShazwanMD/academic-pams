import {AcademicSession} from '../../shared/model/planner/academic-session.interface';
import {Action} from '@ngrx/store';
import {ProfileActions} from './profile.action';

export type AcademicSessionListState = AcademicSession[];

const initialState: AcademicSessionListState = <AcademicSession[]>[];

export function academicSessionListReducer(state = initialState, action: Action): AcademicSessionListState {
  switch (action.type) {
    /*case ProfileActions.FIND_ACADEMIC_SESSIONS_BY_STUDENT_SUCCESS: {
      return action.payload;
    }*/
    default: {
      return state;
    }
  }
}
