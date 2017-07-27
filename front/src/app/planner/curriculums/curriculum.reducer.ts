import {Action} from '@ngrx/store';
import {CurriculumActions} from "./curriculum.action";
import {Curriculum} from "../../shared/model/planner/curriculum.interface";

export type CurriculumState = Curriculum;

const initialState: CurriculumState = <Curriculum>{};

export function curriculumReducer(state = initialState, action: Action): CurriculumState {
  switch (action.type) {
    case CurriculumActions.FIND_CURRICULUM_BY_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
