import {GradeCode} from '../../shared/model/common/grade-code.interface';
import {CommonActions} from '../common.action';
import {Action} from '@ngrx/store';

export type GradeCodeListState = GradeCode[];

const initialState: GradeCodeListState = <GradeCode[]>[];

export function gradeCodeListReducer(state = initialState,
                                     action: Action): GradeCodeListState {
  switch (action.type) {
    case CommonActions.FIND_GRADE_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
