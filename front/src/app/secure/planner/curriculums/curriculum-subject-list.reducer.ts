import {Subject} from '../../../shared/model/planner/subject.interface';
import {CurriculumActions} from './curriculum.action';
import {Action} from '@ngrx/store';

export type CurriculumSubjectListState = Subject[];

const initialState: CurriculumSubjectListState = <Subject[]>[];

export function curriculumSubjectListReducer(state = initialState, action: Action): CurriculumSubjectListState {
  switch (action.type) {
    case CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
