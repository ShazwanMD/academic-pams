import {Action} from '@ngrx/store';
import {SubjectActions} from "./subject.action";
import {Subject} from "../curriculums/subject.interface";

export type SubjectState = Subject;

const initialState: SubjectState = <Subject>{};

export function subjectReducer(state = initialState, action: Action): SubjectState {
  switch (action.type) {
    case SubjectActions.FIND_SUBJECT_BY_ID_SUCCESS: {
      return action.payload;
    }
  
     case SubjectActions.FIND_SUBJECT_BY_ID_SUCCESS:{
          return action.payload;
     }

    default: {
      return state;
    }
  }
}
