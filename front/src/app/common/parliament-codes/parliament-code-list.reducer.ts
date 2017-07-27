import {ParliamentCode} from '../../shared/model/common/parliament-code.interface';
import {CommonActions} from '../common.action';
import {Action} from '@ngrx/store';

export type ParliamentCodeListState = ParliamentCode[];

const initialState: ParliamentCodeListState = <ParliamentCode[]>[];

export function parliamentCodeListReducer(state = initialState,
                                          action: Action): ParliamentCodeListState {
  switch (action.type) {
    case CommonActions.FIND_PARLIAMENT_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
