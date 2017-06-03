import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {Section} from "./section.interface";
import {SectionActions} from "./section.action";

export type SectionListState = Section[];

const initialState: SectionListState = <Section[]>[];

export function sectionListReducer(state = initialState, action: Action): SectionListState {
  switch (action.type) {
    case SectionActions.FIND_SECTIONS_SUCCESS: {
      return action.payload;
    }
    case SectionActions.SAVE_SECTION_SUCCESS: {
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
    case SectionActions.REMOVE_SECTION_SUCCESS: {
      return state.filter(section => {
        return section.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
