import {Action} from '@ngrx/store';

import {Section} from "../sections/section.interface";
import {OfferingActions} from "./offering.action";

export type OfferingSectionListState = Section[];

const initialState: OfferingSectionListState = <Section[]>[];

export function offeringSectionListReducer(state = initialState, action: Action): OfferingSectionListState {
  switch (action.type) {
    case OfferingActions.FIND_SECTIONS_BY_OFFERING_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
