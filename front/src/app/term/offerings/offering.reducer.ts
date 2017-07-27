import {Action} from '@ngrx/store';
import {OfferingActions} from './offering.action';
import {Offering} from '../../shared/model/term/offering.interface';

export type OfferingState = Offering;

const initialState: OfferingState = <Offering>{};

export function offeringReducer(state = initialState, action: Action): OfferingState {
  switch (action.type) {
    case OfferingActions.FIND_OFFERING_BY_CANONICAL_CODE_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
