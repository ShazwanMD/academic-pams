import {CurriculumActions} from './curriculum.action';
import {Action} from '@ngrx/store';
import {SingleSubject} from '../../../shared/model/planner/single-subject.interface';

export type CurriculumSingleSubjectListState = SingleSubject[];

const initialState: CurriculumSingleSubjectListState = <SingleSubject[]>[];

export function curriculumSingleSubjectListReducer(state = initialState, action: Action): CurriculumSingleSubjectListState {
  switch (action.type) {
    case CurriculumActions.FIND_SUBJECTS_BY_CURRICULUM_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
