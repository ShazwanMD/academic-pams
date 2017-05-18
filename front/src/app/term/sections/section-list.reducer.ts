import {Action} from '@ngrx/store';

import {Section} from "./section.interface";
import {SectionActions} from "./section.action";

export type SectionListState = Section[];

const initialState: SectionListState = <Section[]>[];

export function sectionListReducer(state = initialState, action: Action): SectionListState {
  switch (action.type) {
    case SectionActions.FIND_SECTIONS_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
