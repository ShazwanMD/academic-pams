import {Action} from '@ngrx/store';
import {GenderCode} from "./gender-code.interface";
import {CommonActions} from "../common.action";

export type GenderCodeListState = GenderCode[];

const initialState: GenderCodeListState = <GenderCode[]>[];

export function genderCodeListReducer(state = initialState, action: Action): GenderCodeListState {
  switch (action.type) {
    case CommonActions.FIND_GENDER_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}