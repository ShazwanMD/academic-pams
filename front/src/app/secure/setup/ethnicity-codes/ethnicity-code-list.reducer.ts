import { EthnicityCode } from '../../../shared/model/common/ethnicity-code.interface';
import {SetupActions} from '../setup.action';
import {Action} from '@ngrx/store';


export type EthnicityCodeListState = EthnicityCode[];

const initialState: EthnicityCodeListState = <EthnicityCode[]>[];

export function ethnicityCodeListReducer(state = initialState, action: Action): EthnicityCodeListState {
  switch (action.type) {
    case SetupActions.FIND_ETHNICITY_CODES_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}
