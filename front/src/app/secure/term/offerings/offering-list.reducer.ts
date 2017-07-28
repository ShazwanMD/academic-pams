import {Action} from '@ngrx/store';

import * as _ from 'lodash';
import {Offering} from '../../../shared/model/term/offering.interface';
import {OfferingActions} from './offering.action';

export type OfferingListState = Offering[];

const initialState: OfferingListState = <Offering[]>[];

export function offeringListReducer(state = initialState, action: Action): OfferingListState {
  switch (action.type) {
    case OfferingActions.FIND_OFFERINGS_SUCCESS: {
      return action.payload;
    }
    case OfferingActions.SAVE_OFFERING_SUCCESS: {

      let index = _.findIndex(state, {id: action.payload.id});
      if (index >= 0) {
        return [
          ...state.slice(0, index),
          action.payload,
          ...state.slice(index + 1),
        ];
      }
      return state;
    }
    case OfferingActions.REMOVE_OFFERING_SUCCESS: {
      return state.filter((offering) => {
        return offering.id !== action.payload.id;
      });
    }
    default: {
      return state;
    }
  }
}
