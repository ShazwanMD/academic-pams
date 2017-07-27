import {DunCode} from '../../shared/model/common/dun-code.interface';
import {CommonActions} from '../common.action';
import {Action} from '@ngrx/store';

export type DunCodeListState = DunCode[];

const initialState: DunCodeListState = <DunCode[]>[];

export function dunCodeListReducer(state = initialState,
                                   action: Action): DunCodeListState {
  switch (action.type) {
    case CommonActions.FIND_DUN_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
