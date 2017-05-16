import { Action } from '@ngrx/store';

import { Section } from "../sections/section.interface";
import {OfferingActions} from "./offering.action";

export type SectionListState = Section[];

const initialState: SectionListState = <Section[]>[];

export function sectionListReducer(state = initialState, action: Action): SectionListState {
  switch (action.type) {
    case OfferingActions.FIND_SECTIONS_BY_OFFERING_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
