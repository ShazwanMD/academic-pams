import {Action} from '@ngrx/store';
import {OfferingActions} from "./offering.action";
import {Offering} from "./offering.interface";

export type OfferingState = Offering;

const initialState: OfferingState = <Offering>{};

export function offeringReducer(state = initialState, action: Action): OfferingState {
  console.log("action: " + action);
  switch (action.type) {
    case OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
