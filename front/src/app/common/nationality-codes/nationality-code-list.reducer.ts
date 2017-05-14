import { NationalityCode } from './nationality-code.interface';
import {Action} from '@ngrx/store';
import {CommonActions} from "./../gender-codes/common.action";

export type NationalityCodeListState = NationalityCode[];

const initialState: NationalityCodeListState = <NationalityCode[]>[];

export function nationalityCodeListReducer(state = initialState, action: Action): NationalityCodeListState {
  switch (action.type) {
    case CommonActions.FIND_NATIONALITY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}