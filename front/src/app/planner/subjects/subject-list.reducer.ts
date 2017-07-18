import {SubjectActions} from './subject.action';
import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Subject} from "../curriculums/subject.interface";


export type SubjectListState = Subject[];

const initialState: SubjectListState = <Subject[]>[];

export function subjectListReducer(state = initialState, action: Action): SubjectListState  {
  switch (action.type) {
    case SubjectActions.FIND_SUBJECTS_SUCCESS: {
      return action.payload;
    }
    case SubjectActions.ADD_SUBJECT_SUCCESS: {
      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1)
        ];
      }
      return state;
    }
    case SubjectActions.UPDATE_SUBJECT_SUCCESS: {
      return state.filter(subject => {
        return subject.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
